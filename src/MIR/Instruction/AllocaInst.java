package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.type.IRType;

public class AllocaInst extends Inst{
    public Ptr result;
    public IRType allocType;
    public String className;
    public AllocaInst(Ptr l, IRType type, String str) {
        this.result = l;
        this.allocType = type;
        this.className = str;
    }

    @Override
    public String toString() {
        if (allocType != null) return "%" + result.irName + " = alloca " + this.allocType;
        else return "%" + result.irName + " = alloca %class." + this.className;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
