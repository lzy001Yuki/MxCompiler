package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import utils.Pair;

import java.util.ArrayList;

public class MoveInst extends Inst{
    public Entity dest;
    public Entity src;
    public MoveInst(Entity dest, Entity src) {
        this.dest = dest;
        this.src = src;
    }
    @Override
    public String toString() {
        return "move " + dest.getName() + ", " + src.getName();
    }
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
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
