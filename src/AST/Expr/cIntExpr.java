package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cIntExpr {
    public int value;
    public DataType type;
    public String valStr;
    public cIntExpr(String str) {
        valStr = str;
        type = new DataType("int");
    }
    public cIntExpr(int val) {
        this.value = val;
        type = new DataType("int");
    }

}
