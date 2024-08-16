package AST.Def;

import MIR.irEntity.Entity;
import utils.DataType;

public class paraDef {
    public DataType paraType;
    public String paraName;
    public paraDef(DataType t, String str) {
        this.paraType = t;
        this.paraName = str;
    }
}