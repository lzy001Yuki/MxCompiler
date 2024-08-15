package MIR.utils;

import MIR.Instruction.Inst;
import MIR.irEntity.function;

import java.util.ArrayList;

public class block {
    public label lab;
    public ArrayList<Inst> instructions;
    public function parentFunc;
    public block(String str, function parent) {
        lab = new label(str);
        parentFunc = parent;
        instructions = new ArrayList<>();
    }
}
