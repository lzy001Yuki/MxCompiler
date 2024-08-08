package frontEnd;

import AST.ASTVisitor;
import AST.Expr.*;
import AST.Def.*;
import AST.Stat.*;
import AST.ProgramNode;
import utils.DataType;
import utils.FuncType;
import utils.Scope.ClassScope;
import utils.Scope.FuncScope;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;
import utils.Error;

import java.util.Map;

public class SemanticChecker implements ASTVisitor {
    public Scope currentScope;
    public GlobalScope globalScope;
    public SemanticChecker(GlobalScope global) {
        this.globalScope = global;
        this.currentScope = new Scope(null);
        this.currentScope.members = globalScope.members; // refers to the same global variables
    }
    @Override
    public void visit(ProgramNode it) {
        for (var def: it.definition) def.accept(this);
    }
    @Override
    public void visit(arrayExprNode it) {
        if (it.type.isClass) {
            if (!globalScope.classMember.containsKey(it.type.typeName))
                throw new Error("SemanticError", "invalid type for array", it.pos);
        }
        for (var index: it.indexList) {
            index.accept(this);
            if (!index.type.typeName.equals("int") || index.type.isArray)
                throw new Error("SemanticError", "invalid type for array initialization", it.pos);
        }
        if (it.iniList != null) it.iniList.accept(this);
    }
    @Override
    public void visit(assignExprNode it){
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (!it.lhs.isLeftValue) throw new Error("SemanticError", it.lhs.type.typeName + " is not a left value", it.pos);
        if (!it.lhs.type.equals(it.rhs.type)) throw new Error("SemanticError", "assign types mismatch", it.pos);
        it.type = new DataType(it.lhs.type);
        it.isLeftValue = false;
    }
    @Override
    public void visit(atomExprNode it){
        if (it.intExpr != null) {
            it.type = it.intExpr.type;
            it.isLeftValue = false;
        } else if (it.boolExpr != null) {
            it.type = it.boolExpr.type;
            it.isLeftValue = false;
        } else if (it.strExpr != null) {
            it.type = it.strExpr.type;
            it.isLeftValue = false;
        } else if (it.nullExpr != null) {
            it.type = it.nullExpr.type;
            it.type.isNull = true;
            it.isLeftValue = false;
        } else if (it.formatExpr != null) {
            it.formatExpr.accept(this);
            it.type = it.formatExpr.type;
            it.isLeftValue = false;
        } else if (it.thisExpr != null) {
            String className = currentScope.isInClass();
            if (className == null) throw new Error("SemanticError", "this is outside the class", it.pos);
            it.type = it.thisExpr.type;
            it.type.typeName = className;
            it.isLeftValue = false;
        } else if (it.id != null) {
            DataType target1 = currentScope.findVarGlobally(it.id);
            funcDefNode target2 = currentScope.findFuncGlobally(it.id);
            if (target1 == null && target2 == null)  throw new Error("SemanticError", it.id + " is not defined", it.pos);
            if (target1 != null) it.type = target1;
            else it.type = new FuncType(target2);
            if (it.type.isFunc) it.isLeftValue = false;
            else it.isLeftValue = true;
        }
    }
    @Override
    public void visit(basicExprNode it){
        it.exprNode.accept(this);
        it.type = it.exprNode.type;
    }
    @Override
    public void visit(binaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type.typeName.equals("string") && it.rhs.type.typeName.equals("string")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else if (it.opStr.equals("+")) {
                if (it.lhs.type.isArray || it.rhs.type.isArray) throw new Error("SemanticError", "array doesn't support +", it.pos);
                it.type = new DataType("string");
            } else throw new Error("SemanticError", "invalid operation for string type", it.pos);
            it.isLeftValue = false;
        }
        if ((it.lhs.type.isArray && it.rhs.type.isArray) || (it.lhs.type.isNull && it.rhs.type.isArray) || (it.lhs.type.isArray && it.rhs.type.isNull)) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else throw new Error("SemanticError", "array doesn't support " + it.opStr, it.pos);
            it.isLeftValue = false;
        }
        if (!it.lhs.type.equals(it.rhs.type)) throw new Error("SemanticError", "binary type not the same", it.pos);
        if (it.lhs.type.isClass && it.rhs.type.isClass) {
            if (!it.opStr.equals("==") && !it.opStr.equals("!="))  throw new Error("SemanticError", "invalid operation for class type", it.pos);
            it.type = new DataType("bool");
            it.isLeftValue = false;
        }
        if (it.lhs.type.typeName.equals("int")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else if (it.opStr.equals("+") || it.opStr.equals("-") || it.opStr.equals("*") || it.opStr.equals("/") || it.opStr.equals("%") || it.opStr.equals("<<") || it.opStr.equals(">>")) {
                it.type = new DataType("int");
            } else throw new Error("SemanticError", "invalid operation for int type", it.pos);
        } else if (it.lhs.type.typeName.equals("bool")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals("&&") || it.opStr.equals("||")) {
                it.type = new DataType("bool");
            } else throw new Error("SemanticError", "invalid operation for bool type", it.pos);
        }
    }
    @Override
    public void visit(cFormatExpr it) {

    }
    @Override
    public void visit(funcExprNode it) {
        it.exprNode.accept(this);
        if (!it.exprNode.type.isFunc) throw new Error("SemanticError", it.exprNode.type.typeName + " is not a function name", it.pos);
        if (((FuncType)it.exprNode.type).def.para.paraList.size() != it.paraList.size())
            throw new Error("SemanticError", it.exprNode.type.typeName + " has wrong number of arguments", it.pos);
        for (int i = 0; i < it.paraList.size(); i++) {
            it.paraList.get(i).accept(this);
            if (it.paraList.get(i).type.equals(((FuncType) it.exprNode.type).def.para.paraList.get(i).paraType))
                throw new Error("SemanticError", it.paraList.get(i).type.typeName + " is not a parameter", it.pos);
        }
        it.isLeftValue = false;
        it.type = new DataType(((FuncType) it.exprNode.type).def.returnType);
    }
    @Override
    public void visit(indexExprNode it) {
        it.exprNode.accept(this);
        if (!it.exprNode.type.isArray) throw new Error("SemanticError", it.exprNode.type.typeName + " is not an array type", it.pos);
        for (var i: it.index) {
            i.accept(this);
            if (!i.type.typeName.equals("int") || i.type.isArray) throw new Error("SemanticError", "array index should be int type", it.pos);
        }
        it.type = new DataType(it.exprNode.type);
        it.type.arrayDim--;
        if (it.type.arrayDim == 0) it.type.isArray = false;
        it.isLeftValue = true;
    }
    @Override
    public void visit(initArrayExprNode it) {
        it.type.arrayDim++;
        if (it.list.isEmpty()) {
            it.type = new DataType();
            it.type.isNull = true;
            it.type.isArray = true;
            return;
        }
        for (var ini: it.list) {
            ini.accept(this);
        }
        for (int i = 0; i < it.list.size() - 1; i++) {
            if (!it.list.get(i).type.isNull && !it.list.get(i + 1).type.isNull &&!it.list.get(i).type.equals(it.list.get(i + 1).type))
                throw new Error("SemanticError", "initArray has different dataType", it.pos);
            if (!it.list.get(i).type.isNull) it.type.typeName = it.list.get(i).type.typeName;
        }
        it.type.isArray = true;
    }
    @Override
    public void visit(memberExprNode it) {
        it.obj.accept(this);
        if (it.obj.type.isArray) {
            if (!it.member.equals("length")) throw new Error("SemanticError", "invalid operation for member array", it.pos);
        }
        if (it.obj.type.isClass) {
            if (!globalScope.classMember.containsKey(it.obj.type.typeName)) throw new Error("SemanticError", "class not exist", it.pos);
            classDefNode classDef = globalScope.classMember.get(it.obj.type.typeName);
            if (classDef.varMap.containsKey(it.member)) {
                it.type = classDef.varMap.get(it.member).type;
                it.isLeftValue = true;
            } else if (classDef.funcMap.containsKey(it.member)) {
                funcDefNode function = classDef.funcMap.get(it.member);
                it.type = function.returnType;
                it.isLeftValue = false;
            } else throw new Error("SemanticError", "class " + classDef.className + " doesn't have member " + it.member, it.pos);
        }
        if (it.obj.type.typeName.equals("string")) {

        }
    }
    @Override
    public void visit(ternaryExprNode it) {
        it.expr1.accept(this);
        it.expr2.accept(this);
        it.expr3.accept(this);
        if (!it.expr1.type.typeName.equals("bool") || it.expr1.type.isArray) throw new Error("SemanticError", "conditional expression should be bool type", it.pos);
        if (!it.expr2.type.equals(it.expr3.type)) throw new Error("SemanticError", "conditional expression mismatched", it.pos);
        it.type = new DataType(it.expr1.type);
        it.isLeftValue = false;
    }
    @Override
    public void visit(unaryExprNode it) {
        it.exprNode.accept(this);
        if (it.opStr.equals("+") || it.opStr.equals("-") || it.opStr.equals("~")) {
            if (!it.exprNode.type.typeName.equals("int") || it.exprNode.type.isArray) throw new Error("SemanticError", "type error in unaryExpr +-~", it.pos);
            it.type = new DataType("int");
            it.isLeftValue = false;
        } else if (it.opStr.equals("!")) {
            if (!it.exprNode.type.typeName.equals("bool") || it.exprNode.type.isArray) throw new Error("SemanticError", "type error in unaryExpr !", it.pos);
            it.type = new DataType("bool");
            it.isLeftValue = false;
        } else if (it.opStr.equals("++") || it.opStr.equals("--")) {
            if (!it.exprNode.type.typeName.equals("int") || it.exprNode.type.isArray) throw new Error("SemanticError", "type error in unaryExpr ++/--", it.pos);
            it.type = new DataType("int");
            if (it.preOp) it.isLeftValue = true;
            else it.isLeftValue = false;
        } else throw new Error("SemanticError", "unaryOperator is unknown", it.pos);
    }
    @Override
    public void visit(varExprNode it) {
        if (!it.type.typeName.equals("int") && !it.type.typeName.equals("bool") && !it.type.typeName.equals("string")) {
            DataType target =  currentScope.findVarGlobally(it.type.typeName);
            if (target == null) throw new Error("SemanticError", "new class not found", it.pos);
            it.type.isClass = true;
            it.isLeftValue = false;
        }
    }

    @Override
    public void visit(blockStatNode it) {
        this.currentScope = new Scope(this.currentScope);
        for (var iter: it.statList) {
            it.accept(this);
        }
        this.currentScope = this.currentScope.parentScope;
    }
    @Override
    public void visit(breakStatNode it) {
        if (!this.currentScope.isLoopScope) {
            throw new Error("SemanticError", "break statement is not in the loop", it.pos);
        }
    }
    @Override
    public void visit(continueStatNode it) {
        if (!this.currentScope.isLoopScope) {
            throw new Error("SemanticError", "continue statement is not in the loop", it.pos);
        }
    }
    @Override
    public void visit(exprStatNode it) {
        if (it.exprNode != null) it.exprNode.accept(this);
    }
    @Override
    public void visit(forStatNode it) {
        currentScope = new Scope(currentScope);
        currentScope.isLoopScope = true;
        if (it.initExpr != null) it.initExpr.accept(this);
        if (it.initStat != null) it.initStat.accept(this);
        if (it.condExpr != null) {
            it.condExpr.accept(this);
            if (!it.condExpr.type.typeName.equals("bool") || it.condExpr.type.isArray)
                throw new Error("SemanticError", "conditional expression in for loop is wrong", it.pos);
        }
        if (it.stepExpr != null) it.stepExpr.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(ifStatNode it) {
        it.conExpr.accept(this);
        if (!it.conExpr.type.typeName.equals("bool") || it.conExpr.type.isArray)
            throw new Error("SemanticError", "conditional expression in if stat is wrong", it.pos);
        currentScope = new Scope(currentScope);
        it.ifStat.accept(this);
        currentScope = currentScope.parentScope;
        if (it.elseStat != null) {
            currentScope = new Scope(currentScope);
            it.elseStat.accept(this);
            currentScope = currentScope.parentScope;
        }
    }
    @Override
    public void visit(returnStatNode it) {
        if (it.exprNode != null) {
            it.exprNode.accept(this);
            Scope cur = this.currentScope;
            while (!(cur instanceof FuncScope) && cur != null) cur = cur.parentScope;
            if (cur != null) ((FuncScope) cur).checkReturn(it.exprNode.type, it.pos);
            else throw new Error("SemanticError", "no function needs return statement", it.pos);
            currentScope.returned = true;
        } else {
            Scope cur = this.currentScope;
            while (!(cur instanceof FuncScope) && cur != null) cur = cur.parentScope;
            if (cur != null) ((FuncScope) cur).checkReturn(new DataType("void"), it.pos);
            else throw new Error("SemanticError", "no function needs return statement", it.pos);
        }
    }
    @Override
    public void visit(varStatNode it){
        it.varDef.accept(this);
    }
    @Override
    public void visit(whileStatNode it) {
        it.whileExpr.accept(this);
        if (!it.whileExpr.type.typeName.equals("bool")) {
            throw new Error("SemanticError", "whileExpr is not bool type", it.pos);
        }
        if (it.whileStat != null) {
            this.currentScope = new Scope(this.currentScope, true);
            it.whileStat.accept(this);
            this.currentScope = this.currentScope.parentScope;
        }
    }

    @Override
    public void visit(classDefNode it) {
        currentScope = new ClassScope(currentScope);
        currentScope.className = it.className;
        for (var varDef: it.varMap.values()) {
            varDef.accept(this);
        }
        for (var funcDef: it.funcMap.values()) {
            if (funcDef.funcName.equals(it.className)) throw new Error("SemanticError", "function has the same name with class", it.pos);
            funcDef.accept(this);
        }
        if (!it.constructor.className.equals(it.className)) throw new Error("SemanticError", "constuctor has different name with the class", it.pos);
        it.constructor.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(constructNode it) {
        currentScope = new FuncScope(currentScope, new DataType("void"));
        it.blockStat.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(funcDefNode it) {
        if (it.returnType.isClass) {
            if (!globalScope.classMember.containsKey(it.returnType.typeName))
                throw new Error("SemanticError", "function's returnType doesn't exist", it.pos);
        }
        currentScope = new FuncScope(currentScope, it.returnType);
        if (!it.para.paraList.isEmpty()) it.para.accept(this);
        if (it.funcBlock != null) it.funcBlock.accept(this);
        if (!it.returnType.typeName.equals("void") && !currentScope.returned)
            throw new Error("SemanticError", "function has no returnType", it.pos);
    }
    @Override
    public void visit(mainDefNode it) {
        currentScope = new FuncScope(currentScope, new DataType("int"));
        if (it.blockStat != null) it.blockStat.accept(this);
    }
    @Override
    public void visit(paraListNode it) {
        for (var def: it.paraList) {
            if (def.paraType.isClass && !globalScope.classMember.containsKey(def.paraName))
                throw new Error("SemanticError", "invalid parameter for function", it.pos);
        }
    }
    @Override
    public void visit(varDefAtomNode it) {
        if (it.type.isClass && !globalScope.classMember.containsKey(it.type.typeName))
            throw new Error("SemanticError", "invalid variable definition type", it.pos);
        if (globalScope.classMember.containsKey(it.varName))
            throw new Error("SemanticError", "varible " + it.varName + " has the same name with function", it.pos);
        if (currentScope.members.containsKey(it.varName)) throw new Error("SemanticError", it.varName + " redefined", it.pos);
        if (it.assignNode != null) {
            it.assignNode.accept(this);
            if (!it.assignNode.type.equals(it.type)) throw new Error("SemanticError", "initialized variable's type is mismatched", it.pos);
        }
        currentScope.addVar(it.varName, it.pos, it.type);
    }
    @Override
    public void visit(varDefNode it) {
        for (var varDef: it.varList) {
            it.accept(this);
        }
    }
}
