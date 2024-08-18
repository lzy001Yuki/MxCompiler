package MIR.type;

public class stringType extends IRType{
    int len;
    public stringType(){
        super(new arrayType(new charType()));
    }
    public stringType(String val) {
        super(new arrayType(new charType(), val.length() + 1));
        len = val.length() + 1;
    }
    @Override
    public String toString() {
        return "[" + len + " x " + "i8" + "]";
    }
}
