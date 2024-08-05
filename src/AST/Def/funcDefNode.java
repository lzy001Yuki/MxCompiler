package AST.Def;

import AST.ASTVisitor;
import utils.DataType;
import AST.Stat.blockStatNode;
import utils.Position;

import java.util.ArrayList;

public class funcDefNode extends defNode{
    DataType returnType;
    blockStatNode funcBlock;
    static class paraDef {
        public DataType paraType;
        public String paraName;
        paraDef(DataType t, String str) {
            this.paraType = t;
            this.paraName = str;
        }
    }
    ArrayList<paraDef> paraList;
    public String funcName;
    public funcDefNode(Position p, String str) {
        super(p);
        this.paraList = new ArrayList<>();
        this.funcName = str;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
