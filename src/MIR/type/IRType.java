package MIR.type;

import utils.DataType;

public abstract class IRType {
    public int bit_width = 0;
    public String typeName = null;
    public IRType(String str) {
        if (str.equals("void")) typeName = "void";
        else if (str.equals("ptr")) typeName = "ptr";
        else typeName = str;
    }
    public IRType(IRType obj) {
        typeName = obj.typeName;
        bit_width = obj.bit_width;
    }

    static public IRType dataToIR(DataType data) {
        if (data.isArray) {
            data.arrayDim--;
            if (data.arrayDim == 0) {
                data.isArray = false;
            } return new ptrType(dataToIR(data));
        }
        if (data.isNull) return new ptrType();
        if (data.typeName.equals("int")) return new intType();
        else if (data.typeName.equals("bool")) return new boolType();
        else if (data.isClass || data.isThis) return new ptrType(new classType(data.typeName));
        else if (data.typeName.equals("string")) {
            return new ptrType(new stringType());
        }
        else if (data.typeName.equals("void")) return new voidType();
        else throw new RuntimeException("wrong dataToIR type");
    }

    @Override
    public String toString(){
        return typeName;
    }
}
