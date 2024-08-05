package AST.Stat;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.Position;

public class exprStatNode extends statNode{
    public ExprNode exprNode;
    public exprStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
