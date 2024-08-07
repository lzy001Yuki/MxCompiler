package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cBoolExpr {
    public boolean value;
    public DataType type;
    public cBoolExpr(boolean val) {
        this.value = val;
        type = new DataType("bool");
    }
}
