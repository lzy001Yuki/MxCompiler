package Assembly.Operand;

import MIR.Instruction.MoveInst;

import java.util.HashSet;

public class PhysicReg extends Reg{
    public String name;
    public PhysicReg(String str) {
        this.name = str;
        adjList = new HashSet<>();
        moveList = new HashSet<>();
        degree = Integer.MAX_VALUE;
        color = this;
    }
    @Override
    public String toString() {
        return name;
    }
}
