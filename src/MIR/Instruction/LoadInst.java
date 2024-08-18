package MIR.Instruction;

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
}
