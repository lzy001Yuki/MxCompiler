package AST.Def;
import AST.ASTVisitor;
import utils.Position;

import java.util.ArrayList;
public class varDefNode extends defNode{
    public ArrayList<varDefAtomNode> varList;
    public varDefNode(Position p) {
        super(p);
        varList = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
