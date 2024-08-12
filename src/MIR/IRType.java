package MIR;

public class IRType {
    public int bit_width = 0;
    public String typeName = null;
    public IRType(String str) {
        if (str.equals("void")) typeName = "void";
        else if (str.equals("ptr")) typeName = "ptr";
        else if (str.charAt(0) == 'i') {
            typeName = "int";
            bit_width = Integer.parseInt(str.substring(1));
        } else throw new RuntimeException("type for ir is wrong");
    }

    @Override
    public String toString(){
        if (typeName.equals("void") || typeName.equals("ptr")) return typeName;
        else return "i" + String.valueOf(bit_width);
    }
}
