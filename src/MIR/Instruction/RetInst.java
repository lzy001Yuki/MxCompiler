package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.type.IRType;
import MIR.type.voidType;

public class RetInst extends Inst{
    public Entity retType;
    public RetInst(Entity obj) {
        retType = obj;
    }
    public RetInst(IRType type, String name) {
        retType = new Entity(type, name);
    }
    @Override
    public String toString() {
        if (retType.type instanceof voidType) return "ret void";
        else return "ret " + retType.type + " " + retType.getName();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
