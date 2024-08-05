package AST.Expr;

import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;
public class arrayExprNode extends ExprNode{
    public ArrayList<ExprNode> indexList, iniList;
    public arrayExprNode(Position p) {
        super(p);
        indexList = new ArrayList<>();
        iniList = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
