package Assembly.Inst;

import Assembly.Operand.Reg;
import Assembly.utils.RegStore;

import java.util.HashSet;

public class CallInst extends ASMInst{
    public String funcLabel;
    public CallInst(String label) {
        super(null, null, null);
        funcLabel = label;
    }
    @Override
    public String toString() {
        return "\tcall " + funcLabel + '\n';
    }
    @Override
    public HashSet<Reg> getDef() {
        return new HashSet<>(RegStore.callerSave());
    }
}
