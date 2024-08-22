package Assembly.Inst;

import Assembly.Operand.Reg;

public class MvInst extends ASMInst{
    public MvInst(Reg rs, Reg rd) {
        super(rs, null, rd);
    }
    @Override
    public String toString() {
        return "mv " + rd + ", " + rs1 + '\n';
    }
}
