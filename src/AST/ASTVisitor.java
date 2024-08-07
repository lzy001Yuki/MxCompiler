package AST;
import AST.Expr.*;
import AST.Stat.*;
import AST.Def.*;
public interface ASTVisitor {
    public void visit(ASTNode it);
    public void visit(ProgramNode it);

    public void visit(arrayExprNode it);
    public void visit(assignExprNode it);
    public void visit(atomExprNode it);
    public void visit(basicExprNode it);
    public void visit(binaryExprNode it);
    public void visit(funcExprNode it);
    public void visit(indexExprNode it);
    public void visit(memberExprNode it);
    public void visit(ternaryExprNode it);
    public void visit(unaryExprNode it);

    public void visit(blockStatNode it);
    public void visit(breakStatNode it);
    public void visit(continueStatNode it);
    public void visit(exprStatNode it);
    public void visit(forStatNode it);
    public void visit(ifStatNode it);
    public void visit(returnStatNode it);
    public void visit(varStatNode it);
    public void visit(whileStatNode it);

    public void visit(classDefNode it);
    public void visit(funcDefNode it);
    public void visit(mainDefNode it);
    public void visit(varDefNode it);
    public void visit(paraDef it);
    public void visit(constructNode it);
    public void visit(varDefAtomNode it);
}
