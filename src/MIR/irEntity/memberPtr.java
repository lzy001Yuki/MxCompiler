package MIR.irEntity;

import MIR.type.IRType;

public class memberPtr extends Ptr{
    public String className;
    public int index;
    public Ptr parent;
    public memberPtr(IRType type, String name, String clsName, int id) {
        super(type, name);
        className = clsName;
        index = id;
    }
    public memberPtr(String name, String clsName, int id) {
        super(name);
        className = clsName;
        index = id;
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
