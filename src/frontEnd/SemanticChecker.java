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

import java.math.BigInteger;
import java.util.Map;

public class SemanticChecker implements ASTVisitor {
    public Scope currentScope;
    public GlobalScope globalScope;
    public SemanticChecker(GlobalScope global) {
        this.globalScope = global;
        this.currentScope = (Scope) this.globalScope;
    }
    @Override
    public void visit(ProgramNode it) {
        for (var def: it.definition) {
            def.accept(this);
        }
    }
    @Override
    public void visit(arrayExprNode it) {
        if (it.type.isClass) {
            if (!globalScope.classMember.containsKey(it.type.typeName))
                throw new Error("SemanticError", "Undefined Identifier" , it.pos);
        }
        for (var index: it.indexList) {
            index.accept(this);
            if (!index.type.typeName.equals("int") || index.type.isArray)
                throw new Error("SemanticError", "Invalid Type", it.pos);
        }
        if (it.indexList.isEmpty() && (it.iniList == null || it.iniList.list.isEmpty())) throw new Error("SemanticError", "Invalid Array Initialization", it.pos);
        if (it.iniList != null) {
            if (it.iniList.type == null) it.iniList.type = new DataType();
            it.iniList.accept(this);
            if (!it.iniList.type.equals(it.type)) throw new Error("SemanticError", "Type Mismatch", it.pos);
        }
        it.isLeftValue = false;
    }
    @Override
    public void visit(assignExprNode it){
        it.lhs.accept(this);
        if (it.rhs instanceof initArrayExprNode) throw new Error("SemanticError", "Const array only allowed when created", it.pos);
        it.rhs.accept(this);
        if (it.rhs instanceof arrayExprNode) ((arrayExprNode)it.rhs).assignExpr = it.lhs;
        if (it.rhs instanceof initArrayExprNode) ((initArrayExprNode) it.rhs).assignNode = it.lhs;
        if (!it.lhs.isLeftValue) throw new Error("SemanticError",  "Type Mismatch", it.pos);
        if (!it.lhs.type.equals(it.rhs.type) && !it.rhs.type.isNull) throw new Error("SemanticError", "Type Mismatch", it.pos);
        if (it.rhs.type.isNull && it.lhs.type.checkBaseType()) throw new Error("SemanticError", "Type Mismatch", it.pos);
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
            if (className == null) throw new Error("SemanticError", "Invalid Type", it.pos);
            it.type = it.thisExpr.type;
            it.type.typeName = className;
            it.isLeftValue = false;
        } else if (it.id != null) {
            DataType target1 = currentScope.findVarGlobally(it.id);
            funcDefNode target2 = currentScope.findFuncGlobally(it.id);
            if (target1 == null && target2 == null)  throw new Error("SemanticError", "Undefined Identifier" , it.pos);
            if (target1 != null) it.type = target1;
            if (target2 != null) it.type = new FuncType(target2);
            if (it.type.isFunc) it.isLeftValue = false;
            else it.isLeftValue = true;
        }
    }
    @Override
    public void visit(basicExprNode it){
        it.exprNode.accept(this);
        it.type = it.exprNode.type;
        it.isLeftValue = it.exprNode.isLeftValue;
    }
    @Override
    public void visit(binaryExprNode it) {
        it.lhs.accept(this);
        it.rhs.accept(this);
        if (it.lhs.type.typeName.equals("string") && it.rhs.type.typeName.equals("string")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else if (it.opStr.equals("+")) {
                if (it.lhs.type.isArray || it.rhs.type.isArray) throw new Error("SemanticError", "Invalid Type", it.pos);
                it.type = new DataType("string");
            } else throw new Error("SemanticError", "Invalid Type", it.pos);
            it.isLeftValue = false;
            return;
        }
        if ((it.lhs.type.isArray && it.rhs.type.isArray)) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else throw new Error("SemanticError", "Invalid Type", it.pos);
            it.isLeftValue = false;
            return;
        }
        if ((it.lhs.type.isNull || it.rhs.type.isNull) || (it.lhs.type.isThis && it.rhs.type.isThis)) {
            if (it.opStr.equals("==") || it.opStr.equals("!=")) {
                it.type = new DataType("bool");
            } else throw new Error("SemanticError", "Invalid Type", it.pos);
            return;
        }
        if (!it.lhs.type.equals(it.rhs.type)) throw new Error("SemanticError", "Invalid Type", it.pos);
        if (it.lhs.type.isClass && it.rhs.type.isClass) {
            if (!it.opStr.equals("==") && !it.opStr.equals("!="))  throw new Error("SemanticError", "Invalid Type", it.pos);
            it.type = new DataType("bool");
            it.isLeftValue = false;
            return;
        }
        if (it.lhs.type.typeName.equals("int")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals(">") || it.opStr.equals("<") || it.opStr.equals(">=") || it.opStr.equals("<=")) {
                it.type = new DataType("bool");
            } else if (it.opStr.equals("+") || it.opStr.equals("-") || it.opStr.equals("*") || it.opStr.equals("/") || it.opStr.equals("%") || it.opStr.equals("<<") || it.opStr.equals(">>") || it.opStr.equals("|") || it.opStr.equals("^") || it.opStr.equals("&")) {
                it.type = new DataType("int");
            } else throw new Error("SemanticError", "Invalid Type", it.pos);
        } else if (it.lhs.type.typeName.equals("bool")) {
            if (it.opStr.equals("==") || it.opStr.equals("!=") || it.opStr.equals("&&") || it.opStr.equals("||")) {
                it.type = new DataType("bool");
            } else throw new Error("SemanticError", "Invalid Type", it.pos);
        }
    }
    @Override
    public void visit(cFormatExpr it) {
        if (!it.formatType) {
            for (var e: it.expr) {
                e.accept(this);
                if (!e.type.checkBaseType()) throw new Error("SemanticError", "Invalid Type", it.pos);
            }
        }
        it.isLeftValue = false;
    }
    @Override
    public void visit(funcExprNode it) {
        it.exprNode.accept(this);
        if (!it.exprNode.type.isFunc) throw new Error("SemanticError", "Undefined Identifier", it.pos);
        if (((FuncType)it.exprNode.type).def.para.paraList.size() != it.paraList.size())
            throw new Error("SemanticError", it.exprNode.type.typeName + " has wrong number of arguments", it.pos);
        for (int i = 0; i < it.paraList.size(); i++) {
            it.paraList.get(i).accept(this);
            if (!it.paraList.get(i).type.equals(((FuncType) it.exprNode.type).def.para.paraList.get(i).paraType))
                throw new Error("SemanticError", it.paraList.get(i).type.typeName + " is not a parameter type", it.pos);
        }
        it.isLeftValue = false;
        it.type = new DataType(((FuncType) it.exprNode.type).def.returnType);
    }
    @Override
    public void visit(indexExprNode it) {
        it.exprNode.accept(this);
        int dim = it.exprNode.type.arrayDim;
        if (!it.exprNode.type.isArray) throw new Error("SemanticError", "Undefined Identifier", it.pos);
        for (var i: it.index) {
            i.accept(this);
            dim--;
            if (!i.type.typeName.equals("int") || i.type.isArray) throw new Error("SemanticError", "Invalid Type", it.pos);
            if (dim < 0) throw new Error("SemanticError", "Dimension Out Of Bound", it.pos);
        }
        it.type = new DataType(it.exprNode.type);
        it.type.arrayDim = dim;
        if (it.type.arrayDim == 0) it.type.isArray = false;
        it.isLeftValue = true;
    }
    @Override
    public void visit(initArrayExprNode it) {
        if (it.type == null) it.type = new DataType();
        it.type.isArray = true;
        it.type.arrayDim++;
        if (it.list.isEmpty()) {
            it.type = new DataType();
            it.type.isNull = true;
            it.type.isArray = true;
            it.type.arrayDim++;
            return;
        }
        for (var ini: it.list) {
            if (ini.type == null) ini.type = new DataType();
            ini.accept(this);
        }
        DataType itType = it.list.getFirst().type;
        for (int i = 0; i < it.list.size() - 1; i++) {
            if (!it.list.get(i).type.isNull && !it.list.get(i + 1).type.isNull &&!it.list.get(i).type.equals(it.list.get(i + 1).type))
                throw new Error("SemanticError", "Type Mismatch", it.pos);
            if (it.list.get(i).type.isNull || it.list.get(i + 1).type.isNull) {
                if (it.list.get(i).type.arrayDim != it.list.get(i + 1).type.arrayDim)
                    throw new Error("SemanticError", "Type Mismatch", it.pos);
            }
            if (!it.list.get(i).type.isNull) itType = it.list.get(i).type;
        }
        for (int i = 0; i < it.list.size(); i++) it.list.get(i).type = itType;
        it.type = it.list.getFirst().type;
        it.type.arrayDim = it.list.getFirst().type.arrayDim + 1;
        it.type.isArray = true;
        it.isLeftValue = false;
    }
    @Override
    public void visit(memberExprNode it) {
        it.obj.accept(this);
        if (it.obj.type.isArray) {
            if (!it.member.equals("size")) throw new Error("SemanticError", "array type doesn't have function " + it.member, it.pos);
            it.type = new FuncType(globalScope.getFunc("size"));
            return;
        }
        if (it.obj.type.isClass || it.obj.type.isThis) {
            if (!globalScope.classMember.containsKey(it.obj.type.typeName)) throw new Error("SemanticError", "Undefined Identifier", it.pos);
            classDefNode classDef = globalScope.getClass(it.obj.type.typeName);
            if (classDef.varMap.containsKey(it.member)) {
                it.type = classDef.varMap.get(it.member).getSecond().type;
                it.isLeftValue = true;
            } else if (classDef.funcMap.containsKey(it.member)) {
                funcDefNode function = classDef.funcMap.get(it.member);
                it.type = new FuncType(function);
                it.isLeftValue = false;
            } else throw new Error("SemanticError", "class " + classDef.className + " doesn't have member " + it.member, it.pos);
            return;
        }
        if (it.obj.type.typeName.equals("string")) {
            switch (it.member) {
                case ("length") :
                    it.type = new FuncType(globalScope.getFunc("length"));
                    break;
                case ("substring") :
                    it.type = new FuncType(globalScope.getFunc("substring"));
                    break;
                case ("parseInt") :
                    it.type = new FuncType(globalScope.getFunc("parseInt"));
                    break;
                case ("ord") :
                    it.type = new FuncType(globalScope.getFunc("ord"));
                    break;
                default:
                    throw new Error("SemanticError", "string type doesn't have member "+ it.member, it.pos);
            }
            return;
        }
        throw new Error("SemanticError", it.obj.type.typeName + " doesn't has member " + it.member, it.pos);
    }
    @Override
    public void visit(ternaryExprNode it) {
        it.expr1.accept(this);
        it.expr2.accept(this);
        it.expr3.accept(this);
        if (!it.expr1.type.typeName.equals("bool") || it.expr1.type.isArray) throw new Error("SemanticError", "Invalid Type for condition expression in ternary expression", it.pos);
        if (!it.expr2.type.equals(it.expr3.type) && !it.expr2.type.isNull && !it.expr3.type.isNull) throw new Error("SemanticError", "Invalid Type for ifelse expression in ternary expression", it.pos);
        it.type = new DataType(it.expr2.type);
        it.isLeftValue = false;
    }
    @Override
    public void visit(unaryExprNode it) {
        it.exprNode.accept(this);
        if (it.opStr.equals("+") || it.opStr.equals("-") || it.opStr.equals("~")) {
            if (!it.exprNode.type.typeName.equals("int") || it.exprNode.type.isArray) throw new Error("SemanticError", "invalid unary operation +-~", it.pos);
            if (it.exprNode instanceof atomExprNode && ((atomExprNode) it.exprNode).intExpr != null) {
                if (it.opStr.equals("+")) {
                    if (((atomExprNode) it.exprNode).intExpr.valStr != null) {
                        BigInteger val1 = new BigInteger(((atomExprNode) it.exprNode).intExpr.valStr);
                        BigInteger val2 = new BigInteger("214783647");
                        if (val1.compareTo(val2) > 0)
                            throw new Error("SemanticError", "int field exceeded", it.pos);
                    }
                } else {
                    if (((atomExprNode) it.exprNode).intExpr.valStr != null) {
                        BigInteger val1 = new BigInteger(((atomExprNode) it.exprNode).intExpr.valStr);
                        BigInteger val2 = new BigInteger("214783648");
                        if (val1.compareTo(val2) > 0)
                            throw new Error("SemanticError", "int field exceeded", it.pos);
                    }
                }
            }
            it.type = new DataType("int");
            it.isLeftValue = false;
        } else if (it.opStr.equals("!")) {
            if (!it.exprNode.type.typeName.equals("bool") || it.exprNode.type.isArray) throw new Error("SemanticError", "invalid unary operation !", it.pos);
            it.type = new DataType("bool");
            it.isLeftValue = false;
        } else if (it.opStr.equals("++") || it.opStr.equals("--")) {
            if (!it.exprNode.type.typeName.equals("int") || it.exprNode.type.isArray) throw new Error("SemanticError", "invalid unary operation ++/--", it.pos);
            if (!it.exprNode.isLeftValue) throw new Error("SemanticError", "++/-- should operate on left value", it.pos);
            it.type = new DataType("int");
            if (it.preOp) it.isLeftValue = true;
            else it.isLeftValue = false;
        } else throw new Error("SemanticError", "invalid unary operation", it.pos);
    }
    @Override
    public void visit(varExprNode it) {
        if (!it.type.typeName.equals("int") && !it.type.typeName.equals("bool") && !it.type.typeName.equals("string")) {
            //DataType target =  currentScope.findVarGlobally(it.type.typeName);
            classDefNode target = globalScope.classMember.get(it.type.typeName);
            if (target == null) throw new Error("SemanticError", "Undefined Identifier", it.pos);
            it.type.isClass = true;
            it.isLeftValue = false;
        }
    }

    @Override
    public void visit(blockStatNode it) {
        this.currentScope = new Scope(this.currentScope);
        for (var iter: it.statList) {
            iter.accept(this);
        }
        this.currentScope = this.currentScope.parentScope;
    }
    @Override
    public void visit(breakStatNode it) {
        if (!this.currentScope.isInLoop()) {
            throw new Error("SemanticError", "Invalid Control Flow", it.pos);
        }
    }
    @Override
    public void visit(continueStatNode it) {
        if (!this.currentScope.isInLoop()) {
            throw new Error("SemanticError", "Invalid Control Flow", it.pos);
        }
    }
    @Override
    public void visit(exprStatNode it) {
        if (it.exprNode != null) it.exprNode.accept(this);
        if (it.exprNode instanceof memberExprNode && it.exprNode.type instanceof FuncType) {
            throw new Error("SemanticError", ((memberExprNode) it.exprNode).member + " is a function member not a variable member", it.pos);
        }
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
                throw new Error("SemanticError", "Invalid Type", it.pos);
        }
        if (it.stepExpr != null) it.stepExpr.accept(this);
        if (it.stat != null) it.stat.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(ifStatNode it) {
        it.conExpr.accept(this);
        if (!it.conExpr.type.typeName.equals("bool") || it.conExpr.type.isArray)
            throw new Error("SemanticError", "Invalid Type", it.pos);
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
            else throw new Error("SemanticError", "Redundant return statement", it.pos);
            cur.returned = true;
        } else {
            Scope cur = this.currentScope;
            while (!(cur instanceof FuncScope) && cur != null) cur = cur.parentScope;
            if (cur != null) ((FuncScope) cur).checkReturn(new DataType("void"), it.pos);
            else throw new Error("SemanticError", "Redundant return statement", it.pos);
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
            throw new Error("SemanticError", "Invalid Type", it.pos);
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
            varDef.getSecond().accept(this);
        }
        if (currentScope instanceof ClassScope) ((ClassScope) currentScope).funcMember = it.funcMap;
        for (var funcDef: it.funcMap.values()) {
            if (funcDef.funcName.equals(it.className)) throw new Error("SemanticError", "Multiple Definitions", it.pos);
            funcDef.accept(this);
            funcDef.irName = "@" + it.className + "." + funcDef.funcName;
        }
        if (it.constructor != null) {
            if (!it.constructor.className.equals(it.className))
                throw new Error("SemanticError", "constructor has different function name with the class", it.pos);
            it.constructor.accept(this);
        }
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
                throw new Error("SemanticError", "Missing Return Statement", it.pos);
        }
        currentScope = new FuncScope(currentScope, it.returnType);
        if (!it.para.paraList.isEmpty()) {
            it.para.accept(this);
            for (var def: it.para.paraList) {
                currentScope.addVar(def.paraName, it.pos, def.paraType);
            }
        }
        if (it.funcBlock != null) it.funcBlock.accept(this);
        if (!it.returnType.typeName.equals("void") && !currentScope.returned)
            throw new Error("SemanticError", "Missing Return Statement", it.pos);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(mainDefNode it) {
        currentScope = new FuncScope(currentScope, new DataType("int"));
        if (it.blockStat != null) it.blockStat.accept(this);
        currentScope = currentScope.parentScope;
    }
    @Override
    public void visit(paraListNode it) {
        for (var def: it.paraList) {
            if (def.paraType.isClass && !globalScope.classMember.containsKey(def.paraType.typeName))
                throw new Error("SemanticError", "Undefined Identifier", it.pos);
        }
    }
    @Override
    public void visit(varDefAtomNode it) {
        if (it.type.isClass && !globalScope.classMember.containsKey(it.type.typeName))
            throw new Error("SemanticError", "Undefined Identifier", it.pos);
        if (globalScope.funcMember.containsKey(it.varName) && !it.varName.equals("size") && !it.varName.equals("length"))
            throw new Error("SemanticError", "Multiple Definitions", it.pos);
        if (currentScope.members.containsKey(it.varName)) throw new Error("SemanticError", "Multiple Definitions", it.pos);
        if (it.assignNode != null) {
            if (it.assignNode.type == null)  it.assignNode.type = new DataType();
            it.assignNode.accept(this);
            if (!it.assignNode.type.equals(it.type) && !it.assignNode.type.isNull) throw new Error("SemanticError", "Type Mismatch", it.pos);
            if (it.assignNode.type.isNull && it.type.checkBaseType()) throw new Error("SemanticError", "Type Mismatch", it.pos);
        }
        currentScope.addVar(it.varName, it.pos, it.type);
        if (it.assignNode instanceof arrayExprNode) {
            atomExprNode atom = new atomExprNode(null);
            atom.id = it.varName;
            atom.accept(this);
            ((arrayExprNode)it.assignNode).assignExpr = atom;
        }
        if (it.assignNode instanceof initArrayExprNode) {
            atomExprNode atom = new atomExprNode(null);
            atom.id = it.varName;
            atom.accept(this);
            ((initArrayExprNode) it.assignNode).assignNode = atom;
        }
    }
    @Override
    public void visit(varDefNode it) {
        for (var def: it.varList) {
            def.accept(this);
        }
    }
}
