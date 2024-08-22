package Assembly;

import Assembly.Operand.Operand;
import Assembly.Operand.stringGlobal;
import Assembly.Operand.varGlobal;
import MIR.IRVisitor;
import MIR.Instruction.*;
import MIR.irEntity.function;
import MIR.utils.block;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;

import java.util.ArrayList;
import java.util.Map;
import MIR.irEntity.*;
import MIR.type.*;

public class InstSelector implements IRVisitor {
    public Scope globalScope;
    public ArrayList<Operand> data;
    public ArrayList<Operand> text;
    public ArrayList<Operand> rodata;
    public ASMBlock curBlock;
    public ASMFunction curFunc;
    public int funcNum = 0;
    public InstSelector(GlobalScope global) {
        globalScope = global;
        data = new ArrayList<>();
        text = new ArrayList<>();
        rodata = new ArrayList<>();
    }
    @Override
    public void visit(GlobalScope it){
        for (Map.Entry<String, Ptr> entry: it.pointers.entrySet()) {
            data.add(new varGlobal(entry.getKey(), (globalVar) entry.getValue()));
        }
        for (var cString: it.globalString) {
            rodata.add(new stringGlobal(cString.irName, cString.value));
        }
        for (Map.Entry<String, function> entry: it.irFunction.entrySet()) {
            funcNum++;
            curFunc = new ASMFunction(entry.getValue().irName);
            entry.getValue().accept(this);
            text.add(curFunc);
        }
    }
    @Override
    public void visit(block it){
        for (var iter: it.instructions) {
            iter.accept(this);
        }
    }
    @Override
    public void visit(function it){
        for (var iter: it.blocks) {
            curBlock = new ASMBlock(getLabel() + iter.lab);
            curFunc.addBlock(curBlock);
            iter.accept(this);
        }
    }
    @Override
    public void visit(AllocaInst it){}
    @Override
    public void visit(BasicInst it){}
    @Override
    public void visit(BinaryInst it){}
    @Override
    public void visit(BrInst it){}
    @Override
    public void visit(CallInst it){}
    @Override
    public void visit(GetelementInst it){}
    @Override
    public void visit(IcmpInst it){}
    @Override
    public void visit(LoadInst it){}
    @Override
    public void visit(PhiInst it){}
    @Override
    public void visit(RetInst it){}
    @Override
    public void visit(StoreInst it){}
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("\t.section data\n");
        for (var op: data) {
            ans.append(op);
        }
        ans.append("\t.section rodata\n");
        for (var op: rodata) {
            ans.append(op);
        }
        ans.append("\t.section text\n");
        for (var op: text) {
            ans.append(op);
        }
        return ans.toString();
    }

    private String getLabel() {return ".Lfunc" + funcNum + ".";}
}
