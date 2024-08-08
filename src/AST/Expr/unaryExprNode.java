package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class unaryExprNode extends ExprNode{
    public String opStr;
    public ExprNode exprNode;
    public boolean preOp;
    public unaryExprNode(Position p, String str, boolean pre) {
        super(p);
        this.opStr = str;
        this.preOp = pre;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
