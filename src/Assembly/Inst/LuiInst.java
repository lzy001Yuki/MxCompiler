package Assembly.Inst;

import Assembly.Operand.*;

// 将立即数 imm 的高 20 位加载到目标寄存器 rd 的高位部分
public class LuiInst extends ASMInst{
    public Imm imm;
    public LuiInst(Reg rd, Imm imm) {
        super(null, null, rd);
        this.imm = imm;
    }
    @Override
    public String toString() {
        return "lui " + rd + ", " + imm + '\n';
    }
}
