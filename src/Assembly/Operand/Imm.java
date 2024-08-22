package Assembly.Operand;

import MIR.irEntity.constBool;
import MIR.irEntity.constInt;

public class Imm extends Operand{
    int value = 0;
    public Imm(int val) {
        value = val;
    }
    public Imm(constInt cInt) {
        value = cInt.value;
    }
    public Imm(constBool cBool) {
        value = cBool.value ? 1 : 0;
    }
    @Override
    public String toString() {
        return "" + value;
    }
}
