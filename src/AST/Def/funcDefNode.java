package AST.Def;

import AST.ASTVisitor;
import utils.DataType;
import AST.Stat.blockStatNode;
import utils.Position;

import java.util.ArrayList;

public class funcDefNode extends defNode{
    public DataType returnType;
    public blockStatNode funcBlock;
    public paraListNode para;
    public String funcName;
    public funcDefNode(Position p, String str) {
        super(p);
        this.funcName = str;
    }
    public funcDefNode(Position p, String str, DataType rt, ArrayList<paraDef> def) {
        super(p);
        this.funcName = str;
        para = new paraListNode(null);
        if (def != null) para.paraList = def;
        returnType = rt;
        funcBlock = new blockStatNode(null);
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
