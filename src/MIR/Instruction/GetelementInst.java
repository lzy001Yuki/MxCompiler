package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import MIR.type.ptrType;

import java.util.ArrayList;

public class GetelementInst extends Inst{
    public localPtr result;
    public Entity ptrVal;
    public ArrayList<Entity> index;
    public GetelementInst(localPtr res, Entity ptr) {
        result = res;
        result.isElement = true;
        ptrVal = ptr;
        index = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        String str = result.getName() + " = getelementptr " + ((ptrType)(ptrVal.type)).baseType + ", ptr " + ptrVal.getName() + " ";
        ans.append(str);
        for (int i = 0; i < index.size(); i++) {
            ans.append(", ").append(index.get(i).type).append(" ").append(index.get(i).getName());
        }
        return ans.toString();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        if (!ptrVal.isConstValue()) operands.add(ptrVal);
        for (var idx: index) {
            if (!idx.isConstValue()) operands.add(idx);
        }
        return operands;
    }
    @Override
    public Entity getDef(){
        return result;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        if (old.equals(ptrVal)) ptrVal = replace;
        for (int i = 0; i < index.size(); i++) {
            if (index.get(i).equals(old)) index.set(i, replace);
        }
    }
}
