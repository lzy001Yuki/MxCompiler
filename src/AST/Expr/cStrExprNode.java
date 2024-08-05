package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

// normal&format string
public class cStrExprNode extends ExprNode{
    public String value;
    public cStrExprNode(Position p, DataType t, String val) {
        super(p, t);
        this.value = val.substring(1, val.length() - 1);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
