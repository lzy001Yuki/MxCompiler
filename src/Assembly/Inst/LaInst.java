package Assembly.Inst;

import Assembly.Operand.*;

// 将符号 symbol 的地址加载到寄存器 rd 中。
public class LaInst extends ASMInst{
    public String symbol;
    public LaInst(Reg rd, String sym) {
        super(null, null, rd);
        symbol = sym;
    }
    @Override
    public String toString() {
        return "\tla " + rd + ", " + symbol + '\n';
    }
}
