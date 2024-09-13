package MIR.Instruction;

import Assembly.Operand.Operand;
import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.type.IRType;

import java.util.ArrayList;

public abstract class Inst{
    abstract public String toString();
    abstract public void accept(IRVisitor visitor);
    abstract public ArrayList<Entity> getUses();
    abstract public Entity getDef();
    abstract public void replaceOperand(Entity old, Entity replace);
}
