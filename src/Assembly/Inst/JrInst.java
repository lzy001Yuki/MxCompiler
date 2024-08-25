package Assembly.Inst;

import Assembly.Operand.Reg;

public class JrInst extends ASMInst{
    public JrInst(Reg rs) {
        super(rs, null, null);
    }
    @Override
    public String toString() {
        return "\tjr " + rs1 + "\n";
    }
}
