package Assembly.Operand;

import MIR.irEntity.Entity;
import MIR.irEntity.constBool;
import MIR.irEntity.constInt;

public class Imm extends Operand{
    public int value = 0;
    public Imm(int val) {
        value = val;
    }
    public Imm(Entity en) {
        if (en instanceof constInt cInt) {
            value = cInt.value;
        } else if (en instanceof constBool cBool) {
            value = cBool.value ? 1 : 0;
        }
    }
    @Override
    public String toString() {
        return "" + value;
    }
}
