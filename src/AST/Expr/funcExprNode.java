package AST.Expr;
import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;

public class funcExprNode extends ExprNode{
    public ExprNode exprNode;
    public ArrayList<ExprNode> paraList;
    public funcExprNode(Position p) {
        super(p);
        paraList = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
