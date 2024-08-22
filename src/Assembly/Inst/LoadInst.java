package Assembly.Inst;

import Assembly.Operand.*;

public class LoadInst extends ASMInst{
    public Imm offset;
    public String loadType;
    public LoadInst(String type, Reg rd, Reg rs, Imm imm) {
        super(rs, null, rd);
        loadType = type;
        offset = imm;
    }
    @Override
    public String toString() {
        return loadType + " " + rd + ", " + offset + "(" + rs1 + ")\n";
    }
}
