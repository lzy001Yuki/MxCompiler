package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.arrayType;

import java.util.ArrayList;

public class constArray extends Entity{
    public ArrayList<Entity> array;
    public constArray(IRType t, String name, int len) {
        super(new arrayType(t, len), name);
    }
    @Override
    public String toString() {
        String ans = null;
        for (var it: array) {
            ans += (", " + it.toString());
        }
        return this.type.toString() + " [" + ans + "]";
    }
}
