package AST.Stat;

import AST.ASTNode;
import AST.Expr.ExprNode;
import utils.Position;

public abstract class statNode extends ASTNode {
    public statNode(Position p) {
        super(p);
    }
}
