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
import utils.Scope.FuncScope;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;
import MIR.Instruction.*;

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
        curFunc = new function("global_init", new voidType(), false);
        curBlock = new block("entry", curFunc);
        curFunc.addBlock(curBlock);
        for (var def: it.definition) {
            if (def instanceof classDefNode) {
                globalClass newCls = new globalClass(((classDefNode) def).className);
                globalScope.addIrClass(newCls);
                for (Map.Entry<String, varDefAtomNode> entry: ((classDefNode) def).varMap.entrySet()) {
                    newCls.members.add(IRType.dataToIR(entry.getValue().type));
                }
                globalScope.addBasicInst(new BasicInst(newCls.print()));
                for (Map.Entry<String, funcDefNode> entry: ((classDefNode) def).funcMap.entrySet()) {
                    String funcIr = ((classDefNode) def).className + "." + entry.getValue().funcName;
                    curBlock = new block("entry", curFunc);
                    curFunc = new function(funcIr, IRType.dataToIR(entry.getValue().returnType), true);
                    globalScope.addIrFunction(entry.getValue().funcName, curFunc);
                    curFunc.addBlock(curBlock);
                    entry.getValue().accept(this);
                    curFunc = curBlock.parentFunc;
                    curBlock = null;
                }
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
                        IRType.dataToIR(((funcDefNode) def).returnType), false);
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
    public void visit(arrayExprNode it){}
    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        StoreInst inst = new StoreInst(loadPtr(it.rhs.entity), it.lhs.entity);
        curBlock.addInst(inst);
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
            it.entity = new constString(".str", it.strExpr.value);
        } else if (it.id != null) {
            it.entity = currentScope.getPtrGlobally(it.id);
            if (it.entity == null) {
                it.entity = globalScope.getIrFunction(it.id);
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
    public void visit(indexExprNode it){}
    @Override
    public void visit(initArrayExprNode it){}
    @Override
    public void visit(memberExprNode it){}
    @Override
    public void visit(ternaryExprNode it){}
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
    public void visit(varExprNode it){}

    @Override
    public void visit(blockStatNode it){
        currentScope = new Scope(currentScope);
        Scope cur = currentScope;
        for (var stat: it.statList) {
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
    public void visit(classDefNode it){}
    @Override
    public void visit(constructNode it){}
    @Override
    public void visit(funcDefNode it){
        currentScope = new Scope(currentScope);
        if (curFunc.isMember) {
            localPtr ptr = new localPtr(curFunc.paraList.getFirst().type, rename("this_ptr"));
            curBlock.addInst(new AllocaInst(ptr, new ptrType(), null));
            curBlock.addInst(new StoreInst(curFunc.paraList.getFirst(), ptr));
        }
        for (var para: it.para.paraList) {
            localVar vari = new localVar(IRType.dataToIR(para.paraType), rename(para.paraName) + "_para");
            curFunc.addPara(vari);
            localPtr ptr = new localPtr(vari.type, vari.irName.replace("_para", "_ptr"));
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
        curFunc = new function("main", new intType(), false);
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
        localPtr ptr = new localPtr(IRType.dataToIR(it.type), rename(it.varName));
        currentScope.addPtr(it.varName, ptr);
        curBlock.addInst(new AllocaInst(ptr, ((ptrType)ptr.type).baseType, null));
        if (it.assignNode != null) {
            it.assignNode.accept(this);
            if (it.assignNode.entity.isConst()) curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
            else {
                curBlock.addInst(new StoreInst(it.assignNode.entity, ptr));
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
        for (var inst: globalScope.globalInst) {
            ans.append(inst).append("\n");
        }
        for (function func: globalScope.irFunction.values()) {
            ans.append(func);
        }
        return ans.toString();
    }
    private Entity loadPtr(Entity it) {
        if (it.type instanceof ptrType) {
            localVar local = new localVar(((ptrType)it.type).baseType, generator.getName());
            LoadInst inst = new LoadInst(local, it);
            curBlock.addInst(inst);
            return local;
        } else return it;
    }
    private boolean isBinary(String op) {
        return !op.equals("==") && !op.equals(">=") && !op.equals("<=") && !op.equals("!=") && !op.equals("<") && !op.equals(">");
    }
}
