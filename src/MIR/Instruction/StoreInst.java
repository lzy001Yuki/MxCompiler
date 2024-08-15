package MIR.Instruction;

import MIR.irEntity.*;

public class StoreInst extends Inst{
    public Entity value;
    public Entity pointer;
    public StoreInst(Entity obj1, Entity obj2) {
        this.value = obj1;
        this.pointer = obj2;
    }
    @Override
    public String toString() {
        return "store "+value.type+" "+value.getName()+", ptr "+pointer.getName();
    }
}
