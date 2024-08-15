package MIR;

import AST.ASTVisitor;
import AST.Def.*;
import AST.Expr.*;
import AST.ProgramNode;
import AST.Stat.*;
import MIR.Instruction.BasicInst;
import MIR.Instruction.LoadInst;
import MIR.Instruction.RetInst;
import MIR.Instruction.StoreInst;
import MIR.irEntity.*;
import MIR.type.IRType;
import MIR.type.intType;
import MIR.type.voidType;
import MIR.utils.anonyName;
import MIR.utils.block;
import com.sun.jdi.VoidType;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;

import java.util.HashMap;
import java.util.Map;

public class IRBuilder implements ASTVisitor {
    public GlobalScope globalScope;
    public Scope currentScope;
    public block curBlock = null;
    public function curFunc = null;
    public HashMap<String, Integer> varRename = null;
    public IRBuilder(GlobalScope global) {
        globalScope = global;
        currentScope = global;
        varRename = new HashMap<>();
    }
    @Override
    public void visit(ProgramNode it){
        for (var def: it.definition) {
            if (def instanceof classDefNode) {
                globalClass newCls = new globalClass(((classDefNode) def).className);
                globalScope.addIrClass(newCls);
                for (Map.Entry<String, varDefAtomNode> entry: ((classDefNode) def).varMap.entrySet()) {
                    newCls.members.add(IRType.dataToIR(entry.getValue().type));
                    globalScope.addBasicInst(new BasicInst(newCls.print()));
                }
                for (Map.Entry<String, funcDefNode> entry: ((classDefNode) def).funcMap.entrySet()) {
                    String funcIr = ((classDefNode) def).className + "." + entry.getValue().funcName;
                    curFunc = new function(funcIr, IRType.dataToIR(entry.getValue().returnType), true);
                    globalScope.addIrFunction(curFunc);
                    entry.getValue().accept(this);
                }
            } else if (def instanceof varDefNode) {
                curFunc = new function("global_init", new voidType(), false);
                curBlock = new block("entry", curFunc);
                for (var varDef: ((varDefNode) def).varList) {
                    if (varDef.assignNode != null) varDef.assignNode.accept(this);
                    globalVar gVar = new globalVar(IRType.dataToIR(varDef.type), varDef.varName);
                    globalScope.addBasicInst(new BasicInst(gVar.print()));
                    if (varDef.assignNode != null && !varDef.assignNode.entity.isConst()) {
                        globalVar pointer = new globalVar(varDef.assignNode.entity);
                        localVar local = new localVar(pointer.type, new anonyName().getName());
                        curBlock.addInst(new LoadInst(local, pointer));
                        curBlock.addInst(new StoreInst(local, gVar));
                    }
                }
                curBlock.addInst(new RetInst(new voidType(), null));
                curFunc.addBlock(curBlock);
                globalScope.addIrFunction(curFunc);
                curBlock = null;
            } else if (def instanceof funcDefNode) {
                curFunc = new function(((funcDefNode) def).funcName,
                        IRType.dataToIR(((funcDefNode) def).returnType), false);
                ((funcDefNode) def).para.accept(this);
                for (var para: ((funcDefNode) def).para.paraList) {
                    curFunc.addPara(para.entity);
                }
                curBlock = new block("entry", curFunc);
                ((funcDefNode) def).funcBlock.accept(this);
                curFunc.addBlock(curBlock);
                globalScope.addIrFunction(curFunc);
            } else if (def instanceof mainDefNode) {
                curFunc = new function("main", new intType(), false);
                curBlock = new block("entry", curFunc);
                ((mainDefNode) def).blockStat.accept(this);
                curFunc.addBlock(curBlock);
                globalScope.addIrFunction(curFunc);
            }
        }
    }
    @Override
    public void visit(arrayExprNode it){}
    @Override
    public void visit(assignExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);

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
            it.entity = new Entity(IRType.dataToIR(it.type), it.id);
        }
    }
    @Override
    public void visit(basicExprNode it){}
    @Override
    public void visit(binaryExprNode it){}
    @Override
    public void visit(cFormatExpr it){}
    @Override
    public void visit(funcExprNode it){}
    @Override
    public void visit(indexExprNode it){}
    @Override
    public void visit(initArrayExprNode it){}
    @Override
    public void visit(memberExprNode it){}
    @Override
    public void visit(ternaryExprNode it){}
    @Override
    public void visit(unaryExprNode it){}
    @Override
    public void visit(varExprNode it){}

    @Override
    public void visit(blockStatNode it){
        for (var stat: it.statList) {
            stat.accept(this);
        }
    }
    @Override
    public void visit(breakStatNode it){}
    @Override
    public void visit(continueStatNode it){}
    @Override
    public void visit(exprStatNode it){}
    @Override
    public void visit(forStatNode it){}
    @Override
    public void visit(ifStatNode it){}
    @Override
    public void visit(returnStatNode it){
        if (it.exprNode != null) {
            it.exprNode.accept(this);
            curBlock.addInst(new RetInst(it.exprNode.entity));
        } else curBlock.addInst(new RetInst(new voidType(), null));

    }
    @Override
    public void visit(varStatNode it){
        it.varDef.accept(this);
    }
    @Override
    public void visit(whileStatNode it){}

    @Override
    public void visit(classDefNode it){}
    @Override
    public void visit(constructNode it){}
    @Override
    public void visit(funcDefNode it){}
    @Override
    public void visit(mainDefNode it){}
    @Override
    public void visit(paraListNode it){}
    @Override
    public void visit(varDefAtomNode it){

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
            num--;
            return name + num;
        } else return name;
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
}
