package Assembly.Inst;

import Assembly.ASMBlock;

public class JumpInst extends ASMInst{
    public String dest;
    public JumpInst(String d) {
        super(null, null, null);
        dest = d;
    }
    @Override
    public String toString() {
        return "\tj " + dest + '\n';
    }
}
