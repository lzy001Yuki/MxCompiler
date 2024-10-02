package AST.Def;

import AST.ASTVisitor;
import utils.DataType;
import AST.Stat.blockStatNode;
import utils.Position;

public class mainDefNode extends funcDefNode {
    //public blockStatNode blockStat;
    public mainDefNode(Position p) {
        super(p, "main", new DataType("int"), null);
        para = new paraListNode(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
