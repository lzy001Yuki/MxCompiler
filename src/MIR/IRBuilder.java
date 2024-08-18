package MIR;

import AST.ASTVisitor;
import AST.Def.*;
import AST.Expr.*;
import AST.ProgramNode;
import AST.Stat.*;
import MIR.Instruction.*;
import MIR.irEntity.*;
import MIR.type.*;
import MIR.utils.anonyName;
import MIR.utils.block;
import com.sun.jdi.VoidType;
import utils.DataType;
import utils.Error;
import utils.FuncType;
import utils.Pair;
import utils.Scope.ClassScope;
import utils.Scope.FuncScope;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;
import MIR.Instruction.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IRBuilder implements ASTVisitor {
    public GlobalScope globalScope;
    public Scope currentScope;
    public block curBlock = null;
    public function curFunc = null;
    public HashMap<String, Integer> varRename = null;
    public anonyName generator = new anonyName();
    public IRBuilder(GlobalScope global) {
        globalScope = global;
        currentScope = global;
        varRename = new HashMap<>();
    }
    @Override
    public void visit(ProgramNode it){
        curFunc = new function("global_init", new voidType(), false, null);
        curBlock = new block("entry", curFunc);
        curFunc.addBlock(curBlock);
        for (var def: it.definition) {
            if (def instanceof classDefNode) {
                globalClass newCls = new globalClass(((classDefNode) def).className);
                globalScope.addIrClass(newCls);
                for (Map.Entry<String, Pair<Integer,varDefAtomNode>> entry: ((classDefNode) def).varMap.entrySet()) {
                    newCls.members.add(IRType.dataToIR(entry.getValue().getSecond().type));
                }
                globalScope.addBasicInst(new BasicInst(newCls.print()));
                def.accept(this);
            } else if (def instanceof varDefNode) {
                for (var varDef: ((varDefNode) def).varList) {
                    String newName = rename(varDef.varName);
                    globalVar gVar;
                    if (varDef.assignNode != null) {
                        varDef.assignNode.accept(this);
                        if (varDef.assignNode.entity.isConst())  gVar = new globalVar(IRType.dataToIR(varDef.type), newName, varDef.assignNode.entity);
                        else {
                            gVar = new globalVar(IRType.dataToIR(varDef.type), newName);
                            globalVar pointer = new globalVar(varDef.assignNode.entity);
                            localVar local = new localVar(((ptrType)pointer.type).baseType, generator.getName());
                            curBlock.addInst(new LoadInst(local, pointer));
                            curBlock.addInst(new StoreInst(local, gVar));
                        }
                    } else gVar = new globalVar(IRType.dataToIR(varDef.type), newName);
                    globalScope.addBasicInst(new BasicInst(gVar.print()));
                    globalScope.addPtr(varDef.varName, gVar);
                }
                curBlock = curFunc.blocks.getFirst();
            } else if (def instanceof funcDefNode) {
                curBlock = new block("entry", curFunc);
                curFunc = new function(((funcDefNode) def).funcName,
                        IRType.dataToIR(((funcDefNode) def).returnType), false, null);
                curFunc.addBlock(curBlock);
                globalScope.addIrFunction(((funcDefNode) def).funcName, curFunc);
                def.accept(this);
                curFunc = curBlock.parentFunc;
                curBlock = null;
            }
        }
        curBlock = curFunc.blocks.getFirst();
        curBlock.addInst(new RetInst(new voidType(), null));
        globalScope.addIrFunction("global_init", curFunc);
        curBlock = null;
        for (var def: it.definition) {
            if (def instanceof mainDefNode) def.accept(this);
        }
    }
    @Override
    public void visit(arrayExprNode it){
        // consider one dimension
        function func = globalScope.getIrFunction("_malloc_");
        function callFunc = new function(func.irName, func.type, false, null);
        if (it.iniList != null) {
            it.iniList.assignNode = it.assignExpr;
            it.iniList.accept(this);
            return;
        }
        int len = ((atomExprNode)it.indexList.getFirst()).intExpr.value;
        DataType preType = new DataType(it.type);
        localPtr malloc_ptr = new localPtr(IRType.dataToIR(preType), rename("malloc_ptr"));
        CallInst inst1 = new CallInst(callFunc, malloc_ptr.irName);
        inst1.para.add(new constInt(len * 4 + 4));
        curBlock.addInst(inst1);
        StoreInst inst2 = new StoreInst(new constInt(len), malloc_ptr);
        curBlock.addInst(inst2);
        it.entity = new localPtr(((ptrType)(malloc_ptr.type)).baseType, rename("array_ptr"));
        GetelementInst inst3 = new GetelementInst((localPtr) it.entity, malloc_ptr);
        inst3.index.add(new constInt(1));
        curBlock.addInst(inst3);
        int indexSize = it.indexList.size();
        indexSize--;
        if (indexSize != 0) {
            // assign at the same time if init != NULL
            localPtr iter_ptr = new localPtr(new intType(), rename("iter_ptr"));
            AllocaInst inst4 = new AllocaInst(iter_ptr, new intType(), null);
            curBlock.addInst(inst4);
            StoreInst inst = new StoreInst(new constInt(0), iter_ptr);
            curBlock.addInst(inst);
            String condStr = rename("for.cond");
            BrInst inst7 = new BrInst(null, condStr, null);
            curBlock.addInst(inst7);
            curFunc.addBlock(curBlock);
            multiInit(indexSize, it.indexList, null, iter_ptr, null,(localPtr) it.entity, null, condStr);
        }

    }

    private void multiInit(int dim, ArrayList<ExprNode> array, localPtr pre_ptr, localPtr iter_ptr,localPtr pre_array,  localPtr array_ptr, String preLabel, String label) {
        curBlock = new block(label, curFunc);
        localVar result = new localVar(new boolType(), rename(IcmpInst.advertCmp("<") + ".result"));
        IcmpInst inst3 = new IcmpInst(result, "<", loadPtr(iter_ptr), new constInt(((atomExprNode) array.get(array.size() - dim - 1)).intExpr.value));
        curBlock.addInst(inst3);
        String bodyStr = rename("for.body");
        String endStr = rename("for.end");
        String stepStr = rename("for.step");
        BrInst inst4 = new BrInst(result, bodyStr, endStr);
        curBlock.addInst(inst4);
        curFunc.addBlock(curBlock);
        curBlock = new block(bodyStr, curFunc);
        localPtr malloc_ptr = new localPtr(new ptrType(new ptrType()), rename("malloc_ptr"));
        function func = globalScope.getIrFunction("_malloc_");
        function callFunc = new function(func.irName, func.type, false, null);
        int len = ((atomExprNode) array.get(array.size() - dim)).intExpr.value;
        CallInst inst8 = new CallInst(callFunc, malloc_ptr.irName);
        inst8.para.add(new constInt(len * 4 + 4));
        curBlock.addInst(inst8);
        StoreInst inst9 = new StoreInst(new constInt(((atomExprNode) array.get(array.size() - dim)).intExpr.value), malloc_ptr);
        curBlock.addInst(inst9);
        localPtr new_array_ptr = new localPtr(((ptrType) (malloc_ptr.type)).baseType, rename("array_ptr"));
        GetelementInst inst11 = new GetelementInst(new_array_ptr, malloc_ptr);
        inst11.index.add(new constInt(1));
        curBlock.addInst(inst11);
        dim--;
        if (dim != 0)  {
            localPtr new_iter = new localPtr(new intType(), rename("iter_ptr"));
            AllocaInst inst10 = new AllocaInst(new_iter, new intType(), null);
            curBlock.addInst(inst10);
            StoreInst inst12 = new StoreInst(new constInt(0), new_iter);
            curBlock.addInst(inst12);
            String newCond = rename("for.cond");
            BrInst inst13 = new BrInst(null, newCond, null);
            curBlock.addInst(inst13);
            curFunc.addBlock(curBlock);
            multiInit(dim, array, iter_ptr, new_iter, array_ptr, new_array_ptr, stepStr, newCond);
        }  else {
            localVar var2 = (localVar) loadPtr(iter_ptr);
            localPtr nextPtr = new localPtr(((ptrType)(array_ptr.type)).baseType, rename("next_ptr"));
            GetelementInst inst13 = new GetelementInst(nextPtr, array_ptr);
            inst13.index.add(var2);
            curBlock.addInst(inst13);
            StoreInst inst14 = new StoreInst(new_array_ptr, nextPtr);
            curBlock.addInst(inst14);
            BrInst inst15 = new BrInst(null, stepStr, null);
            curBlock.addInst(inst15);
            curFunc.addBlock(curBlock);
        }
        curBlock = new block(stepStr, curFunc);
        localVar res = new localVar(new intType(), rename(BinaryInst.advertOp("+") + ".result"));
        BinaryInst inst5 = new BinaryInst(res, "+", loadPtr(iter_ptr), new constInt(1));
        curBlock.addInst(inst5);
        StoreInst inst6 = new StoreInst(res, iter_ptr);
        curBlock.addInst(inst6);
        BrInst inst7 = new BrInst(null, label, null);
        curBlock.addInst(inst7);
        curFunc.addBlock(curBlock);
        curBlock = new block(endStr, curFunc);
        if (dim != array.size() - 2) {
            localVar var3 = (localVar) loadPtr(pre_ptr);
            localPtr ptr3 = new localPtr(((ptrType) (pre_array.type)).baseType, rename("next_ptr"));
            GetelementInst inst16 = new GetelementInst(ptr3, pre_array);
            inst16.index.add(var3);
            curBlock.addInst(inst16);
            StoreInst inst18 = new StoreInst(array_ptr, pre_array);
            curBlock.addInst(inst18);
            BrInst inst17 = new BrInst(null, preLabel, null);
            curBlock.addInst(inst17);
            curFunc.addBlock(curBlock);
        }
    }

    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.rhs.entity != null) {
            StoreInst inst = new StoreInst(loadPtr(it.rhs.entity), it.lhs.entity);
            curBlock.addInst(inst);
        }
    }
    @Override
    public void visit(atomExprNode it) {
        if (it.boolExpr != null) {
            it.entity = new constBool(it.boolExpr.value);
        } else if (it.intExpr != null) {
            it.entity = new constInt(it.intExpr.value);
        } else if (it.nullExpr != null) {
            it.entity = new constNull();
        } else if (it.strExpr != null) {
            it.entity = new constString(rename(".str"), it.strExpr.value);
            globalScope.addBasicInst(new BasicInst(it.entity.toString()));
        } else if (it.id != null) {
            it.entity = currentScope.getPtrGlobally(it.id);
            if (it.entity instanceof memberPtr) {
                localPtr newPtr = (localPtr) loadPtr(((memberPtr) it.entity).parent);
                localPtr res = new localPtr(((ptrType)it.entity.type).baseType, rename("this." + it.id));
                GetelementInst inst = new GetelementInst(res, newPtr);
                inst.index.add(new constInt(0));
                inst.index.add(new constInt(((memberPtr) it.entity).index));
                curBlock.addInst(inst);
                it.entity = res;
            }
            if (it.entity == null) {
                function func = globalScope.getIrFunction(it.id);
                it.entity = new function(func.irName, func.type, false, null);
            }
        }
    }
    @Override
    public void visit(basicExprNode it){
        it.exprNode.accept(this);
        it.entity = it.exprNode.entity;
    }
    @Override
    public void visit(binaryExprNode it){
        it.lhs.accept(this);
        it.rhs.accept(this);
        it.lhs.entity = loadPtr(it.lhs.entity);
        it.rhs.entity = loadPtr(it.rhs.entity);
        if (it.lhs.type.typeName.equals("string")) {
            function func;
            if (isBinary(it.opStr)) func = globalScope.getIrFunction("string." + BinaryInst.advertOp(it.opStr));
            else func = globalScope.getIrFunction("string." + IcmpInst.advertCmp(it.opStr));
            function callFunc = new function(func.irName, func.type, false, null);
            it.entity = new localVar(func.type, generator.getName());
            CallInst inst = new CallInst(callFunc, it.entity.irName);
            inst.para.add(it.lhs.entity);
            inst.para.add(it.rhs.entity);
            curBlock.addInst(inst);
            return;
        }
        if (isBinary(it.opStr)) {
            localVar res = new localVar(it.lhs.entity.type, rename(BinaryInst.advertOp(it.opStr) + ".result"));
            BinaryInst inst = new BinaryInst(res, it.opStr, it.lhs.entity, it.rhs.entity);
            curBlock.addInst(inst);
            it.entity = res;
        } else {
            localVar res = new localVar(new boolType(), rename(IcmpInst.advertCmp(it.opStr) + ".result"));
            IcmpInst inst = new IcmpInst(res, it.opStr, it.lhs.entity, it.rhs.entity);
            curBlock.addInst(inst);
            it.entity = res;
        }
    }
    @Override
    public void visit(cFormatExpr it){}
    @Override
    public void visit(funcExprNode it){
        it.exprNode.accept(this);
        CallInst inst = new CallInst((function) it.exprNode.entity, generator.getName());
        for (var para: it.paraList) {
            para.accept(this);
            inst.para.add(loadPtr(para.entity));
        }
        curBlock.addInst(inst);
        it.entity = inst.ret;
    }
    @Override
    public void visit(indexExprNode it){
        it.exprNode.accept(this);
        localPtr res = new localPtr("here");
        localPtr cur = (localPtr) it.exprNode.entity;
        for (int i = 0; i < it.index.size(); i++) {
            cur = (localPtr) loadPtr(cur);
            res = new localPtr(((ptrType) cur.type).baseType, rename("array_ptr"));
            GetelementInst inst = new GetelementInst(res, cur);
            inst.index.add(new constInt(((atomExprNode)it.index.get(i)).intExpr.value));
            curBlock.addInst(inst);
        }
        it.entity = res;
    }
    @Override
    public void visit(initArrayExprNode it){
        ArrayList<ExprNode> index = new ArrayList<>();
        if (it.assignNode == null) {
            it.assignNode = new
        }
        initToNew(it, 0, index, it.assignNode);
    }

    // 最后store
    public void initToNew(ExprNode it, int dim, ArrayList<ExprNode> index, ExprNode type) {
        assignExprNode assign = new assignExprNode(null);
        if (it instanceof initArrayExprNode) {
            arrayExprNode array = new arrayExprNode(null);
            atomExprNode length = new atomExprNode(null);
            length.intExpr = new cIntExpr(((initArrayExprNode) it).list.size());
            array.indexList.add(length);
            array.type = it.type;
            assign.rhs = array;
            if (dim == 0) {
                assign.lhs = type;
            } else {
                assign.lhs = new indexExprNode(null);
                ((indexExprNode)assign.lhs).exprNode = type;
                ((indexExprNode)assign.lhs).index = index;
            }
            assign.accept(this);
            for (int i = 0; i < ((initArrayExprNode) it).list.size(); i++) {
                atomExprNode atom = new atomExprNode(null);
                atom.intExpr = new cIntExpr(i);
                index.add(atom);
                initToNew(((initArrayExprNode) it).list.get(i), dim + 1, index, type);
            }
            if (!index.isEmpty())  index.removeLast();
        } else if (it instanceof atomExprNode) {
            assign.rhs = it;
            assign.lhs = new indexExprNode(null);
            ((indexExprNode)assign.lhs).exprNode = type;
            ((indexExprNode)assign.lhs).index = index;
            assign.accept(this);
            index.removeLast();
        } else throw new RuntimeException("Error in initToNew");
    }

    @Override
    public void visit(memberExprNode it){
        it.obj.accept(this);
        it.obj.entity = loadPtr(it.obj.entity);
        if (it.obj.type.typeName.equals("string")) {
            function func = globalScope.getIrFunction("string." + it.member);
            it.entity = new function(func.irName, func.type, false, null);
            ((function) it.entity).paraList.add(it.obj.entity);
            return;
        }
        if (it.obj.type.isArray) {
            function func = globalScope.getIrFunction("array." + it.member);
            it.entity = new function(func.irName, func.type, false, null);
            ((function) it.entity).paraList.add(it.obj.entity);
            return;
        }
        classDefNode object = globalScope.getClass(it.obj.type.typeName);
        if (it.type instanceof FuncType) {
            function func = globalScope.getIrFunction(it.member);
            it.entity = new function(func.irName, func.type, false, object.className);
            ((function) it.entity).paraList.add(it.obj.entity);
        } else {
            localPtr result = new localPtr(IRType.dataToIR(it.type), rename(it.member + "_ptr"));
            GetelementInst inst = new GetelementInst(result, (localPtr) it.obj.entity);
            inst.index.add(new constInt(0));
            inst.index.add(new constInt(object.varMap.get(it.member).getFirst()));
            curBlock.addInst(inst);
            it.entity = result;
        }
    }
    @Override
    public void visit(ternaryExprNode it){
        String firStr = rename("ternary_first");
        String secStr = rename("ternary_second");
        String endStr = rename("ternary_end");
        it.expr1.accept(this);
        it.expr1.entity = loadPtr(it.expr1.entity);
        BrInst inst1 = new BrInst((localVar) it.expr1.entity, firStr, secStr);
        curBlock.addInst(inst1);
        curFunc.addBlock(curBlock);
        curBlock = new block(firStr, curFunc);
        it.expr2.accept(this);
        it.expr2.entity = loadPtr(it.expr2.entity);
        curBlock.addInst(new BrInst(null, endStr, null));
        curFunc.addBlock(curBlock);
        curBlock = new block(secStr, curFunc);
        it.expr3.accept(this);
        it.expr3.entity = loadPtr(it.expr3.entity);
        curBlock.addInst(new BrInst(null, endStr, null));
        curFunc.addBlock(curBlock);
        curBlock = new block(endStr, curFunc);
        localVar local = new localVar(it.expr2.entity.type, generator.getName());
        PhiInst inst2 = new PhiInst(local);
        inst2.jump.add(new Pair<>(it.expr2.entity, firStr));
        inst2.jump.add(new Pair<>(it.expr3.entity, secStr));
        curBlock.addInst(inst2);
        it.entity = it.expr2.entity;
    }
    @Override
    public void visit(unaryExprNode it){
        it.exprNode.accept(this);
        localVar local = (localVar) loadPtr(it.exprNode.entity);
        if (it.opStr.equals("+")) {
            it.entity = local;
            return;
        }
        localVar res = new localVar(local.type, rename("unary.result"));
        switch (it.opStr) {
            case ("!") :{
                BinaryInst inst = new BinaryInst(res, "^", local, new constBool(true));
                curBlock.addInst(inst);
                it.entity = res;
                break;
            }
            case ("-") :{
                BinaryInst inst = new BinaryInst(res, "-", new constInt(0), local);
                curBlock.addInst(inst);
                it.entity = res;
                break;
            }
            case ("~") :{
                BinaryInst inst = new BinaryInst(res, "^", new constInt(-1), local);
                curBlock.addInst(inst);
                it.entity = res;
                break;
            }
            case ("++") :{
                BinaryInst inst1 = new BinaryInst(res, "+", new constInt(1), local);
                curBlock.addInst(inst1);
                StoreInst inst2 = new StoreInst(res, it.exprNode.entity);
                curBlock.addInst(inst2);
                if (it.preOp)  {
                    it.exprNode.entity = loadPtr(it.exprNode.entity);
                    it.entity = it.exprNode.entity;
                }
                else it.entity = local;
                break;
            }
            case ("--") :{
                BinaryInst inst1 = new BinaryInst(res, "-", local, new constInt(1));
                curBlock.addInst(inst1);
                StoreInst inst2 = new StoreInst(res, it.exprNode.entity);
                curBlock.addInst(inst2);
                if (it.preOp)  {
                    it.exprNode.entity = loadPtr(it.exprNode.entity);
                    it.entity = it.exprNode.entity;
                }  else it.entity = local;
                break;
            }
        }
    }
    @Override
    public void visit(varExprNode it){
        it.entity = new localPtr(new ptrType(new classType(it.type.typeName)), rename(it.type.typeName + "_ptr"));
        function malloc_ = globalScope.getIrFunction("_malloc_");
        function func = new function(malloc_.irName, malloc_.type, false, null);
        classDefNode obj = globalScope.getClass(it.type.typeName);
        CallInst inst = new CallInst(func, it.entity.irName);
        inst.para.add(new constInt(obj.varMap.size() * 4));
        curBlock.addInst(inst);
    }

    @Override
    public void visit(blockStatNode it){
        currentScope = new Scope(currentScope);
        Scope cur = currentScope;
        for (var stat: it.statList) {
            if (cur != currentScope) break;
            stat.accept(this);
        }
        if (currentScope == cur) currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(breakStatNode it){
        while (!currentScope.isLoopScope && currentScope != null) {
            currentScope = currentScope.parentScope;
        }
        currentScope.flag = false;
    }
    @Override
    public void visit(continueStatNode it){
        while (!currentScope.isLoopScope && currentScope != null) {
            currentScope = currentScope.parentScope;
        }
        currentScope.flag = true;
    }
    @Override
    public void visit(exprStatNode it){
        it.exprNode.accept(this);
    }
    @Override
    public void visit(forStatNode it){
        currentScope = new Scope(currentScope, true);
        if (it.initExpr != null) it.initExpr.accept(this);
        else if (it.initStat != null) it.initStat.accept(this);
        String condStr = rename("for.cond");
        String bodyStr = rename("for.body");
        String endStr = rename("for.end");
        String stepStr = rename("for.step");
        currentScope.begLab = condStr;
        currentScope.endLab = endStr;
        curBlock.addInst(new BrInst(null, condStr, null));
        curFunc.addBlock(curBlock);
        curBlock = new block(condStr, curFunc);
        if (it.condExpr != null) {
            it.condExpr.accept(this);
            curBlock.addInst(new BrInst((localVar) it.condExpr.entity, bodyStr, endStr));
        }
        curFunc.addBlock(curBlock);
        curBlock = new block(bodyStr, curFunc);
        if (it.stat != null) {
            currentScope = new Scope(currentScope);
            Scope cur = currentScope;
            it.stat.accept(this);
            if (cur == currentScope)  curBlock.addInst(new BrInst(null, stepStr, null));
            else curBlock.addInst(new BrInst(null, (currentScope.flag) ? currentScope.begLab : currentScope.endLab, null));
            currentScope = cur.parentScope;
        }
        curFunc.addBlock(curBlock);
        curBlock = new block(stepStr, curFunc);
        if (it.stepExpr != null) {
            it.stepExpr.accept(this);
            curBlock.addInst(new BrInst(null, condStr, null));
        }
        curFunc.addBlock(curBlock);
        curBlock = new block(endStr, curFunc);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(ifStatNode it){
        it.conExpr.accept(this);
        String str1 = rename("if.true");
        String str2 = rename("if.false");
        String str3 = rename("if.end");
        BrInst inst1;
        if (it.elseStat != null)  inst1 = new BrInst((localVar) it.conExpr.entity, str1, str2);
        else inst1 = new BrInst((localVar) it.conExpr.entity, str1, str3);
        curBlock.addInst(inst1);
        curFunc.addBlock(curBlock);
        curBlock = new block(str1, curFunc);
        currentScope = new Scope(currentScope);
        Scope cur = currentScope;
        it.ifStat.accept(this);
        if (currentScope == cur) curBlock.addInst(new BrInst(null, str3, null));
        else curBlock.addInst(new BrInst(null, (currentScope.flag) ?currentScope.begLab :currentScope.endLab, null));
        currentScope = cur.parentScope;
        curFunc.addBlock(curBlock);
        if (it.elseStat != null) {
            currentScope = new Scope(currentScope);
            cur = currentScope;
            curBlock = new block(str2, curFunc);
            it.elseStat.accept(this);
            if (currentScope == cur)  curBlock.addInst(new BrInst(null, str3, null));
            else curBlock.addInst(new BrInst(null, (currentScope.flag) ?currentScope.begLab :currentScope.endLab, null));
            currentScope = cur.parentScope;
            curFunc.addBlock(curBlock);
        }
        curBlock = new block(str3, curFunc);
    }
    @Override
    public void visit(returnStatNode it){
        if (it.exprNode != null) {
            it.exprNode.accept(this);
            curBlock.addInst(new RetInst(loadPtr(it.exprNode.entity)));
        }
    }
    @Override
    public void visit(varStatNode it){
        it.varDef.accept(this);
    }
    @Override
    public void visit(whileStatNode it){
        String condStr = rename("while.cond");
        BrInst inst1 = new BrInst(null, condStr, null);
        curBlock.addInst(inst1);
        curFunc.addBlock(curBlock);
        curBlock = new block(condStr, curFunc);
        it.whileExpr.accept(this);
        String endStr = rename("while.end");
        String bodyStr = rename("while.body");
        BrInst inst2 = new BrInst((localVar) it.whileExpr.entity, bodyStr, endStr);
        currentScope = new Scope(currentScope, true);
        currentScope.begLab = condStr;
        currentScope.endLab = endStr;
        curBlock.addInst(inst2);
        curFunc.addBlock(curBlock);
        curBlock = new block(bodyStr, curFunc);
        it.whileStat.accept(this);
        BrInst inst3 = new BrInst(null, condStr, null);
        curBlock.addInst(inst3);
        curFunc.addBlock(curBlock);
        curBlock = new block(endStr, curFunc);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(classDefNode it){
        currentScope = new ClassScope(currentScope);
        currentScope.className = it.className;
        for (Map.Entry<String, Pair<Integer, varDefAtomNode>> entry: it.varMap.entrySet()) {
            varDefAtomNode value = entry.getValue().getSecond();
            memberPtr mPtr = new memberPtr(IRType.dataToIR(value.type), value.varName, it.className, entry.getValue().getFirst());
            mPtr.parent = new localPtr(new localPtr(new classType(it.className), "this").type, "this_ptr");
            currentScope.addPtr(value.varName, mPtr);
        }
        if (it.constructor != null) {
            it.constructor.accept(this);
            globalScope.addIrFunction(it.className, curFunc);
            curFunc = curBlock.parentFunc;
            curBlock = null;
        }
        for (Map.Entry<String, funcDefNode> entry: it.funcMap.entrySet()) {
            curBlock = new block("entry", curFunc);
            curFunc = new function(it.className + "." + entry.getKey(), IRType.dataToIR(entry.getValue().returnType), true, it.className);
            entry.getValue().accept(this);
            curFunc.addBlock(curBlock);
            globalScope.addIrFunction(entry.getKey(), curFunc);
            curFunc = curBlock.parentFunc;
            curBlock = null;
        }
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(constructNode it){
        currentScope = new FuncScope(currentScope, new DataType("void"));
        curBlock = new block("entry", curFunc);
        curFunc = new function(it.className + "." + it.className, new voidType(), true, it.className);
        localPtr ptr = new localPtr(curFunc.paraList.getFirst().type, "this_ptr");
        curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
        curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        it.blockStat.accept(this);
        curBlock.addInst(new RetInst(new voidType(), null));
        curFunc.addBlock(curBlock);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(funcDefNode it){
        currentScope = new FuncScope(currentScope, it.returnType);
        if (curFunc.isMember) {
            localPtr ptr = new localPtr(curFunc.paraList.getFirst().type, "this_ptr");
            curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
            curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        }
        for (var para: it.para.paraList) {
            localVar vari = new localVar(IRType.dataToIR(para.paraType), rename(para.paraName) + "_para");
            curFunc.addPara(vari);
            Ptr ptr = new localPtr(vari.type, vari.irName.replace("_para", "_ptr"));
            currentScope.addPtr(para.paraName, ptr);
            curBlock.addInst(new AllocaInst(ptr, vari.type, null));
            curBlock.addInst(new StoreInst(vari, ptr));
        }
        it.funcBlock.accept(this);
        if (it.returnType.typeName.equals("void"))  curBlock.addInst(new RetInst(new voidType(), null));
    }
    @Override
    public void visit(mainDefNode it){
        currentScope = new FuncScope(currentScope, new DataType("int"));
        curFunc = new function("main", new intType(), false, null);
        curBlock = new block("entry", curFunc);
        function init_ = globalScope.getIrFunction("global_init");
        CallInst inst = new CallInst(init_, null);
        curBlock.addInst(inst);
        it.blockStat.accept(this);
        curFunc.addBlock(curBlock);
        globalScope.addIrFunction("main", curFunc);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(paraListNode it){}
    @Override
    public void visit(varDefAtomNode it){
        DataType copy = new DataType(it.type);
        localPtr ptr = new localPtr(IRType.dataToIR(copy), rename(it.varName + "_ptr"));
        currentScope.addPtr(it.varName, ptr);
        curBlock.addInst(new AllocaInst(ptr, ((ptrType)ptr.type).baseType, null));
        if (it.assignNode != null) {
            it.assignNode.accept(this);
            if (it.assignNode.entity != null && it.assignNode.entity.isConst()) {
                curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
                if (it.type.typeName.equals("string")) {
                    ((ptrType) ptr.type).baseType = it.assignNode.entity.type;
                }
            }  else {
                if (it.assignNode.entity != null) curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
            }
        }
    }
    @Override
    public void visit(varDefNode it){
        for (var def: it.varList) {
            def.accept(this);
        }
    }

    private String rename(String name) {
        if (varRename.containsKey(name)) {
            int num = varRename.get(name);
            num++;
            varRename.put(name, num);
            return name + "." + num;
        } else {
            varRename.put(name, 0);
            return name;
        }
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (function builtIn: globalScope.builtInFunc.values()) {
            ans.append(builtIn.declare());
        }
        ans.append("\n");
        for (var inst: globalScope.globalInst) {
            ans.append(inst).append("\n");
        }
        ans.append("\n");
        for (function func: globalScope.irFunction.values()) {
            ans.append(func).append("\n");
        }
        return ans.toString();
    }
    private Entity loadPtr(Entity it) {
        if (it.type instanceof ptrType) {
            Entity local;
            if (((ptrType) it.type).baseType == null) return it;
            if (((ptrType) it.type).baseType instanceof ptrType) local = new localPtr(((ptrType) ((ptrType) it.type).baseType).baseType, generator.getName());
            else local = new localVar(((ptrType)it.type).baseType, generator.getName());
            LoadInst inst = new LoadInst(local, it);
            curBlock.addInst(inst);
            return local;
        } else return it;
    }
    private boolean isBinary(String op) {
        return !op.equals("==") && !op.equals(">=") && !op.equals("<=") && !op.equals("!=") && !op.equals("<") && !op.equals(">");
    }
}
