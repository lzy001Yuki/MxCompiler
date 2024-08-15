package MIR.Instruction;

import MIR.irEntity.*;
import MIR.type.IRType;

public class AllocaInst extends Inst{
    public localPtr result;
    public IRType allocType;
    public String className;
    public AllocaInst(localPtr l, IRType type, String str) {
        this.result = l;
        this.allocType = type;
        this.className = str;
    }

    @Override
    public String toString() {
        if (allocType != null) return "%" + result.irName + " = alloca " + this.allocType;
        else return "%" + result.irName + " = alloca %class." + this.className;
    }
}
