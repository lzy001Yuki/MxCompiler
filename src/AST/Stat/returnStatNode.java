package AST.Stat;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.Position;

public class returnStatNode extends statNode{
    public ExprNode exprNode = null;
    public returnStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
