package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class ternaryExprNode extends ExprNode{
    public ExprNode expr1, expr2, expr3;
    public ternaryExprNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
