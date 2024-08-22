package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;

public class LoadInst extends Inst{
    public Entity result;
    public Entity pointer;
    public LoadInst(Entity v, Entity e) {
        result = v;
        pointer = e;
    }
    @Override
    public String toString() {
        return result.getName()+" = load " + result.type+", ptr " + pointer.getName();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
