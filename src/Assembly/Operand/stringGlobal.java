package Assembly.Operand;

public class stringGlobal extends Operand{
    public String name;
    public String value;
    public stringGlobal(String name, String val) {
        this.name = name;
        this.value = val.substring(0, val.length() - 1).replace("\\", "\\\\")
                .replace("\n", "\\n")
                .replace("\0", "")
                .replace("\t", "\\t")
                .replace("\"", "\\\"");
    }
    @Override
    public String toString() {
        return "\t.align 2\n" + "\t.globl " + name + "\n" +
                name + ":\n\t.asciz \"" + value + "\"\n" +
                "\t.size " + name + " " + (value.length() + 1)  + "\n\n";
    }
}
