package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;
public class arrayExprNode extends ExprNode{
    public ArrayList<ExprNode> indexList;
    public initArrayExprNode iniList = null;
    public arrayExprNode(Position p) {
        super(p);
        indexList = new ArrayList<>();
        type.isArray = true;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
