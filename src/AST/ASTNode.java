package AST;
import utils.Position;
abstract public class ASTNode {
    public Position pos;
    public ASTNode(Position p) {
        this.pos = p;
    }
    abstract public void accept(ASTVisitor visitor);
}
