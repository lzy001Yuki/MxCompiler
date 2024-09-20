package Assembly.Inst;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;

import java.util.ArrayList;

public abstract class ASMInst extends Operand {
    public Reg rs1, rs2, rd;
    public ASMInst(Reg rs1, Reg rs2, Reg rd) {
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.rd = rd;
    }
    public ArrayList<Reg> getUse() {
        ArrayList<Reg> uses = new ArrayList<>();
        if (rs1 != null) uses.add(rs1);
        if (rs2 != null) uses.add(rs2);
        return uses;
    }
    public Reg getDef() {return rd;}
}
