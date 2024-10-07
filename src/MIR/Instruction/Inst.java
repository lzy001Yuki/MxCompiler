package MIR.Instruction;

import Assembly.Operand.Operand;
import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.type.IRType;
import MIR.utils.block;

import java.util.ArrayList;

public abstract class Inst{
    public block belongedBlock;
    public boolean isDead = false;
    abstract public String toString();
    abstract public void accept(IRVisitor visitor);
    abstract public ArrayList<Entity> getUses();
    abstract public Entity getDef();
    abstract public void replaceOperand(Entity old, Entity replace);
    abstract public Entity getConst();
    abstract public void entity2const(Entity old, Entity val);
}
