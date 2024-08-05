package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class basicExprNode extends ExprNode{
    public ExprNode exprNode;
    public basicExprNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
