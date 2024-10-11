package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.type.ptrType;
import MIR.utils.block;

import java.util.ArrayList;

public class BinaryInst extends Inst{
    public Entity result;
    public String op;
    public Entity op1, op2;
    public BinaryInst(Entity v, String str, Entity op1, Entity op2) {
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
        if (old.equals(op2)) op2 = replace;
        if (old.equals(result)) result = replace;
    }
    @Override
    public Entity getConst() {
        if (op1 instanceof constInt int1 && op2 instanceof constInt int2) {
            switch (op) {
                case ("add") -> {return new constInt(int1.value + int2.value);}
                case ("sub") -> {return new constInt(int1.value - int2.value);}
                case ("mul") -> {return new constInt(int1.value * int2.value);}
                case ("sdiv") -> {
                    if (int2.value == 0) return null;
                    else return new constInt(int1.value / int2.value);
                }
                case ("srem") -> {
                    if (int2.value == 0) return null;
                    else return new constInt(int1.value % int2.value);
                }
                case ("shl") -> {return new constInt(int1.value << int2.value);}
                case ("ashr") -> {return new constInt(int1.value >> int2.value);}
                case ("and") -> {return new constInt(int1.value & int2.value);}
                case ("or") -> {return new constInt(int1.value | int2.value);}
                case ("xor") -> {return new constInt(int1.value ^ int2.value);}
            }
        }
        if (op1 instanceof constBool bool1 && op2 instanceof constBool bool2) {
            if (op.equals("xor")) return new constBool(bool1.value ^ bool2.value);
        }
        return null;
    }
    @Override
    public void entity2const(Entity old, Entity val) {
        if (old.equals(op1)) op1 = val;
        if (old.equals(op2)) op2 = val;
        if (old.equals(result)) result = val;
    }
}
