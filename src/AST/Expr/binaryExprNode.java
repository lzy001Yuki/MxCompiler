package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class binaryExprNode extends ExprNode{
    public ExprNode lhs, rhs;
    public String opStr;
    public binaryExprNode(Position p, String str) {
        super(p);
        this.opStr = str;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
