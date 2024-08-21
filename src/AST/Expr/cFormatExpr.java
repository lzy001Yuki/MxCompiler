package AST.Expr;

import AST.ASTNode;
import AST.ASTVisitor;
import utils.DataType;
import utils.Position;

import java.util.ArrayList;

public class cFormatExpr extends ExprNode {
    public String value;
    public ArrayList<ExprNode> expr;
    public boolean formatType;
    public String head, tail;
    public ArrayList<String> middle;
    public cFormatExpr(Position pos, String val, boolean t) {
        super(pos);
        type = new DataType("string");
        expr = new ArrayList<>();
        this.formatType = t;
        type.isFormat = true;
        middle = new ArrayList<>();
        this.value = val + "\0";
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
