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
        ArrayList<Entity> uses = new ArrayList<>();
        uses.add(src);
        return uses;
    }
    @Override
    public Entity getDef(){
        return dest;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {

    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public Entity getConst() {return null;}
    @Override
    public void entity2const(Entity old, Entity val) {
        if (dest.equals(old)) dest = val;
        if (src.equals(old)) src = val;
    }
}
