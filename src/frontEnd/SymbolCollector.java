package frontEnd;

import AST.ASTVisitor;
import AST.Def.*;
import AST.Expr.*;
import AST.ProgramNode;
import AST.Stat.*;
import utils.Scope.GlobalScope;
import utils.Error;
public class SymbolCollector implements ASTVisitor {
    public GlobalScope globalScope = null;
    public SymbolCollector(GlobalScope scope) {
        this.globalScope = scope;
    }
    @Override
    public void visit(ProgramNode it) {
        for (var def: it.definition) {
            def.accept(this);
        }
    }
    @Override
    public void visit(arrayExprNode it) {}
    @Override
    public void visit(assignExprNode it){}
    @Override
    public void visit(atomExprNode it){}
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
    public void visit(blockStatNode it){}
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
    public void visit(returnStatNode it){}
    @Override
    public void visit(varStatNode it){}
    @Override
    public void visit(whileStatNode it){}

    @Override
    public void visit(classDefNode it) {
        if (this.globalScope.funcMember.containsKey(it.className))
            throw new Error("SemanticError", it.className + "duplicate with function name", it.pos);
        this.globalScope.addClass(it);
    }
    @Override
    public void visit(constructNode it) {}
    @Override
    public void visit(funcDefNode it) {
        if (this.globalScope.classMember.containsKey(it.funcName))
            throw new Error("SemanticError", it.funcName + " duplicate with class name", it.pos);
        this.globalScope.addFunc(it);
    }
    @Override
    public void visit(mainDefNode it) {}
    @Override
    public void visit(paraListNode it){}
    @Override
    public void visit(varDefAtomNode it){}
    @Override
    public void visit(varDefNode it){}
}
