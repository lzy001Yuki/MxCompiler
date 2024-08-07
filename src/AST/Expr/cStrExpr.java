package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cStrExpr {
    public String value;
    public DataType type;
    public cStrExpr(String val) {
        type = new DataType("string");
        this.value = val.substring(1, val.length() - 1);
    }
}
