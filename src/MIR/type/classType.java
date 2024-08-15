package MIR.type;

public class classType extends IRType{
    public classType(String str) {
        super(str); //%class.A
    }
    @Override
    public String toString() {
        return "%class." + this.typeName;
    }
}
