package Assembly.Inst;

import Assembly.ASMBlock;

public class JumpInst extends ASMInst{
    public ASMBlock dest;
    public JumpInst(ASMBlock d) {
        super(null, null, null);
        dest = d;
    }
    @Override
    public String toString() {
        return "j " + dest.label + '\n';
    }
}
