package MIR.irEntity;

import MIR.type.intType;

public class constInt extends Entity {
    public int value = 0;
    public constInt(String name) {
        super(new intType(), name);
    }
    public constInt(String name, int val){
        super(new intType(), name);
        this.value = val;
    }
    @Override
    public String toString() {
        return this.type.toString() + " " + value;
    }
}
