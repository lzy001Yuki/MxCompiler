package MIR.irEntity;

import MIR.type.arrayType;
import MIR.type.charType;
import MIR.type.ptrType;
import MIR.type.stringType;

public class constString extends Entity{
    public String value;
    public constString(String name, String val) {
        super(new ptrType(new stringType(val)), name);
        this.value = val + "\0";
    }
    @Override
    public String toString() {
        return "@" + this.irName + " = private unnamed_addr constant [" + ((stringType)((ptrType)this.type).baseType).len + " x " + "i8" + "]" + " c\"" + value.replace("\\", "\\5C").
                replace("\0", "\\00")
                .replace("\n", "\\0A")
                .replace("\t", "\\09")
                .replace("\"", "\\22")  + "\"";
    }
    @Override
    public String getName() {
        return "@" + this.irName;
    }
}
