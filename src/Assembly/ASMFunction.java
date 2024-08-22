package Assembly;

import Assembly.Operand.Operand;

import java.util.ArrayList;

public class ASMFunction extends Operand {
    public String name;
    public ArrayList<ASMBlock> blocks;
    int paraSpace = 0, allocSpace = 0, totalSpace = 0;
    public ASMFunction(String name) {
        this.name = name;
        blocks = new ArrayList<>();
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
        ans.append('\n');
        return ans.toString();
    }
}
