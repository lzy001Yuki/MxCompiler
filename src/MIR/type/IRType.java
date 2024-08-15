package MIR.type;

import utils.DataType;

public abstract class IRType {
    public int bit_width = 0;
    public String typeName = null;
    public IRType(String str) {
        if (str.equals("void")) typeName = "void";
        else if (str.equals("ptr")) typeName = "ptr";
        else if (str.charAt(0) == 'i') {
            typeName = "int"; //i1 refers to bool type
            bit_width = Integer.parseInt(str.substring(1));
        } else typeName = str; // classType
    }

    static public IRType dataToIR(DataType data) {
        if (data.typeName.equals("int")) return new intType();
        else if (data.typeName.equals("bool")) return new boolType();
        else if (data.isClass || data.isThis) return new ptrType(new classType(data.typeName));
        else if (data.isNull) return new ptrType();
        else if (data.isArray) {
            data.arrayDim--;
            if (data.arrayDim == 0) data.isArray = false;
            return new ptrType(dataToIR(data));
        } else if (data.typeName.equals("string")) return new ptrType(new arrayType(new charType()));
        else throw new RuntimeException("wrong ir type");
    }

    @Override
    public String toString(){
        if (typeName.equals("void") || typeName.equals("ptr")) return typeName;
        else return "i" + String.valueOf(bit_width);
    }
}
