package utils;

import parser.MxParser;

public class DataType {
    public boolean isClass = false, isFunc = false, isArray = false, isNull = false, isThis = false, isMain = false;
    public boolean isFormat = false;
    public int arrayDim = 0;
    public String typeName = null; // int/bool/string/className/void(returnType)/funcName/formatString
    public DataType(){}
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
    public DataType(String name) {
        this.typeName = name;
    }
    public DataType(DataType t) {
        this.typeName = t.typeName;
        this.isClass = t.isClass;
        this.isFormat = t.isFormat;
        this.isFunc = t.isFunc;
        this.isArray = t.isArray;
        this.arrayDim = t.arrayDim;
        this.isNull = t.isNull;
        this.isThis = t.isThis;
        this.isMain = t.isMain;
    }
    public DataType(MxParser.ReturnTypeContext ctx) {
        // void/typename
        if (ctx.Void() != null) {
            this.typeName = "void";
        } else {
            this.typeName = ctx.getText();
            if (ctx.typename().Identifier() != null) this.isClass = true;
            if (!ctx.typename().LBracket().isEmpty()) {
                this.isArray = true;
            }
            this.arrayDim = ctx.typename().LBracket().size();
        }
    }
    public DataType(MxParser.TypenameContext ctx) {
        this.typeName = ctx.getText();
        if (ctx.Identifier() != null) this.isClass = true;
        if (!ctx.LBracket().isEmpty()) {
            this.isArray = true;
        }
        this.arrayDim = ctx.LBracket().size();
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DataType other = (DataType) obj;
        if (isArray != other.isArray) return false;
        if (isNull != other.isNull) return false;
        if (isThis != other.isThis) return false;
        if (isClass != other.isClass) return false;
        if (isMain != other.isMain) return false;
        if (arrayDim != other.arrayDim) return false;
        if (isFunc != other.isFunc) return false;
        if (!typeName.equals(other.typeName)) return false;
        return true;
    }
}
