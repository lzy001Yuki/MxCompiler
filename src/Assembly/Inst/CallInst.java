package Assembly.Inst;

public class CallInst extends ASMInst{
    public String funcLabel;
    public CallInst(String label) {
        super(null, null, null);
        funcLabel = label;
    }
    @Override
    public String toString() {
        return "call " + funcLabel + '\n';
    }
}
