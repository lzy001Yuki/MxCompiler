package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class atomExprNode extends ExprNode{
    public cBoolExprNode boolExpr = null;
    public cIntExprNode intExpr = null;
    public cStrExprNode strExpr = null;
    public String id = null;
    public atomExprNode(Position p) {
        super(p);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
