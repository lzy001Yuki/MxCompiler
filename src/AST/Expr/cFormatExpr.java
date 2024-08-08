package AST.Expr;

import AST.ASTNode;
import AST.ASTVisitor;
import utils.DataType;
import utils.Position;
public class cFormatExpr extends ExprNode {
    public String value;
    public cFormatExpr(Position pos, String val) {
        super(pos);
        type = new DataType("string");
        type.isFormat = true;
        this.value = val.substring(1, val.length() - 1);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
