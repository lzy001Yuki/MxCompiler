package MIR.irEntity;

import MIR.type.ptrType;
import MIR.type.arrayType;
public class globalVar extends Entity{
    public Entity init; // int x = y --> init()
    public globalVar(Entity var, Entity i) {
        super(new ptrType(var.type), var.irName);
        init = i; // null / constVar
    }
    @Override
    public String toString(){
        if (init != null) return "@" + this.irName + " = global " + this.init.toString();
        else if (((ptrType)this.type).baseType instanceof arrayType)
            return "@" + this.irName + " = global " + this.type.toString();
        else return "@" + this.irName + " = global " + this.type.toString() + " 0";
    }
}
