package Assembly.Operand;

// store address(relative to s0, actually points to the address)
public class VirtualReg extends Reg{
    public int index;
    public static int cnt = 0;
    public VirtualReg() {
        index = cnt;
        cnt++;
    }
    @Override
    public String toString() {
        return "%" + index;
    }
}
