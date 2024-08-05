package AST.Def;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Expr.ExprNode;
import utils.DataType;
import utils.Position;

public class varDefAtomNode extends ASTNode {
    public DataType type;
    public String varName;
    public ExprNode assignNode;
    public varDefAtomNode(Position p, String str) {
        super(p);
        this.varName = str;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
