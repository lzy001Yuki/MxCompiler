package AST.Stat;

import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;

public class blockStatNode extends statNode{
    public ArrayList<statNode> statList;
    public blockStatNode(Position p) {
        super(p);
        statList = new ArrayList<>();
    }
    public boolean empty() {
        return statList.isEmpty();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
