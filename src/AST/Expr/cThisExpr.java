package AST.Expr;

import utils.DataType;

public class cThisExpr {
    public DataType type;
    public cThisExpr() {
        type = new DataType("this", false, false, false, false, true, false, 0);
    }
}
