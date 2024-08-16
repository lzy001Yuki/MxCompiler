package MIR.Instruction;

import MIR.irEntity.*;
import MIR.utils.label;

public class BrInst extends Inst{
    public localVar cond;
    public String iftrue, iffalse;
    public BrInst(localVar v, String str1, String str2) {
        cond = v;
        iftrue = str1;
        if (str2 != null)  iffalse = str2;
    }
    @Override
    public String toString() {
        if (cond != null) return "br "+cond+", label %"+iftrue+", label %"+iffalse;
        else return "br label %" +iftrue;
    }
}
