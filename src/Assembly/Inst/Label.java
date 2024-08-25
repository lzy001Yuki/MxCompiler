package Assembly.Inst;

public class Label extends ASMInst{
    public String symbol;
    public Label(String str) {
        super(null, null, null);
        symbol = str;
    }
    @Override
    public String toString() {
        return symbol + ":\n";
    }
}
