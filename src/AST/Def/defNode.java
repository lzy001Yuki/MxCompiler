package AST.Def;

import AST.ASTNode;
import AST.Expr.ExprNode;
import utils.Position;

public abstract class defNode extends ASTNode {
    public defNode(Position p) {
        super(p);
    }
}
