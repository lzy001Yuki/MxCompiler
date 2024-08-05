package AST.Stat;

import AST.ASTVisitor;
import utils.Position;

public class continueStatNode extends statNode{
    public continueStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
