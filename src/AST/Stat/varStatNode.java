package AST.Stat;
import AST.ASTVisitor;
import AST.Def.varDefNode;
import utils.Position;

public class varStatNode extends statNode{
    public varDefNode varDef;
    public varStatNode(Position p) {
        super(p);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
