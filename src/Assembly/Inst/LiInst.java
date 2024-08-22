package Assembly.Inst;

import Assembly.Operand.*;

// 将立即数加载到目标寄存器rd中
public class LiInst extends ASMInst{
    public Imm imm;
    public LiInst(Reg rd, Imm i) {
        super(null, null, rd);
        imm = i;
    }
    @Override
    public String toString() {
        return "li " + rd + ", " + imm + '\n';
    }
}
