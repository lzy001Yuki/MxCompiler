package MIR.irEntity;

import MIR.type.boolType;

public class constBool extends Entity {
    public boolean value = false;
    public constBool(String name) {
        super(new boolType(), name);
    }
    public constBool(String name, boolean val) {
        super(new boolType(), name);
        this.value = val;
    }
    @Override
    public String toString(){
        if (value)  return this.type.toString() + " 1";
        else return this.type.toString() + " 0";
    }
}
