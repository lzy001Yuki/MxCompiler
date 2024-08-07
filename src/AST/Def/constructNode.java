package AST.Def;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stat.blockStatNode;
import utils.Position;

public class constructNode extends ASTNode {
    public String className;
    public blockStatNode blockStat;
    public constructNode(Position p, String str) {
        super(p);
        this.className = str;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}