package AST.Expr;
import AST.ASTNode;
import MIR.irEntity.Entity;
import utils.Position;
import utils.DataType;
public abstract class ExprNode extends ASTNode{
    public DataType type;
    public boolean isLeftValue;
    public Entity entity;
    ExprNode(Position p) {
        super(p);
    }
    ExprNode(Position p, DataType t) {
        super(p);
        this.type = t;
    }
}
