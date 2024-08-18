package AST.Def;

import AST.ASTNode;
import AST.ASTVisitor;
import AST.Stat.blockStatNode;
import utils.*;

import java.util.ArrayList;
import java.util.HashMap;

public class classDefNode extends defNode{
    public String className;
    public constructNode constructor;
    public HashMap<String, funcDefNode> funcMap;
    public HashMap<String, Pair<Integer, varDefAtomNode>> varMap;
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
