package AST.Stat;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.Position;

public class ifStatNode extends statNode{
    public ExprNode conExpr;
    public statNode ifStat, elseStat = null;
    public ifStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
