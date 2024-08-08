package utils;

import AST.Def.funcDefNode;

import java.util.ArrayList;

public class FuncType extends DataType{
    public funcDefNode def;
    public FuncType(funcDefNode it) {
        def = it;
        this.isFunc = true;
        this.typeName = it.funcName;
    }
}
