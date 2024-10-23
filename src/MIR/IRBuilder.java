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
    public function init_;
    public localPtr thisPtr = null;
    public IRBuilder(GlobalScope global) {
        globalScope = global;
        currentScope = global;
        varRename = new HashMap<>();
    }
    @Override
    public void visit(ProgramNode it){
        init_ = new function("global_init", new voidType(), false, null);
        curBlock = new block("entry", init_);
        curFunc = init_;
        curFunc.addBlock(curBlock);
        for (var def: it.definition) {
            if (def instanceof classDefNode) {
                globalClass newCls = new globalClass(((classDefNode) def).className);
                globalScope.addIrClass(newCls);
                for (Map.Entry<String, Pair<Integer,varDefAtomNode>> entry: ((classDefNode) def).varMap.entrySet()) {
                    int dim = entry.getValue().getSecond().type.arrayDim;
                    newCls.members.add(IRType.dataToIR(entry.getValue().getSecond().type));
                    entry.getValue().getSecond().type.arrayDim = dim;
                    if (dim != 0) entry.getValue().getSecond().type.isArray = true;
                }
                globalScope.addBasicInst(newCls, new BasicInst(newCls.print()));
                //def.accept(this);
                for (Map.Entry<String, funcDefNode> entry: ((classDefNode) def).funcMap.entrySet()) {
                    int dim = entry.getValue().returnType.arrayDim;
                    function classFunc = new function(((classDefNode) def).className + "." + entry.getKey(), IRType.dataToIR(entry.getValue().returnType), true, ((classDefNode) def).className);
                    entry.getValue().returnType.arrayDim = dim;
                    if (dim != 0) entry.getValue().returnType.isArray = true;
                    globalScope.addIrFunction(classFunc.irName, classFunc);
                }
                if (((classDefNode) def).constructor != null) {
                    function constFunc = new function(((classDefNode) def).className + "." + ((classDefNode) def).className, new voidType(), true, ((classDefNode) def).className);
                    globalScope.addIrFunction(constFunc.irName, constFunc);
                }
            } else if (def instanceof varDefNode) {
                for (var varDef: ((varDefNode) def).varList) {
                    String newName = rename(varDef.varName);
                    int dim = varDef.type.arrayDim;
                    globalVar gVar = new globalVar(IRType.dataToIR(varDef.type), newName);
                    varDef.type.arrayDim = dim;
                    if (dim != 0) varDef.type.isArray = true;
                    globalScope.addPtr(varDef.varName, gVar);
                    if (varDef.assignNode != null) {
                        varDef.assignNode.accept(this);
                        if (varDef.assignNode.entity != null) {
                            if (varDef.assignNode.entity.isConst()) gVar.init = varDef.assignNode.entity;
                            else {
                                if (!(varDef.assignNode instanceof arrayExprNode || varDef.assignNode instanceof initArrayExprNode || varDef.assignNode instanceof varExprNode || varDef.assignNode instanceof funcExprNode)) {
//                                    localVar local = new localVar(varDef.assignNode.entity.type, generator.getName());
//                                    curBlock.addInst(new LoadInst(local, varDef.assignNode.entity));
                                    curBlock.addInst(new StoreInst(loadPtr(varDef.assignNode.entity), gVar));
                                }  else if (!(varDef.assignNode instanceof initArrayExprNode))curBlock.addInst(new StoreInst(varDef.assignNode.entity, gVar));

                            }
                        }
                    }
                    globalScope.addBasicInst(gVar, new BasicInst(gVar.print()));
                }
            } else if (def instanceof funcDefNode) {
                //curBlock = new block("entry", curFunc);
                int dim = ((funcDefNode) def).returnType.arrayDim;
                curFunc = new function(((funcDefNode) def).funcName,
                        IRType.dataToIR(((funcDefNode) def).returnType), false, null);
                //curFunc.addBlock(curBlock);
                ((funcDefNode) def).returnType.arrayDim = dim;
                if (dim != 0) ((funcDefNode) def).returnType.isArray = true;
                globalScope.addIrFunction(((funcDefNode) def).funcName, curFunc);
                //def.accept(this);
                curFunc = init_;
                curBlock = init_.blocks.getLast();
            }
        }
        curBlock = init_.blocks.getLast();
        curBlock.addInst(new RetInst(new voidType(), null));
        init_.retBlks.add(curBlock);
        globalScope.addIrFunction("global_init", init_);
        curBlock = null;
        for (var funcDef: it.definition) {
            if (funcDef instanceof classDefNode) funcDef.accept(this);
            if (funcDef instanceof funcDefNode && ! (funcDef instanceof mainDefNode)) {
                curFunc = globalScope.getIrFunction(((funcDefNode) funcDef).funcName);
                curBlock = new block("entry", curFunc);
                curFunc.addBlock(curBlock);
                funcDef.accept(this);
            }
        }
        for (var def: it.definition) {
            if (def instanceof mainDefNode) {
                currentScope = new FuncScope(currentScope, new DataType("int"));
                curFunc = new function("main", new intType(), false, null);
                curBlock = new block("entry", curFunc);
                curFunc.addBlock(curBlock);
                function init_ = globalScope.getIrFunction("global_init");
                CallInst inst = new CallInst(init_, "void_return");
                curBlock.addInst(inst);
                def.accept(this);
                globalScope.addIrFunction("main", curFunc);
                currentScope = currentScope.parentScope;
            }
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
        for (var def: it.indexList) {
            def.accept(this);
        }
        DataType preType = new DataType(it.type);
        localPtr malloc_ptr = new localPtr(IRType.dataToIR(preType), rename("malloc_ptr"));
        CallInst inst1 = new CallInst(callFunc, malloc_ptr);
        Entity indexVar  = loadPtr(it.indexList.getFirst().entity);
        inst1.para.add(calLength(indexVar));
        curBlock.addInst(inst1);
        StoreInst inst2 = new StoreInst(indexVar, malloc_ptr);
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
            multiInit(indexSize, it.indexList, null, iter_ptr, null,(localPtr) it.entity, null, condStr);
        }

    }
    private void multiInit(int dim, ArrayList<ExprNode> array, localPtr pre_ptr, localPtr iter_ptr,localPtr pre_array,  localPtr array_ptr, String preLabel, String label) {
        curBlock = new block(label, curFunc);
        curFunc.addBlock(curBlock);
        localVar result = new localVar(new boolType(), rename(IcmpInst.advertCmp("<") + ".result"));
        IcmpInst inst3 = new IcmpInst(result, "<", loadPtr(iter_ptr), loadPtr(array.get(array.size() - dim - 1).entity));
        curBlock.addInst(inst3);
        String bodyStr = rename("for.body");
        String endStr = rename("for.end");
        String stepStr = rename("for.step");
        BrInst inst4 = new BrInst(result, bodyStr, endStr);
        curBlock.addInst(inst4);
        curBlock = new block(bodyStr, curFunc);
        curFunc.addBlock(curBlock);
        localPtr malloc_ptr = new localPtr(new ptrType(new ptrType()), rename("malloc_ptr"));
        function func = globalScope.getIrFunction("_malloc_");
        function callFunc = new function(func.irName, func.type, false, null);
        CallInst inst8 = new CallInst(callFunc, malloc_ptr);
        Entity indexVar = loadPtr(array.get(array.size() - dim).entity);
        inst8.para.add(calLength(indexVar));
        curBlock.addInst(inst8);
        StoreInst inst9 = new StoreInst(indexVar, malloc_ptr);
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
        }
        curBlock = new block(stepStr, curFunc);
        curFunc.addBlock(curBlock);
        localVar res = new localVar(new intType(), rename(BinaryInst.advertOp("+") + ".result"));
        BinaryInst inst5 = new BinaryInst(res, "+", loadPtr(iter_ptr), new constInt(1));
        curBlock.addInst(inst5);
        StoreInst inst6 = new StoreInst(res, iter_ptr);
        curBlock.addInst(inst6);
        BrInst inst7 = new BrInst(null, label, null);
        curBlock.addInst(inst7);
        curBlock = new block(endStr, curFunc);
        curFunc.addBlock(curBlock);
        if (dim != array.size() - 2) {
            localVar var3 = (localVar) loadPtr(pre_ptr);
            localPtr ptr3 = new localPtr(((ptrType) (pre_array.type)).baseType, rename("next_ptr"));
            GetelementInst inst16 = new GetelementInst(ptr3, pre_array);
            inst16.index.add(var3);
            curBlock.addInst(inst16);
            StoreInst inst18 = new StoreInst(array_ptr, ptr3);
            curBlock.addInst(inst18);
            BrInst inst17 = new BrInst(null, preLabel, null);
            curBlock.addInst(inst17);
        }
    }

    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.rhs.entity != null) {
            StoreInst inst;
            if (it.rhs instanceof arrayExprNode || it.rhs.entity.isConst() || it.rhs instanceof varExprNode || it.rhs instanceof funcExprNode || it.rhs instanceof ternaryExprNode) {
                inst = new StoreInst(it.rhs.entity, it.lhs.entity);
            } else inst = new StoreInst(loadPtr(it.rhs.entity), it.lhs.entity);
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
            it.entity = new constString(rename("const.str"), getStr(it.strExpr.value));
            globalScope.addString((constString) it.entity);
            globalScope.addBasicInst(it.entity, new BasicInst(it.entity.toString()));
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
                function func = null;
                if (currentScope.isInClass() != null) func = globalScope.getIrFunction(currentScope.isInClass() + "." + it.id);
                if (func == null) func = globalScope.getIrFunction(it.id);
                if (func == null) throw new RuntimeException(it.id +" " + it.pos);
                it.entity = new function(func.irName, func.type, false, func.className);
            }
        } else if (it.thisExpr != null) {
            it.entity = thisPtr;
        } else if (it.formatExpr != null) {
            it.formatExpr.accept(this);
            it.entity = it.formatExpr.entity;
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
        // consider shortCut
        if (it.opStr.equals("&&") || it.opStr.equals("||")) {
            String shortTrue = rename("short_true");
            String shortFalse = rename("short_false");
            String shortNext = rename("short_next");
            String shortEnd = rename("short_end");
            BrInst inst1;
            if (it.opStr.equals("&&")) inst1 = new BrInst(loadPtr(it.lhs.entity), shortNext, shortFalse);
            else inst1 = new BrInst(loadPtr(it.lhs.entity), shortTrue, shortNext);
            curBlock.addInst(inst1);
            curBlock = new block(shortNext, curFunc);
            curFunc.addBlock(curBlock);
            it.rhs.accept(this);
            BrInst inst2 = new BrInst(loadPtr(it.rhs.entity), shortTrue, shortFalse);
            curBlock.addInst(inst2);
            curBlock = new block(shortTrue, curFunc);
            curFunc.addBlock(curBlock);
            BrInst inst3 = new BrInst(null, shortEnd, null);
            curBlock.addInst(inst3);
            curBlock = new block(shortFalse, curFunc);
            curFunc.addBlock(curBlock);
            curBlock.addInst(inst3);
            curBlock = new block(shortEnd, curFunc);
            curFunc.addBlock(curBlock);
            localVar local = new localVar(new boolType(), generator.getName());
            PhiInst inst4 = new PhiInst(local);
            inst4.jump.add(new Pair<>(new constBool(true), shortTrue));
            inst4.jump.add(new Pair<>(new constBool(false), shortFalse));
            curBlock.phiInsts.add(inst4);
           // curBlock.addInst(inst4);
            it.entity = local;
            return;
        }
        it.rhs.accept(this);

        if (it.lhs.type.typeName.equals("string")) {
            function func;
            if (isBinary(it.opStr)) func = globalScope.getIrFunction("string." + BinaryInst.advertOp(it.opStr));
            else func = globalScope.getIrFunction("string." + IcmpInst.advertCmp(it.opStr));
            function callFunc = new function(func.irName, func.type, false, null);
            it.entity = new localVar(func.type, generator.getName());
            CallInst inst = new CallInst(callFunc, it.entity);
            if (!it.lhs.entity.isConst() && !(it.lhs instanceof funcExprNode)) inst.para.add(loadPtr(it.lhs.entity));
            else inst.para.add(it.lhs.entity);
            if (it.rhs.entity.isConst() || (it.rhs instanceof funcExprNode)) inst.para.add(it.rhs.entity);
            else inst.para.add(loadPtr(it.rhs.entity));
            curBlock.addInst(inst);
            return;
        }
        Entity obj1 = loadPtr(it.lhs.entity);
        Entity obj2 = loadPtr(it.rhs.entity);
        if (isBinary(it.opStr)) {
            localVar res = new localVar(obj1.type, rename(BinaryInst.advertOp(it.opStr) + ".result"));
            BinaryInst inst = new BinaryInst(res, it.opStr, obj1, obj2);
            curBlock.addInst(inst);
            it.entity = res;
        } else {
            localVar res = new localVar(new boolType(), rename(IcmpInst.advertCmp(it.opStr) + ".result"));
            IcmpInst inst = new IcmpInst(res, it.opStr, obj1, obj2);
            curBlock.addInst(inst);
            it.entity = res;
        }
    }
    @Override
    public void visit(cFormatExpr it){
        if (it.formatType) {
            it.value = getStr(it.value.substring(1, it.value.length() - 1));
            it.value = it.value.replace("$$", "$");
            it.entity = new constString(rename("const.str"), it.value);
            globalScope.addString((constString) it.entity);
            globalScope.addBasicInst(it.entity, new BasicInst(it.entity.toString()));
        } else {
            constString headStr = null;
            localVar localStr = null;
            if (it.head.length() > 3) {
                headStr = new constString(rename("const.str"), getStr(it.head.substring(1)).replace("$$", "$"));
                globalScope.addString(headStr);
                globalScope.addBasicInst(it.entity, new BasicInst(headStr.toString()));
                localPtr ptr = new localPtr(new ptrType(headStr.type), generator.getName());
                curBlock.addInst(new AllocaInst(ptr, ptr.type, null));
                curBlock.addInst(new StoreInst(headStr, ptr));
                localStr = new localVar(new ptrType(headStr.type), generator.getName());
                curBlock.addInst(new LoadInst(localStr, ptr));
            }
            ExprNode headExpr = it.expr.getFirst();
            headExpr.accept(this);
            localStr = formatProcess(headExpr, localStr);
            for (int i = 0; i < it.middle.size(); i++) {
                constString midStr = new constString(rename("const.str"), getStr(it.middle.get(i)).replace("$$", "$"));
                globalScope.addString(midStr);
                globalScope.addBasicInst(it.entity, new BasicInst(midStr.toString()));
                localStr = addConstString(midStr, localStr);
                it.expr.get(i + 1).accept(this);
                localStr = formatProcess(it.expr.get(i + 1), localStr);
            }
            if (it.tail.length() > 2) {
                constString tailStr = new constString(rename("const.str"), getStr(it.tail).replace("$$", "$"));
                localStr = addConstString(tailStr, localStr);
                globalScope.addString(tailStr);
                globalScope.addBasicInst(tailStr, new BasicInst(tailStr.toString()));
            }
            it.entity = new localPtr(new ptrType(new stringType()), generator.getName());
            curBlock.addInst(new AllocaInst((Ptr)it.entity, it.entity.type, null));
            curBlock.addInst(new StoreInst(localStr, it.entity));
        }
    }

    private localVar addConstString(constString cStr, localVar ptr) {
        localPtr cPtr = new localPtr(new ptrType(cStr.type), generator.getName());
        curBlock.addInst(new AllocaInst(cPtr, cPtr.type, null));
        curBlock.addInst(new StoreInst(cStr, cPtr));
        localVar vari = new localVar(new ptrType(new stringType()), generator.getName());
        curBlock.addInst(new LoadInst(vari, cPtr));
        if (ptr == null) return vari;
        function func1 = globalScope.getIrFunction("string.add");
        function callFunc1 = new function(func1.irName, func1.type, false, null);
        localVar res = new localVar(ptr.type, generator.getName());
        CallInst inst1 = new CallInst(callFunc1, res);
        inst1.para.add(ptr);
        inst1.para.add(vari);
        curBlock.addInst(inst1);
        return res;
    }
    private localVar formatProcess(ExprNode expr, localVar ptr) {
        localVar res;
        if (expr.type.typeName.equals("int")) {
            function func = globalScope.getIrFunction("toString");
            function callFunc = new function(func.irName, func.type, false, null);
            localVar toStr = new localVar(new ptrType(new stringType()), generator.getName());
            CallInst inst = new CallInst(callFunc, toStr);
            inst.para.add(loadPtr(expr.entity));
            curBlock.addInst(inst);
            if (ptr != null) {
                function func1 = globalScope.getIrFunction("string.add");
                function callFunc1 = new function(func1.irName, func1.type, false, null);
                res = new localVar(ptr.type, generator.getName());
                CallInst inst1 = new CallInst(callFunc1, res);
                inst1.para.add(ptr);
                inst1.para.add(toStr);
                curBlock.addInst(inst1);
                return res;
            } else {
                return toStr;
            }
        } else if (expr.type.typeName.equals("bool")) {
            localVar vari = (localVar) loadPtr(expr.entity);
            String trueStr = rename("if.true");
            String falseStr = rename("if.false");
            String endStr = rename("if.end");
            BrInst inst = new BrInst(vari, trueStr, falseStr);
            curBlock.addInst(inst);
            curBlock = new block(trueStr, curFunc);
            curFunc.addBlock(curBlock);
            constString trueConst = new constString(rename("const.str"), "true");
            globalScope.addString(trueConst);
            globalScope.addBasicInst(trueConst, new BasicInst(trueConst.toString()));
            localVar trueVar = addConstString(trueConst, ptr);
            curBlock.addInst(new BrInst(null, endStr, null));
            curBlock = new block(falseStr, curFunc);
            curFunc.addBlock(curBlock);
            constString falseConst = new constString(rename("const.str"), "false");
            globalScope.addString(falseConst);
            globalScope.addBasicInst(falseConst, new BasicInst(falseConst.toString()));
            localVar falseVar = addConstString(falseConst, ptr);
            curBlock.addInst(new BrInst(null, endStr, null));
            curBlock = new block(endStr, curFunc);
            curFunc.addBlock(curBlock);
            res = new localVar(new ptrType(new stringType()), generator.getName());
            PhiInst inst1 = new PhiInst(res);
            inst1.jump.add(new Pair<>(trueVar, trueStr));
            inst1.jump.add(new Pair<>(falseVar, falseStr));
            curBlock.phiInsts.add(inst1);
            //curBlock.addInst(inst1);
            return res;
        } else if (expr.type.typeName.equals("string")) {
            if (ptr != null) {
                function func = globalScope.getIrFunction("string.add");
                function callFunc = new function(func.irName, func.type, false, null);
                res = new localVar(ptr.type, generator.getName());
                CallInst inst = new CallInst(callFunc, res);
                inst.para.add(ptr);
                inst.para.add(expr.entity);
                curBlock.addInst(inst);
                return res;
            } else {
               Entity en = loadPtr(expr.entity);
               return new localVar(en.type, en.irName);
            }
        } else return null;
    }
    @Override
    public void visit(funcExprNode it){
        it.exprNode.accept(this);
        if (!(it.exprNode.entity instanceof function)) {
            // 必须在类里才会重名
            if (currentScope.isInClass() == null) throw new RuntimeException("redefinition: class function & variable");
            function func = globalScope.getIrFunction(currentScope.isInClass() + "." + it.exprNode.type.typeName);
            it.exprNode.entity = new function(func.irName, func.type, false, func.className);
        }
        CallInst inst = new CallInst((function) it.exprNode.entity, generator.getName());
        if (!(it.exprNode instanceof memberExprNode)) {
            if (curFunc.isMember && curFunc.className.equals(((function) it.exprNode.entity).className))
                inst.para.add(loadPtr(thisPtr));
        }
        for (var para: it.paraList) {
            para.accept(this);
            if (!para.entity.isConst() && !(para instanceof funcExprNode))  inst.para.add(loadPtr(para.entity));
            else inst.para.add(para.entity);
        }
        curBlock.addInst(inst);
        it.entity = inst.ret;
    }
    @Override
    public void visit(indexExprNode it){
        it.exprNode.accept(this);
        localPtr res = new localPtr("here");
        Entity cur = it.exprNode.entity;
        for (int i = 0; i < it.index.size(); i++) {
            it.index.get(i).accept(this);
            if (! (it.exprNode instanceof funcExprNode)){
                ExprNode isBasic = (it.exprNode instanceof basicExprNode basic) ? basic : null;
                while (isBasic instanceof basicExprNode) isBasic = ((basicExprNode) isBasic).exprNode;
                if ((!(isBasic instanceof arrayExprNode) && ! (isBasic instanceof varExprNode))|| i != 0) cur = loadPtr(cur);
            }
            res = new localPtr(((ptrType) cur.type).baseType, rename("array_ptr"));
            GetelementInst inst = new GetelementInst(res, cur);
            cur = res;
            inst.index.add(loadPtr(it.index.get(i).entity));
            curBlock.addInst(inst);
        }
        it.entity = res;
    }
    @Override
    public void visit(initArrayExprNode it){
        ArrayList<ExprNode> index = new ArrayList<>();
        if (it.assignNode == null) {
            varDefAtomNode varDef = new varDefAtomNode(null, rename("const.array"));
            varDef.assignNode = it;
            varDef.type = it.type;
            atomExprNode atom = new atomExprNode(null);
            atom.id = varDef.varName;
            atom.type = it.type;
            it.assignNode = atom;
            visit(varDef);
            it.entity = currentScope.getPtrGlobally(varDef.varName);
        } else initToNew(it, 0, index, it.assignNode);
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
            it.entity = assign.lhs.entity;
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
        while (it.obj instanceof basicExprNode) it.obj = ((basicExprNode) it.obj).exprNode;
        if (!(it.obj instanceof funcExprNode) && ! (it.obj instanceof varExprNode)) it.obj.entity = loadPtr(it.obj.entity);
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
            function func = globalScope.getIrFunction(it.obj.type.typeName + "." + it.member);
            if (func == null) throw new RuntimeException(it.pos + " " + it.member);
            it.entity = new function(func.irName, func.type, false, object.className);
            ((function) it.entity).paraList.add(it.obj.entity);
        } else {
            int dim = it.type.arrayDim;
            localPtr result = new localPtr(IRType.dataToIR(it.type), rename(it.obj.type.typeName + "." + it.member + "_ptr"));
            it.type.arrayDim = dim;
            if (dim != 0) it.type.isArray = true;
            GetelementInst inst = new GetelementInst(result, it.obj.entity);
            inst.index.add(new constInt(0));
            inst.index.add(new constInt(object.varMap.get(it.member).getFirst()));
            curBlock.addInst(inst);
            it.entity = result;
        }
    }
    @Override
    public void visit(ternaryExprNode it){
       ternaryProcess(it);
    }
    public Pair<Entity, String> ternaryProcess(ternaryExprNode it) {
        String firStr = rename("ternary_first");
        String secStr = rename("ternary_second");
        String endStr = rename("ternary_end");
        it.expr1.accept(this);
        it.expr1.entity = loadPtr(it.expr1.entity);
        BrInst inst1 = new BrInst(it.expr1.entity, firStr, secStr);
        curBlock.addInst(inst1);
        curBlock = new block(firStr, curFunc);
        curFunc.addBlock(curBlock);
        Pair<Entity, String> br1 = null;
        if (it.expr2 instanceof ternaryExprNode) br1 = ternaryProcess((ternaryExprNode) it.expr2);
        else {
            it.expr2.accept(this);
        }
        if (!(it.expr2.entity instanceof constString)) it.expr2.entity = loadPtr(it.expr2.entity);
        if (!(it.expr2 instanceof ternaryExprNode)) br1 = new Pair<>(it.expr2.entity, firStr);
        curBlock.addInst(new BrInst(null, endStr, null));
        curBlock = new block(secStr, curFunc);
        curFunc.addBlock(curBlock);
        Pair<Entity, String> br2 = null;
        if (it.expr3 instanceof ternaryExprNode) br2 = ternaryProcess((ternaryExprNode) it.expr3);
        else {
            it.expr3.accept(this);
        }
        if (!(it.expr3.entity instanceof constString)) it.expr3.entity = loadPtr(it.expr3.entity);
        if (!(it.expr3 instanceof ternaryExprNode)) br2 = new Pair<>(it.expr3.entity, secStr);
        curBlock.addInst(new BrInst(null, endStr, null));
        curBlock = new block(endStr, curFunc);
        curFunc.addBlock(curBlock);
        localVar local = new localVar(it.expr2.entity.type, generator.getName());
        if (!it.expr2.type.typeName.equals("void")) {
            PhiInst inst2 = new PhiInst(local);
            inst2.jump.add(br1);
            inst2.jump.add(br2);
            curBlock.phiInsts.add(inst2);
           // curBlock.addInst(inst2);
            if (it.expr2.entity instanceof constString) {
                localVar copy = new localVar(new ptrType(it.expr2.entity.type), generator.getName());
                curBlock.addInst(new AllocaInst(copy, copy.type, null));
                curBlock.addInst(new StoreInst(local, copy));
                local = copy;
            }
        }
        it.entity = local;
        return new Pair<>(local, endStr);
    }
    @Override
    public void visit(unaryExprNode it){
        it.exprNode.accept(this);
        Entity local = loadPtr(it.exprNode.entity);
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
        CallInst inst = new CallInst(func, it.entity);
        if (currentScope.isInClass() == null) thisPtr = new localPtr(new localPtr(new classType(it.type.typeName), "this").type, "this_ptr");
        inst.para.add(new constInt(obj.varMap.size() * 4));
        curBlock.addInst(inst);
        function constr = globalScope.getIrFunction(it.type.typeName + "." + it.type.typeName);
        if (constr != null) {
            function copy_cons = new function(constr.irName, constr.type, false, constr.className);
            copy_cons.addPara(it.entity);
            CallInst inst2 = new CallInst(copy_cons, "void_return");
            curBlock.addInst(inst2);
        }
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
        while (currentScope != null && !currentScope.isLoopScope) {
            currentScope = currentScope.parentScope;
        }
        currentScope.flag = false;
    }
    @Override
    public void visit(continueStatNode it){
        while (currentScope != null && !currentScope.isLoopScope) {
            currentScope = currentScope.parentScope;
        }
        currentScope.flag = true;
    }
    @Override
    public void visit(exprStatNode it){
        if (it.exprNode != null) it.exprNode.accept(this);
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
        currentScope.begLab = stepStr;
        currentScope.endLab = endStr;
        curBlock.addInst(new BrInst(null, condStr, null));
        curBlock = new block(condStr, curFunc);
        curFunc.addBlock(curBlock);
        if (it.condExpr != null) {
            it.condExpr.accept(this);
            curBlock.addInst(new BrInst(loadPtr(it.condExpr.entity), bodyStr, endStr));
        } else curBlock.addInst(new BrInst(null, bodyStr, null));
        curBlock = new block(bodyStr, curFunc);
        curFunc.addBlock(curBlock);
        if (it.stat != null) {
            currentScope = new Scope(currentScope);
            Scope cur = currentScope;
            it.stat.accept(this);
            if (cur == currentScope)  curBlock.addInst(new BrInst(null, stepStr, null));
            else curBlock.addInst(new BrInst(null, (currentScope.flag) ? currentScope.begLab : currentScope.endLab, null));
            currentScope = cur.parentScope;
        }
        curBlock = new block(stepStr, curFunc);
        curFunc.addBlock(curBlock);
        if (it.stepExpr != null) {
            it.stepExpr.accept(this);
        }
        curBlock.addInst(new BrInst(null, condStr, null));
        curBlock = new block(endStr, curFunc);
        curFunc.addBlock(curBlock);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(ifStatNode it){
        it.conExpr.accept(this);
        String str1 = rename("if.true");
        String str2 = rename("if.false");
        String str3 = rename("if.end");
        BrInst inst1;
        if (it.elseStat != null)  inst1 = new BrInst(loadPtr(it.conExpr.entity), str1, str2);
        else inst1 = new BrInst(loadPtr(it.conExpr.entity), str1, str3);
        curBlock.addInst(inst1);
        curBlock = new block(str1, curFunc);
        curFunc.addBlock(curBlock);
        currentScope = new Scope(currentScope);
        Scope cur = currentScope;
        it.ifStat.accept(this);
        if (currentScope == cur) curBlock.addInst(new BrInst(null, str3, null));
        else curBlock.addInst(new BrInst(null, (currentScope.flag) ?currentScope.begLab :currentScope.endLab, null));
        currentScope = cur.parentScope;
        if (it.elseStat != null) {
            currentScope = new Scope(currentScope);
            cur = currentScope;
            curBlock = new block(str2, curFunc);
            curFunc.addBlock(curBlock);
            it.elseStat.accept(this);
            if (currentScope == cur)  curBlock.addInst(new BrInst(null, str3, null));
            else curBlock.addInst(new BrInst(null, (currentScope.flag) ?currentScope.begLab :currentScope.endLab, null));
            currentScope = cur.parentScope;
        }
        curBlock = new block(str3, curFunc);
        curFunc.addBlock(curBlock);
    }
    @Override
    public void visit(returnStatNode it){
        if (it.exprNode != null) {
            it.exprNode.accept(this);
            if (it.exprNode.entity instanceof globalVar || it.exprNode.entity instanceof constString) {
                Entity mid ;
                if (it.exprNode.entity instanceof globalVar) mid = loadPtr(it.exprNode.entity);
                else mid = it.exprNode.entity;
                localPtr midd = new localPtr(mid.type, generator.getName());
                AllocaInst inst3 = new AllocaInst(midd, midd.type, null);
                curBlock.addInst(inst3);
                StoreInst inst = new StoreInst(mid, midd);
                curBlock.addInst(inst);
                curBlock.addInst(new RetInst(loadPtr(midd)));
                curFunc.retBlks.add(curBlock);
                return;
            }
            if (it.exprNode instanceof funcExprNode) {
                curBlock.addInst(new RetInst(it.exprNode.entity));
                curBlock.retCall = true;
            } else curBlock.addInst(new RetInst(loadPtr(it.exprNode.entity)));
            curFunc.retBlks.add(curBlock);
            curBlock = new block();
        } else {
            curBlock.addInst(new RetInst(new voidType(), null));
            curFunc.retBlks.add(curBlock);
            curBlock = new block();
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
        curBlock = new block(condStr, curFunc);
        curFunc.addBlock(curBlock);
        it.whileExpr.accept(this);
        String endStr = rename("while.end");
        String bodyStr = rename("while.body");
        BrInst inst2 = new BrInst(loadPtr(it.whileExpr.entity), bodyStr, endStr);
        currentScope = new Scope(currentScope, true);
        currentScope.begLab = condStr;
        currentScope.endLab = endStr;
        curBlock.addInst(inst2);
        curBlock = new block(bodyStr, curFunc);
        curFunc.addBlock(curBlock);
        it.whileStat.accept(this);
        BrInst inst3 = new BrInst(null, condStr, null);
        curBlock.addInst(inst3);
        curBlock = new block(endStr, curFunc);
        curFunc.addBlock(curBlock);
        currentScope = currentScope.parentScope;
    }

    @Override
    public void visit(classDefNode it){
        currentScope = new ClassScope(currentScope);
        currentScope.className = it.className;
        thisPtr = new localPtr(new localPtr(new classType(it.className), "this").type, "this_ptr");
        for (Map.Entry<String, Pair<Integer, varDefAtomNode>> entry: it.varMap.entrySet()) {
            varDefAtomNode value = entry.getValue().getSecond();
            int dim = value.type.arrayDim;
            memberPtr mPtr = new memberPtr(IRType.dataToIR(value.type), value.varName, it.className, entry.getValue().getFirst());
            value.type.arrayDim = dim;
            if (dim != 0) value.type.isArray = true;
            mPtr.parent = thisPtr;
            currentScope.addPtr(value.varName, mPtr);
        }
        if (it.constructor != null) {
            it.constructor.accept(this);
            globalScope.addIrFunction(it.className + "." + it.className, curFunc);
            curFunc = init_;
            curBlock = null;
        }
        for (Map.Entry<String, funcDefNode> entry: it.funcMap.entrySet()) {
            curFunc = globalScope.getIrFunction(it.className + "." + entry.getKey());
            curBlock = new block("entry", curFunc);
            curFunc.addBlock(curBlock);
            ((funcDefNode)entry.getValue()).accept(this);
        }
        curFunc = init_;
        curBlock = init_.blocks.getLast();
        thisPtr = null;
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(constructNode it){
        currentScope = new FuncScope(currentScope, new DataType("void"));
        curBlock = new block("entry", curFunc);
        //curFunc = new function(it.className + "." + it.className, new voidType(), true, it.className);
        curFunc = globalScope.getIrFunction(it.className + "." + it.className);
        curFunc.addBlock(curBlock);
        localPtr ptr = thisPtr;
        curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
        curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        it.blockStat.accept(this);
        curBlock.addInst(new RetInst(new voidType(), null));
        curFunc.retBlks.add(curBlock);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(funcDefNode it){
        currentScope = new FuncScope(currentScope, it.returnType);
        if (curFunc.isMember) {
            localPtr ptr = thisPtr;
            curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
            curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        }
        for (var para: it.para.paraList) {
            int dim = para.paraType.arrayDim;
            localVar vari = new localVar(IRType.dataToIR(para.paraType), rename(para.paraName) + "_para");
            para.paraType.arrayDim = dim;
            if (dim != 0) para.paraType.isArray = true;
            curFunc.addPara(vari);
            Ptr ptr = new localPtr(vari.type, vari.irName.replace("_para", "_ptr"));
            currentScope.addPtr(para.paraName, ptr);
            curBlock.addInst(new AllocaInst(ptr, vari.type, null));
            curBlock.addInst(new StoreInst(vari, ptr));
        }
        it.funcBlock.accept(this);
        if (it.returnType.typeName.equals("void"))  {
            curBlock.addInst(new RetInst(new voidType(), null));
            curFunc.retBlks.add(curBlock);
            currentScope = currentScope.parentScope;
            return;
        }
        if (curFunc.blocks.getLast().instructions.isEmpty() || !(curFunc.blocks.getLast().instructions.getLast() instanceof RetInst)) {
            curBlock.addInst(new RetInst(transData(it.returnType)));
            curFunc.retBlks.add(curBlock);
        }
        currentScope = currentScope.parentScope;
    }

    public Entity transData(DataType type) {
        if (type.typeName.equals("int")) return new constInt(0);
        else if (type.typeName.equals("bool")) return new constBool(true);
        else return new constNull();
    }

    @Override
    public void visit(mainDefNode it){
        if (curFunc.isMember) {
            currentScope = new FuncScope(currentScope, it.returnType);
            localPtr ptr = thisPtr;
            curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
            curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        }
        it.funcBlock.accept(this);
        if (it.funcBlock.statList.isEmpty() || !(it.funcBlock.statList.getLast() instanceof returnStatNode)) {
            curBlock.addInst(new RetInst(new constInt(0)));
            curFunc.retBlks.add(curBlock);
        }
        if (curFunc.isMember) currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(paraListNode it){}
    @Override
    public void visit(varDefAtomNode it){
        int dim = it.type.arrayDim;
        localPtr ptr = new localPtr(IRType.dataToIR(it.type), rename(it.varName + "_ptr"));
        it.type.arrayDim = dim;
        if (dim != 0) it.type.isArray = true;
        currentScope.addPtr(it.varName, ptr);
        curBlock.addInst(new AllocaInst(ptr, ((ptrType)ptr.type).baseType, null));
        if (it.assignNode != null) {
            it.assignNode.accept(this);
            if (it.assignNode.entity != null && (it.assignNode.entity.isConst() || (it.assignNode instanceof arrayExprNode) || it.assignNode instanceof varExprNode || it.assignNode instanceof funcExprNode)) {
                curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
                // why ??????
                if (it.type.typeName.equals("string")) {
                    ((ptrType) ptr.type).baseType = it.assignNode.entity.type;
                }
            }  else {
                if (it.assignNode.entity != null) {
                    if (it.assignNode instanceof initArrayExprNode) loadPtr(it.assignNode.entity);
                    else if (it.assignNode instanceof ternaryExprNode) {
                        curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
                    } else {
                        curBlock.addInst(new StoreInst(loadPtr(it.assignNode.entity), ptr));
                    }
                }
            }
        }
    }
    @Override
    public void visit(varDefNode it){
        for (var def: it.varList) {
            def.accept(this);
        }
    }

    public String rename(String name) {
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
        for (var inst: globalScope.globalInst.entrySet()) {
            ans.append(inst.getValue()).append("\n");
        }
        ans.append("\n");
        for (function func: globalScope.irFunction.values()) {
            ans.append(func).append("\n");
        }
        return ans.toString();
    }
    public Entity loadPtr(Entity it) {
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
    private Entity calLength(Entity expr) {
        localVar var1 = new localVar(new intType(), generator.getName());
        BinaryInst inst = new BinaryInst(var1, "*", expr, new constInt(4));
        curBlock.addInst(inst);
        localVar var2 = new localVar(new intType(), generator.getName());
        inst = new BinaryInst(var2, "+", var1, new constInt(4));
        curBlock.addInst(inst);
        return var2;
    }
    private String getStr(String str) {
        return str.substring(1, str.length() - 1).replace("\\\"", "\"")
                .replace("\\n", "\n")
                .replace("\\t", "\t")
                .replace("\\\\", "\\");
    }
}
