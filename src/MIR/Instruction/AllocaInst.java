package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.type.IRType;
import MIR.utils.block;

import java.util.ArrayList;

public class AllocaInst extends Inst{
    public Entity result;
    public IRType allocType;
    public String className;
    public AllocaInst(Entity l, IRType type, String str) {
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

    @Override
    public ArrayList<Entity> getUses(){
        return new ArrayList<>();
    }
    @Override
    public Entity getDef(){
        return result;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {

    }
    @Override
    public Entity getConst() {
        return null;
    }

    @Override
    public void entity2const(Entity old, Entity val) {}

}
