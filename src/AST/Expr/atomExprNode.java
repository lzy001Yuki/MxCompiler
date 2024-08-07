package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

public class atomExprNode extends ExprNode{
    public cBoolExpr boolExpr = null;
    public cIntExpr intExpr = null;
    public cStrExpr strExpr = null;
    public cFormatExpr formatExpr = null;
    public cThisExpr thisExpr = null;
    public cNullExpr nullExpr = null;
    public String id = null;
    public atomExprNode(Position p) {
        super(p);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
