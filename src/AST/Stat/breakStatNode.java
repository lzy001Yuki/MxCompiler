package AST.Stat;

import AST.ASTVisitor;
import utils.Position;

public class breakStatNode extends statNode{
    public breakStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
