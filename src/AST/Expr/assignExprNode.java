package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class assignExprNode extends ExprNode{
    public ExprNode lhs, rhs;
    public assignExprNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
