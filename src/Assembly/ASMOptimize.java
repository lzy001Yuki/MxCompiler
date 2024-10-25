package Assembly;

import Assembly.Inst.JumpInst;

public class ASMOptimize {
    public ASMProgram program;
    public ASMOptimize(ASMProgram program) {
        this.program = program;
    }
    public void run() {
        for (var func: program.text) {
            jumpElimination(func);
        }
    }
    public void jumpElimination(ASMFunction func) {
        for (int i = 0; i < func.blocks.size() - 1; i++) {
            ASMBlock curBlk = func.blocks.get(i);
            ASMBlock nxtBlk = func.blocks.get(i + 1);
            if (curBlk.inst.getLast() instanceof JumpInst jump) {
                if (jump.dest.equals(nxtBlk.label)) curBlk.inst.removeLast();
            }
        }
    }
}
