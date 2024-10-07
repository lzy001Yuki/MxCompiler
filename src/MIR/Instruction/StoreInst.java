package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;

import java.util.ArrayList;

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
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!value.isConstValue()) operands.add(value);
        return operands;
    }
    @Override
    public Entity getDef(){
        return pointer;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        value = replace;
    }
    @Override
    public Entity getConst() {return null;}
    @Override
    public void entity2const(Entity old, Entity val) {
        if (value.equals(old)) value = val;
    }
}
