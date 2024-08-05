package AST.Stat;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.Position;

public class whileStatNode extends statNode{
    public ExprNode whileExpr;
    public statNode whileStat;
    public whileStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
