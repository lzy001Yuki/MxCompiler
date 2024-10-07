package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.type.IRType;
import MIR.type.voidType;

import java.util.ArrayList;

public class RetInst extends Inst{
    public Entity retType;
    public RetInst(Entity obj) {
        retType = obj;
    }
    public RetInst(IRType type, String name) {
        retType = new Entity(type, name);
    }
    @Override
    public String toString() {
        if (retType.type instanceof voidType) return "ret void";
        else return "ret " + retType.type + " " + retType.getName();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!retType.isConstValue() && !(retType.type instanceof voidType)) operands.add(retType);
        return operands;
    }
    @Override
    public Entity getDef(){
        return null;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        retType = replace;
    }
    @Override
    public Entity getConst() {return null;}
    @Override
    public void entity2const(Entity old, Entity val) {
        if (retType.equals(old)) retType = val;
    }
}
