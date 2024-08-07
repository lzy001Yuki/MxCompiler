package AST.Def;

import AST.ASTNode;
import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;

public class paraListNode extends ASTNode {
    public ArrayList<paraDef> paraList;
    public paraListNode(Position p) {
        super(p);
        paraList = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
