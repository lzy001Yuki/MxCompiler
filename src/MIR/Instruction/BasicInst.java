package MIR.Instruction;

import MIR.IRVisitor;

public class BasicInst extends Inst{
    public String instStr;
    public BasicInst(String str) {
        instStr = str;
    }
    @Override
    public String toString() {
        return instStr;
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
