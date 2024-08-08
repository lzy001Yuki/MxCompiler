package AST.Expr;

import AST.ASTVisitor;
import utils.Position;
import java.util.ArrayList;
// type shouldn't be array
public class indexExprNode extends ExprNode{
    public ExprNode exprNode;
    public ArrayList<ExprNode> index;
    public indexExprNode(Position p) {
        super(p);
        index = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
