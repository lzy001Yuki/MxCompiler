package MIR.irEntity;

import MIR.type.boolType;

public class constBool extends Entity {
    public boolean value = false;
    public constBool(boolean val) {
        super(new boolType(), null);
        this.value = val;
    }
    @Override
    public String toString(){
        if (value)  return this.type.toString() + " 1";
        else return this.type.toString() + " 0";
    }
    @Override
    public String getName() {
        if (value) return "" + 1;
        else return "" + 0;
    }
}
