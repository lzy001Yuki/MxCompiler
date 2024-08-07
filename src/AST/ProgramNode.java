package AST;
import AST.Def.defNode;
import utils.Position;
import java.util.ArrayList;

public class ProgramNode extends ASTNode{
    public ArrayList<defNode> definition; // funcDef/classDef/varDef/mainDef
    public ProgramNode(Position p){
        super(p);
        this.definition = new ArrayList<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
