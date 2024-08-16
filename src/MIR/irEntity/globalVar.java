package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.ptrType;
import MIR.type.arrayType;
public class globalVar extends Ptr{
    public Entity init = null; // int x = y --> init()
    public globalVar(IRType type, String name, Entity i) {
        super(type, name);
        init = i; // null / constVar
    }
    public globalVar(IRType type, String name) {
        super(type, name);
    }
    public globalVar(Entity en) {
        super(en.type, en.irName);
    }

    public String print(){
        if (init != null) return "@" + this.irName + " = global " + this.init;
        else if (((ptrType)this.type).baseType instanceof arrayType)
            return "@" + this.irName + " = global " + ((ptrType) this.type).baseType;
        else return "@" + this.irName + " = global " + ((ptrType) this.type).baseType.toString() + " 0";
    }

    @Override
    public String toString() {
        return this.type + " @" + this.irName;
    }
    public String getName() {
        return "@" + this.irName;
    }
}
