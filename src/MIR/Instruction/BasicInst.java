package MIR.Instruction;

public class BasicInst extends Inst{
    public String instStr;
    public BasicInst(String str) {
        instStr = str;
    }
    @Override
    public String toString() {
        return instStr;
    }
}
