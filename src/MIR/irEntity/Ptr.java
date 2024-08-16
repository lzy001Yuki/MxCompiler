package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.ptrType;

public class Ptr extends Entity{
    public Ptr(IRType type, String name) {
        super(new ptrType(type), name);
    }
    public Ptr(String name) {
        super(new ptrType(), name);
    }
}
