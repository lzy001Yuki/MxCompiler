package MIR.utils;

import MIR.IRVisitor;
import MIR.Instruction.Inst;
import MIR.irEntity.function;

import java.util.ArrayList;

public class block {
    public String lab;
    public ArrayList<Inst> instructions;
    public ArrayList<block> prev;
    public ArrayList<block> next;
    public function parentFunc;
    public block(String str, function parent) {
        lab = str;
        parentFunc = parent;
        instructions = new ArrayList<>();
        prev = new ArrayList<>();
        next = new ArrayList<>();
    }
    public block() {
        instructions = new ArrayList<>();
    }
    public void addInst(Inst in) {
        instructions.add(in);
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(lab).append(":\n");
        for (var inst: instructions) {
            ans.append("\t").append(inst).append("\n");
        }
        return ans.toString();
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
