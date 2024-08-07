package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class varExprNode extends ExprNode{
    public varExprNode(Position pos) {
        super(pos);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
