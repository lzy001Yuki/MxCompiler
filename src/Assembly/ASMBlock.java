package Assembly;

import Assembly.Inst.ASMInst;
import Assembly.Operand.Operand;
import Assembly.Operand.Reg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class ASMBlock extends Operand {
    public String label;
    public int PC = 0;
    public ASMFunction belonged = null;
    public LinkedList<ASMInst> inst;
    public ArrayList<ASMBlock> prev;
    public ArrayList<ASMBlock> next;

    // reg use & def in a block
    public HashSet<Reg> uses;
    public HashSet<Reg> defs;
    public HashSet<Reg> ins;
    public HashSet<Reg> outs;
    public ASMBlock(String name, ASMFunction belonged) {
        label = name;
        this.belonged = belonged;
        inst = new LinkedList<>();
        prev = new ArrayList<>();
        next = new ArrayList<>();
        uses = new HashSet<>();
        defs = new HashSet<>();
        ins = new HashSet<>();
        outs = new HashSet<>();
    }
    public void addInst(ASMInst i) {
        inst.add(i);
        i.PC = belonged.curPC;
        belonged.curPC += 4;
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(label).append(": #").append(PC).append("\n");
        for (var i: inst) {
            ans.append('\t').append(i);
        }
        return ans.toString();
    }
}
