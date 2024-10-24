package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.utils.label;

import java.util.ArrayList;

public class BrInst extends Inst{
    public Entity cond;
    public String iftrue, iffalse;
    public BrInst(Entity v, String str1, String str2) {
        cond = v;
        iftrue = str1;
        if (str2 != null)  iffalse = str2;
    }
    @Override
    public Inst getCopy() {return new BrInst(cond, iftrue, iffalse);}
    @Override
    public String toString() {
        if (cond != null) return "br "+cond+", label %"+iftrue+", label %"+iffalse;
        else return "br label %" +iftrue;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (cond != null && !cond.isConstValue()) operands.add(cond);
        return operands;
    }
    @Override
    public Entity getDef(){
        return null;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        if (old.equals(cond)) cond = replace;
    }
    @Override
    public Entity getConst() {
        if (cond != null && cond.isConstValue()) return cond;
        else return null;
    }

    @Override
    public void entity2const(Entity old, Entity val) {
        if (cond.equals(old)) cond = val;
    }
}
