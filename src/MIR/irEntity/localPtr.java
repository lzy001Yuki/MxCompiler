package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.ptrType;
import utils.DataType;

import static MIR.type.IRType.dataToIR;

public class localPtr extends Entity{
    public localPtr(IRType type, String str) {
        super(new ptrType(type), str);
    }
    public localPtr(DataType data, String str) {
        super(dataToIR(data), str);
    }
    @Override
    public String toString() {
        return this.type + " %" + this.irName;
    }
    public String getName() {
        return "%" + this.irName;
    }
}
