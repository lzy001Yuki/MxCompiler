package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.utils.label;

public class BrInst extends Inst{
    public Entity cond;
    public String iftrue, iffalse;
    public BrInst(Entity v, String str1, String str2) {
        cond = v;
        iftrue = str1;
        if (str2 != null)  iffalse = str2;
    }
    @Override
    public String toString() {
        if (cond != null) return "br "+cond+", label %"+iftrue+", label %"+iffalse;
        else return "br label %" +iftrue;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
