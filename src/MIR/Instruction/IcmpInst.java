package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;

import java.util.ArrayList;

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

    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!op1.isConstValue()) operands.add(op1);
        if (!op2.isConstValue()) operands.add(op2);
        return operands;
    }
    @Override
    public Entity getDef(){
        return result;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        if (old.equals(op1)) op1 = replace;
        else op2 = replace;
    }
    @Override
    public Entity getConst() {
        if (op1 instanceof constInt int1 && op2 instanceof constInt int2) {
            switch (op) {
                case ("eq") -> {return new constBool(int1.value == int2.value);}
                case ("ne") -> {return new constBool(int1.value != int2.value);}
                case ("sgt") -> {return new constBool(int1.value > int2.value);}
                case ("slt") -> {return new constBool(int1.value < int2.value);}
                case ("sge") -> {return new constBool(int1.value >= int2.value);}
                case ("sle") -> {return new constBool(int1.value <= int2.value);}
            }
        }
        return null;
    }

    @Override
    public void entity2const(Entity old, Entity val) {
        if (op1.equals(old)) op1 = val;
        if (op2.equals(old)) op2 = val;
    }
}
