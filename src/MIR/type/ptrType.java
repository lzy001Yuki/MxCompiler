package MIR.type;

public class ptrType extends IRType{
    public IRType baseType;
    public ptrType() {
        super("ptr");
    }
    public ptrType(IRType t) {
        super("ptr");
        baseType = t;
    }
}
