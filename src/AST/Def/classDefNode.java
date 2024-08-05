package AST.Def;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stat.blockStatNode;
import utils.Position;

import java.util.HashMap;

public class classDefNode extends defNode{
    public String className;
    static class Constructor extends ASTNode {
        public String className;
        blockStatNode blockStat;
        Constructor(Position p, String str) {
            super(p);
            this.className = str;
        }
        @Override
        public void accept(ASTVisitor visitor) {
            visitor.visit(this);
        }
    }
    Constructor constructor;
    HashMap<String, funcDefNode> funcMap;
    HashMap<String, varDefAtomNode> varMap;
    public classDefNode(Position p, String str) {
        super(p);
        this.className = str;
        funcMap = new HashMap<>();
        varMap = new HashMap<>();
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
