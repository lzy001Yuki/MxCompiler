package Assembly;

import Assembly.Operand.Operand;
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
    }
    @Override
    public void visit(block it){}
    @Override
    public void visit(function it){}
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
        return ans.toString();
    }
}
