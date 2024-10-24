package Assembly.Inst;

import Assembly.Operand.Reg;

public class BinaryInst extends ASMInst{
    public String op;
    public BinaryInst(String op, Reg rd, Reg rs1, Reg rs2) {
        super(rs1, rs2, rd);
        this.op = op;
    }
    @Override
    public String toString() {
        if (rs2 != null) return '\t' + op + " " + rd + ", " + rs1 + ", " + rs2 + '\n';
        else return '\t' + op + " " + rd + ", " + rs1 + '\n';
    }
}
