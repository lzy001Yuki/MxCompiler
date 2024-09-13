package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;

import java.util.ArrayList;

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
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!pointer.isConstValue()) operands.add(pointer);
        return operands;
    }
    @Override
    public Entity getDef(){
        return result;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        pointer = replace;
    }
}
