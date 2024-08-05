package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cBoolExprNode extends ExprNode{
    public boolean value;
    public cBoolExprNode(Position p, DataType t, boolean val) {
        super(p, t);
        this.value = val;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
