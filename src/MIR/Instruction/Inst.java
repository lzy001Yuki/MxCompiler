package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.type.IRType;

public abstract class Inst{
    abstract public String toString();
    abstract public void accept(IRVisitor visitor);
}
