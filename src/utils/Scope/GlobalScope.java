package utils.Scope;

import AST.Def.*;
import utils.DataType;
import utils.Error;

import java.util.ArrayList;
import java.util.HashMap;

public class GlobalScope extends Scope {
    public HashMap<String, funcDefNode> funcMember = null;
    public HashMap<String, classDefNode> classMember = null;
    public GlobalScope() {
        super(null);
        funcMember = new HashMap<>();
        classMember = new HashMap<>();
        className = null;
        isLoopScope = false;
        addBuiltinFunc();
    }
    private void addBuiltinFunc() {
        funcDefNode length = new funcDefNode(null, "length", new DataType("int"), null);
        funcMember.put(length.funcName, length);
        ArrayList<paraDef> para1 = new ArrayList<>();
        para1.add(new paraDef(new DataType("int"), "left"));
        para1.add(new paraDef(new DataType("int"), "right"));
        funcDefNode substring = new funcDefNode(null, "substring", new DataType("string"), para1);
        funcMember.put(substring.funcName, substring);
        funcDefNode parseInt = new funcDefNode(null, "parseInt", new DataType("int"), null);
        funcMember.put(parseInt.funcName, parseInt);
        ArrayList<paraDef> para2 = new ArrayList<>();
        para2.add(new paraDef(new DataType("int"), "pos"));
        funcDefNode ord = new funcDefNode(null, "ord", new DataType("int"), para2);
        funcMember.put(ord.funcName, ord);
        ArrayList<paraDef> para3 = new ArrayList<>();
        para3.add(new paraDef(new DataType("string"), "str"));
        funcDefNode print = new funcDefNode(null, "print", new DataType("void"), para3);
        funcMember.put(print.funcName, print);
        ArrayList<paraDef> para4 = new ArrayList<>();
        para4.add(new paraDef(new DataType("string"), "str"));
        funcDefNode println = new funcDefNode(null, "println", new DataType("void"), para4);
        funcMember.put(println.funcName, println);
        ArrayList<paraDef> para5 = new ArrayList<>();
        para5.add(new paraDef(new DataType("int"), "n"));
        funcDefNode printInt = new funcDefNode(null, "printInt", new DataType("void"), para5);
        funcMember.put(printInt.funcName, printInt);
        ArrayList<paraDef> para6 = new ArrayList<>();
        para6.add(new paraDef(new DataType("int"), "n"));
        funcDefNode printlnInt = new funcDefNode(null, "printlnInt", new DataType("void"), para6);
        funcMember.put(printlnInt.funcName, printlnInt);
        funcDefNode getString = new funcDefNode(null, "getString", new DataType("string"), null);
        funcMember.put(getString.funcName, getString);
        funcDefNode getInt = new funcDefNode(null, "getInt", new DataType("int"), null);
        funcMember.put(getInt.funcName, getInt);
        ArrayList<paraDef> para7 = new ArrayList<>();
        para7.add(new paraDef(new DataType("int"), "i"));
        funcDefNode toString = new funcDefNode(null, "toString", new DataType("string"), para7);
        funcMember.put(toString.funcName, toString);
        funcDefNode size = new funcDefNode(null, "size", new DataType("int"), null);
        funcMember.put(size.funcName, size);
    }
    public void addFunc(funcDefNode def) {
        if (funcMember.containsKey(def.funcName)) throw new Error("SemanticError", "Multiple Definitions", def.pos);
        funcMember.put(def.funcName, def);
    }
    public void addClass(classDefNode def) {
        if (classMember.containsKey(def.className)) throw new Error("SemanticError", "Multiple Definitions", def.pos);
        classMember.put(def.className, def);
    }
    public funcDefNode getFunc(String name) {
        return funcMember.get(name);
    }
    public classDefNode getClass(String name) {
        return classMember.get(name);
    }
}
