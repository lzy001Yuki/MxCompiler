package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;

public class initArrayExprNode extends ExprNode{
    public ArrayList<ExprNode> list;
    public initArrayExprNode(Position pos) {
        super(pos);
        list = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
