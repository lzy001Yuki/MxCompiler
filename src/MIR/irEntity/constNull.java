package MIR.irEntity;

import MIR.type.ptrType;

public class constNull extends Entity{
    public constNull() {
        super(new ptrType(), null);
    }
    @Override
    public String toString(){
        return this.type.toString() + " null";
    }
    @Override
    public String getName(){return "null";}
}
