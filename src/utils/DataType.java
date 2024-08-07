package utils;

import parser.MxParserParser;

public class DataType {
    public boolean isClass = false, isFunc = false, isArray = false, isNull = false, isThis = false, isMain = false;
    public int arrayDim = 0;
    public String typeName = null; // int/bool/string/className/void(returnType)/funcName
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
    public DataType(MxParserParser.ReturnTypeContext ctx) {
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
    public DataType(MxParserParser.TypenameContext ctx) {
        this.typeName = ctx.getText();
        if (ctx.Identifier() != null) this.isClass = true;
        if (!ctx.LBracket().isEmpty()) {
            this.isArray = true;
        }
        this.arrayDim = ctx.LBracket().size();
    }
}
