package Assembly.Inst;

import Assembly.ASMBlock;
import Assembly.Operand.*;

public class BeqzInst extends ASMInst{
    public String dest;
    public BeqzInst(Reg rs, String lab) {
        super(rs, null, null);
        dest = lab;
    }
    @Override
    public String toString() {
        return "\tbeqz " + rs1 + ", " + dest + '\n';
    }
}
