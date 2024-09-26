package Assembly;

import Assembly.Inst.ASMInst;
import Assembly.Operand.Operand;

import java.util.ArrayList;
import java.util.LinkedList;

public class ASMFunction extends Operand {
    public String name;
    public ArrayList<ASMBlock> blocks;
    public int virtualNum = 0;
    public int allocSpace = 0;
    public int spilledSpace = 0;
    public ASMFunction(String name) {
        this.name = name;
        blocks = new ArrayList<>();
    }
    public void addBlock(ASMBlock it) {blocks.add(it);}
    public void addLast(ASMInst it) {
        blocks.getLast().inst.add(blocks.getLast().inst.size() - 1, it);
    }
    public void addFirst(ASMInst it) {
        blocks.getFirst().inst.addFirst(it);
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("\t.globl ").append(name).append("\n");
        ans.append("\t.type ").append(name).append(", @function\n");
        ans.append(name).append(":\n");
        for (var block: blocks) {
            ans.append(block);
        }
        ans.append("\n\n");
        return ans.toString();
    }
}
