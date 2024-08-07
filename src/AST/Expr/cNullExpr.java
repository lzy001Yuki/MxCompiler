package AST.Expr;

import utils.DataType;

public class cNullExpr {
    public DataType type;
    public cNullExpr() {
        type = new DataType("null", false, false, false, true, false, false, 0);
    }
}
