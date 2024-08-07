package utils.Scope;

import utils.DataType;
import utils.Error;
import utils.Position;

public class FuncScope extends Scope {
    DataType returnType;
    public FuncScope(Scope parent, DataType ret){
        super(parent);
        this.returnType = ret;
    }
    public void checkReturn(DataType rt, Position pos) {
        if (!returnType.typeName.equals(rt.typeName)) throw new Error("SemanticError", "function has wrong return type", pos);
    }
}
