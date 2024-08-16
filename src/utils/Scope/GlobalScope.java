package utils.Scope;

import AST.Def.*;
import MIR.Instruction.BasicInst;
import MIR.Instruction.Inst;
import MIR.irEntity.*;
import MIR.type.intType;
import MIR.type.ptrType;
import MIR.type.voidType;
import utils.DataType;
import utils.Error;

import java.util.ArrayList;
import java.util.HashMap;

public class GlobalScope extends Scope {
    public HashMap<String, funcDefNode> funcMember = null;
    public HashMap<String, classDefNode> classMember = null;

    // IR
    public HashMap<String, globalClass> irClass = null;
    public HashMap<String, Entity> irMember = null;
    public HashMap<String, function> irFunction = null;
    public HashMap<String, function> builtInFunc = null;
    public ArrayList<Inst> globalInst;
    public GlobalScope() {
        super(null);
        funcMember = new HashMap<>();
        classMember = new HashMap<>();
        irClass = new HashMap<>();
        irFunction = new HashMap<>();
        irMember = new HashMap<>();
        builtInFunc = new HashMap<>();
        globalInst = new ArrayList<>();
        className = null;
        isLoopScope = false;
        addBuiltinFunc();
        addBuiltinIrFunc();
    }
    private void addBuiltinIrFunc() {
        function print_ = new function("print", new voidType(), false);
        print_.paraList.add(new localPtr("str"));
        builtInFunc.put("print", print_);
        function println_ = new function("println", new voidType(), false);
        println_.paraList.add(new localPtr("str"));
        builtInFunc.put("println", println_);
        function printInt_ = new function("printInt", new voidType(), false);
        printInt_.addPara(new localVar(new intType(), "n"));
        builtInFunc.put("printInt", printInt_);
        function printlnInt_ = new function("printlnInt", new voidType(), false);
        printlnInt_.addPara(new localVar(new intType(), "n"));
        builtInFunc.put("printlnInt", printlnInt_);
        builtInFunc.put("getString", new function("getString", new ptrType(), false));
        builtInFunc.put("getInt", new function("getInt", new intType(), false));
        function toString_ = new function("toString", new ptrType(), false);
        toString_.addPara(new localVar(new intType(), "i"));
        builtInFunc.put("toString", toString_);
        function size_ = new function("array.size", new intType(), true);
        builtInFunc.put("array.size", size_);
        function length_ = new function("string.length", new intType(), true);
        builtInFunc.put("string.length", length_);
        function substring_ = new function("string.substring", new ptrType(), true);
        substring_.addPara(new localVar(new intType(),"left"));
        substring_.addPara(new localVar(new intType(), "right"));
        builtInFunc.put("string.substring", substring_);
        builtInFunc.put("string.parseInt", new function("string.parseInt", new intType(), true));
        function ord_ = new function("string.ord", new intType(), true);
        ord_.addPara(new localVar(new intType(), "pos"));
        builtInFunc.put("string.ord", ord_);
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
    public void addIrClass(globalClass cls) {irClass.put(cls.irName, cls);}
    public void addBasicInst(BasicInst in) {globalInst.add(in);}
    public void addIrFunction(String name, function func) {irFunction.put(name, func);}
    public function getIrFunction(String name) {return irFunction.get(name);}
}
