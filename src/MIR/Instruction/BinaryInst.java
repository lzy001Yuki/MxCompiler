package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.type.ptrType;

import java.util.ArrayList;

public class BinaryInst extends Inst{
    public localVar result;
    public String op;
    public Entity op1, op2;
    public BinaryInst(localVar v, String str, Entity op1, Entity op2) {
        if (op1.type instanceof ptrType) throw new RuntimeException("error in binaryinst type");
        result = v;
        this.op1 = op1;
        this.op2 = op2;
        op = advertOp(str);
    }
    @Override
    public String toString() {
        return result.getName() + " = " + op + " " + op1.type + " " + op1.getName() + ", " + op2.getName();
    }
    public static String advertOp(String str) {
        switch (str) {
            case("+") : return "add";
            case("-") : return "sub";
            case("*") : return "mul";
            case("/") : return "sdiv";
            case("%") : return "srem";
            case("<<") : return "shl";
            case(">>") : return "ashr";
            case("&") : return "and";
            case("|") : return "or";
            case("^") : return "xor";
            default:throw new RuntimeException("invalid operation");
        }
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!op1.isConstValue()) operands.add(op1);
        if(!op2.isConstValue()) operands.add(op2);
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
}
