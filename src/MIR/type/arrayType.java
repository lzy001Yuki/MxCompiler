package MIR.type;

public class arrayType extends IRType{
    public int len = 0;
    public IRType indexType;
    public arrayType(IRType type, int l) {
        super(type.typeName);
        this.indexType = type;
        this.len = l;
    }
    @Override
    public String toString() {
        return "[" + len + " x " + indexType.toString() + "]";
    }
}
