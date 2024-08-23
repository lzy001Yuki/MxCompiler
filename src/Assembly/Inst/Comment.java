package Assembly.Inst;

import Assembly.Operand.Operand;
import MIR.IRVisitor;
import MIR.Instruction.*;

public class Comment extends ASMInst {
    public String comment;
    public Comment(String str) {
        super(null, null, null);
        comment = str;
    }
    @Override
    public String toString() {return "# " + comment + ";\n";}
}
