package Assembly.Inst;

import Assembly.Operand.Reg;

public class ASMInst {
    public Reg rs1, rs2, rd;
    public ASMInst(Reg rs1, Reg rs2, Reg rd) {
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.rd = rd;
    }
}
