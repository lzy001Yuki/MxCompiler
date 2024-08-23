package MIR.irEntity;

import Assembly.Operand.Operand;
import MIR.type.IRType;

public class Entity {
    public IRType type;
    public String irName;
    public Operand operand;
    public Entity(IRType t, String str) {
        this.type = t;
        this.irName = str;
    }
    public String getName(){return "%" + irName;}
    public boolean isConst() {
        return (this instanceof constNull) || (this instanceof constBool)
                || (this instanceof constInt) || (this instanceof constString);
    }
    public boolean isConstValue() {
        return (this instanceof constInt) || (this instanceof constBool);
    }
}
