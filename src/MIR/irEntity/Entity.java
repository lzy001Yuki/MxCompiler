package MIR.irEntity;

import MIR.type.IRType;

public class Entity {
    public IRType type;
    public String irName;
    public Entity(IRType t, String str) {
        this.type = t;
        this.irName = str;
    }
    public String getName(){return null;}
    public boolean isConst() {
        return (this instanceof constNull) || (this instanceof constBool)
                || (this instanceof constInt) || (this instanceof constString);
    }
}
