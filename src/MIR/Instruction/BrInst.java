package MIR.Instruction;

import MIR.irEntity.*;
import MIR.utils.label;

public class BrInst extends Inst{
    public localVar cond;
    public label iftrue, iffalse;
    public BrInst(localVar v, String str1, String str2) {
        cond = v;
        iftrue = new label(str1);
        if (str2 != null)  iffalse = new label(str2);
    }
    @Override
    public String toString() {
        if (cond != null) return "br i1 "+cond+", label "+iftrue+", label "+iffalse;
        else return "br label " +iftrue;
    }
}
