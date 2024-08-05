package utils;

public class DataType {
    public boolean isClass, isFunc, isArray, isNull, isThis, isMain;
    public int arrayDim;
    public String typeName; // int/bool/string/className/void(returnType)/funcName
    public DataType(String name, boolean isc, boolean isf, boolean isa, boolean isn, boolean ist, boolean ism, int dim) {
        this.typeName = name;
        this.isClass = isc;
        this.isFunc = isf;
        this.isArray = isa;
        this.arrayDim = dim;
        this.isNull = isn;
        this.isThis = ist;
        this.isMain = ism;
    }
}
