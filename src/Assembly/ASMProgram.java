package Assembly;

import Assembly.Operand.Operand;

import java.util.ArrayList;

public class ASMProgram {
    public ArrayList<Operand> data;
    public ArrayList<ASMFunction> text;
    public ArrayList<Operand> rodata;

    public ASMProgram() {
        data = new ArrayList<>();
        text = new ArrayList<>();
        rodata = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("\t.data\n");
        for (var op : data) {
            ans.append(op);
        }
        ans.append("\t.rodata\n");
        for (var op : rodata) {
            ans.append(op);
        }
        ans.append("\t.text\n");
        for (var op : text) {
            ans.append(op);
        }
        return ans.toString();
    }
}