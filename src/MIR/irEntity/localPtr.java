package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.ptrType;
import utils.DataType;

import static MIR.type.IRType.dataToIR;

public class localPtr extends Ptr{
    public localPtr(IRType type, String str) {
        super(type, str);
    }
    public localPtr(Entity en) {
        super(en.type, en.irName);
    }
    public localPtr(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return this.type + " %" + this.irName;
    }
    @Override
    public String getName() {
        return "%" + this.irName;
    }
}
