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
        switch (str) {
            case("+") : {
                op = "add";
                break;
            }
            case("-") :{
                op = "sub";
                break;
            }
            case("*") :{
                op = "mul";
                break;
            }
            case("/") :{
                op = "sdiv";
                break;
            }
            case("%") :{
                op = "srem";
                break;
            }
            case("<<") :{
                op = "shl";
                break;
            }
            case(">>") :{
                op = "ashr";
                break;
            }
            case("&") :{
                op = "and";
                break;
            }
            case("|") :{
                op = "or";
                break;
            }
            case("^") :{
                op = "xor";
                break;
            }
            default:throw new RuntimeException("invalid operation");
        }
    }
    @Override
    public String toString() {
        return result.getName() + " = " + op + " " + op1.type + " " + op1.getName() + " " + op2.getName();
    }
}
