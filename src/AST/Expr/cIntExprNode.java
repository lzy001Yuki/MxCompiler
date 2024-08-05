package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cIntExprNode extends ExprNode{
    public int value;
    public cIntExprNode(Position p, DataType t, int val) {
        super(p, t);
        this.value = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
