package MIR.irEntity;

import MIR.type.arrayType;
import MIR.type.charType;
import MIR.type.ptrType;
import MIR.type.stringType;

public class constString extends Entity{
    public String value;
    public constString(String name, String val) {
        super(new ptrType(new stringType(name)), name);
        this.value = val + "\0";
        value = value.replace("\\", "\\5C")
                .replace("\0", "\\00")
                .replace("\n", "\\0A")
                .replace("\t", "\\09")
                .replace("\"", "\\22");
    }
    @Override
    public String toString() {
        return "@" + this.irName + " = private unnamed_addr constant " + ((ptrType)this.type).baseType.toString() + " c\"" + value + "\"";
    }
    @Override
    public String getName() {
        return "@" + this.irName;
    }
}
