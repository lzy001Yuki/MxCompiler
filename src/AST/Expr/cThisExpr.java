package AST.Expr;

import utils.DataType;

public class cThisExpr {
    public DataType type;
    public cThisExpr() {
        type = new DataType("null", false, false, false, false, true, false, 0);
    }
}
