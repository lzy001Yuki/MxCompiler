package Assembly.Inst;

import Assembly.Operand.Reg;
import MIR.Instruction.CommentInst;
import MIR.Instruction.Inst;

import java.util.HashSet;

public class CompInst extends ASMInst {
    String op;
    String lab;
    public CompInst(Reg rs1, Reg rs2, String op, String lab) {
        super(rs1, rs2, null);
        this.op = op;
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "\t" + op + " " + rs1 + ", " + rs2 + ", " + lab + "\n";
    }
}
