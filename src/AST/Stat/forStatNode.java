package AST.Stat;

import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.Position;
import AST.Def.varDefNode;
public class forStatNode extends statNode{
    public ExprNode condExpr, stepExpr;
    public varDefNode initStat;
    public forStatNode(Position p) {
        super(p);
        condExpr = null;
        stepExpr = null;
        initStat = null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
