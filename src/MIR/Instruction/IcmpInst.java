package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;

public class IcmpInst extends Inst{
    public localVar result;
    public String op;
    public Entity op1, op2;
    public IcmpInst(localVar v, String str, Entity op1, Entity op2) {
        this.op1 = op1;
        this.op2 = op2;
        result = v;
        op = advertCmp(str);
    }

    @Override
    public String toString() {
        return result.getName() +" = icmp " + op + " " + op1.type + " " + op1.getName() + " ," + op2.getName();
    }
    static public String advertCmp(String str) {
        String op;
        switch (str) {
            case("==") :{
                op = "eq";
                break;
            }
            case("!=") :{
                op = "ne";
                break;
            }
            case(">") :{
                op = "sgt";
                break;
            }
            case(">=") :{
                op = "sge";
                break;
            }
            case("<") :{
                op = "slt";
                break;
            }
            case("<=") :{
                op = "sle";
                break;
            }
            default: throw new RuntimeException("invalid operation");
        }
        return op;
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
