package AST;
import AST.Expr.*;
public interface ASTVisitor {
    public void visit(ASTNode it);
    public void visit(ProgramNode it);
    public void visit(cIntExprNode it);
    public void visit(cBoolExprNode it);
    public void visit(cStrExprNode it);
}
