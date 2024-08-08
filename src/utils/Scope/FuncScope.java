package utils.Scope;

import utils.DataType;
import utils.Error;
import utils.Position;

public class FuncScope extends Scope {
    public DataType returnType = null;
    public FuncScope(Scope parent, DataType ret){
        super(parent);
        this.returnType = ret;
    }
    public void checkReturn(DataType rt, Position pos) {
        if (rt.isThis && returnType.typeName.equals(rt.typeName)) return;
        if (!returnType.equals(rt)) throw new Error("SemanticError", "function has wrong return type", pos);
    }
}
