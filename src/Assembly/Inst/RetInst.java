package Assembly.Inst;

public class RetInst extends ASMInst{
    public RetInst() {
        super(null, null, null);
    }
    @Override
    public String toString() {
        return "ret\n";
    }
}
