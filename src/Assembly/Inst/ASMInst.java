package Assembly.Inst;

import Assembly.Operand.Operand;
import Assembly.Operand.Reg;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class ASMInst extends Operand {
    public Reg rs1, rs2, rd;
    public ASMInst(Reg rs1, Reg rs2, Reg rd) {
        this.rs1 = rs1;
        this.rs2 = rs2;
        this.rd = rd;
    }
    public HashSet<Reg> getUse() {
        HashSet<Reg> uses = new HashSet<>();
        if (rs1 != null) uses.add(rs1);
        if (rs2 != null) uses.add(rs2);
        return uses;
    }
    public HashSet<Reg> getDef() {
        HashSet<Reg> def = new HashSet<>();
        if (rd != null) def.add(rd);
        return def;
    }
}
