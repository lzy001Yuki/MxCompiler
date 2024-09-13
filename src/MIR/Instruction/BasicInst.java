package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;

import java.util.ArrayList;

public class BasicInst extends Inst{
    public String instStr;
    public BasicInst(String str) {
        instStr = str;
    }
    @Override
    public String toString() {
        return instStr;
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public ArrayList<Entity> getUses(){
        return new ArrayList<>();
    }
    @Override
    public Entity getDef(){
        return null;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {

    }
}
