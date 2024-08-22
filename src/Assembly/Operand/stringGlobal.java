package Assembly.Operand;

public class stringGlobal extends Operand{
    public String name;
    public String value;
    public stringGlobal(String name, String val) {
        this.name = name;
        this.value = val;
    }
    @Override
    public String toString() {
        return "\t.globl " + name + "\n" +
                name + ":\n\t.asciz \"" + value + "\"\n" +
                "\t.size " + name + " " + value.length() + "\n\n";
    }
}
