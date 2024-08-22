package Assembly.Operand;

public class PhysicReg extends Reg{
    public String name;
    public PhysicReg(String str) {
        this.name = str;
    }
    @Override
    public String toString() {
        return name;
    }
}
