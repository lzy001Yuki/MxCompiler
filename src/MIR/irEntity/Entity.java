package MIR.irEntity;

import MIR.type.IRType;

public abstract class Entity {
    public IRType type;
    public String irName;
    public Entity(IRType t, String str) {
        this.type = t;
        this.irName = str;
    }
}
