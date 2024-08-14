package MIR.irEntity;

import MIR.type.arrayType;
import MIR.type.charType;
import MIR.type.ptrType;

public class constString extends Entity{
    public String value;
    public boolean isGlobal;
    public constString(String name, String val, boolean flag) {
        super(new ptrType(new arrayType(new charType(), val.length() + 1)), name);
        this.value = val + "\0";
        value = value.replace("\\", "\\5C")
                .replace("\0", "\\00")
                .replace("\n", "\\0A")
                .replace("\t", "\\09")
                .replace("\"", "\\22");
        this.isGlobal = flag;
    }
    @Override
    public String toString() {
        if (isGlobal) return ((ptrType)this.type).baseType.toString() + " c\"" + value + "\"";
        else return "@" + this.irName + " = private unnamed_addr constant " + ((ptrType)this.type).baseType.toString() + " c\"" + value + "\"";
    }
}
