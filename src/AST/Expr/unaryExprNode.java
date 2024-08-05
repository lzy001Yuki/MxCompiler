package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class unaryExprNode extends ExprNode{
    public String opStr;
    public ExprNode exprNode;
    public unaryExprNode(Position p, String str) {
        super(p);
        this.opStr = str;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
