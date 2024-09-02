package Assembly;

import Assembly.Inst.ASMInst;
import Assembly.Operand.Operand;

import java.util.ArrayList;
import java.util.LinkedList;

public class ASMBlock extends Operand {
    public String label;
    public LinkedList<ASMInst> inst;
    public ArrayList<ASMBlock> prev;
    public ArrayList<ASMBlock> next;
    public ASMBlock(String name) {
        label = name;
        inst = new LinkedList<>();
        prev = new ArrayList<>();
        next = new ArrayList<>();
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
