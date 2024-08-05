package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class memberExprNode extends ExprNode{
    public ExprNode obj, member;
    public memberExprNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
