package Assembly.Inst;

import Assembly.ASMBlock;
import Assembly.Operand.*;

public class BeqzInst extends ASMInst{
    public ASMBlock dest;
    public BeqzInst(Reg rs, ASMBlock lab) {
        super(rs, null, null);
        dest = lab;
    }
    @Override
    public String toString() {
        return "beqz " + rs1 + ", " + dest.label + '\n';
    }
}
