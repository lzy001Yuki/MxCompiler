package MIR.Instruction;

import MIR.irEntity.*;

public class BinaryInst extends Inst{
    public localVar result;
    public String op;
    public Entity op1, op2;
    public BinaryInst(localVar v, String str, Entity op1, Entity op2) {
        result = v;
        this.op1 = op1;
        this.op2 = op2;
        op = advertOp(str);
    }
    @Override
    public String toString() {
        return result.getName() + " = " + op + " " + op1.type + " " + op1.getName() + " " + op2.getName();
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
}