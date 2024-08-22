package Assembly.Operand;

public class VirtualReg extends Reg{
    static int cnt = 0;
    public int index = 0;
    public VirtualReg() {
        index = cnt++;
    }
    @Override
    public String toString() {
        return "vr" + index;
    }
}
