package Assembly.Operand;

import MIR.irEntity.*;
import MIR.type.*;
public class varGlobal extends Operand{
    public String word;// value
    public int size = 0;// bytes(ptr/cInt/cBool)
    public String name;
    public varGlobal(String name, globalVar variable) {
        this.name = name;
        this.size = 4;
        if (variable.init != null) {
            if (variable.init instanceof constString) word = variable.init.getName().substring(1);
            else word = variable.init.getName();
        } else word = "0";
    }
    @Override
    public String toString() {
        return "\t.globl " + name + "\n" +
                name + ":\n" + "\t.word " + word + "\n" +
                "\t.size " + name + ", " + size + "\n" +
                "\n";
    }
}
