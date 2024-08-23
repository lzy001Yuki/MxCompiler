package Assembly.Inst;

import Assembly.Operand.*;

public class StoreInst extends ASMInst{
    public Imm offset;
    public String storeType;
    public StoreInst(String type, Reg rs2, Reg rs1, Imm i) {
        super(rs1, rs2, null);
        offset = i;
        storeType = type;
    }
    @Override
    public String toString() {
        return '\t' +storeType + " " + rs2 + ", " + offset + "(" + rs1 + ")\n";
    }
}
