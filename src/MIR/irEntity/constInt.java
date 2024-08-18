package MIR.irEntity;

import MIR.type.intType;

public class constInt extends Entity {
    public int value = 0;
    public constInt(int val){
        super(new intType(), null);
        this.value = val;
    }
    @Override
    public String toString() {
        return this.type.toString() + " " + value;
    }
    @Override
    public String getName() {
        return ""+value;
    }
}
