package MIR.utils;

import MIR.IRVisitor;
import MIR.Instruction.Inst;
import MIR.Instruction.PhiInst;
import MIR.irEntity.function;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class block {
    public String lab;
    public ArrayList<Inst> instructions;
    public LinkedList<PhiInst> phiInsts;
    public ArrayList<block> prev;
    public ArrayList<block> next;
    public function parentFunc;
    public block iDom = null;
    public HashSet<block> df;
    public HashSet<block> dc;
    public boolean isDead = false;
    public boolean needPhi = false;
    public boolean hasInline = false;
    public block(String str, function parent) {
        lab = str;
        parentFunc = parent;
        instructions = new ArrayList<>();
        prev = new ArrayList<>();
        next = new ArrayList<>();
        phiInsts = new LinkedList<>();
        df = new HashSet<>();
        dc = new HashSet<>();
    }
    public block() {
        instructions = new ArrayList<>();
    }
    public void addInst(Inst in) {
        instructions.add(in);
        in.belongedBlock = this;
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(lab).append(":\n");
        for (var phi: phiInsts) {
            ans.append("\t").append(phi).append("\n");
        }
        for (var inst: instructions) {
            if (inst instanceof PhiInst) continue;
            ans.append("\t").append(inst).append("\n");
        }
        return ans.toString();
    }
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
