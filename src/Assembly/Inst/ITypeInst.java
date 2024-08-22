package Assembly.Inst;


import Assembly.Operand.*;

public class ITypeInst extends ASMInst {
    public String op;
    public Imm imm;
    public ITypeInst(String op, Reg rs1, Reg rd, Imm imm) {
        super(rs1, null, rd);
        this.op = op;
        this.imm = imm;
    }
    @Override
    public String toString() {
        return op + " " + rd + ", " + rs1 + ", " + imm + "\n";
    }
}
