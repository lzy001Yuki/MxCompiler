package MIR.irEntity;

import MIR.type.IRType;

public class localVar extends Entity{
    public localVar(IRType type, String str) {
        super(type, str);
    }
    @Override
    public String toString() {
        return this.type + " %" + this.irName;
    }
    public String getName() {
        return "%" + this.irName;
    }
}
