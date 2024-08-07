package AST.Expr;

import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

public class cIntExpr {
    public int value;
    DataType type;
    public cIntExpr(int val) {
        this.value = val;
        type = new DataType("int");
    }

}
