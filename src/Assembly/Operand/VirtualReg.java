package Assembly.Operand;

import java.util.HashSet;

// store address(relative to s0, actually points to the address)
public class VirtualReg extends Reg{
    public int index;
    public static int cnt = 0;
    public VirtualReg() {
        index = cnt;
        cnt++;
        adjList = new HashSet<>();
        moveList = new HashSet<>();
    }
    @Override
    public String toString() {
        return "%" + index;
    }
}
