package MIR.Instruction;

import MIR.irEntity.Entity;
import MIR.type.voidType;

public class RetInst extends Inst{
    public Entity retType;
    public RetInst(Entity obj) {
        retType = obj;
    }
    @Override
    public String toString() {
        if (retType.type instanceof voidType) return "ret void";
        else return "ret " + retType.type + " " + retType.irName;
    }
}
