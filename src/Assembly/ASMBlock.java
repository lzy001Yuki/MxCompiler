package Assembly;

import Assembly.Inst.ASMInst;
import Assembly.Operand.Operand;
import Assembly.Operand.Reg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class ASMBlock extends Operand {
    public String label;
    public LinkedList<ASMInst> inst;
    public ArrayList<ASMBlock> prev;
    public ArrayList<ASMBlock> next;

    // reg use & def in a block
    public HashSet<Reg> uses;
    public HashSet<Reg> defs;
    public HashSet<Reg> ins;
    public HashSet<Reg> outs;
    public ASMBlock(String name) {
        label = name;
        inst = new LinkedList<>();
        prev = new ArrayList<>();
        next = new ArrayList<>();
        uses = new HashSet<>();
        defs = new HashSet<>();
        ins = new HashSet<>();
        outs = new HashSet<>();
    }
    public void addInst(ASMInst i) {inst.add(i);}
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(label).append(":\n");
        for (var i: inst) {
            ans.append('\t').append(i);
        }
        return ans.toString();
    }
}
