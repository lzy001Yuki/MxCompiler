package MIR.Instruction;

import MIR.irEntity.*;

public class LoadInst extends Inst{
    public localVar result;
    public Entity pointer;
    public LoadInst(localVar v, Entity e) {
        result = v;
        pointer = e;
    }
    @Override
    public String toString() {
        return result.getName()+" = load " + result.type+", ptr " + pointer.getName();
    }
}
