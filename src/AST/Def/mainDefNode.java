package AST.Def;

import AST.ASTVisitor;
import utils.DataType;
import AST.Stat.blockStatNode;
import utils.Position;

public class mainDefNode extends defNode {
    public blockStatNode blockStat;
    public mainDefNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
