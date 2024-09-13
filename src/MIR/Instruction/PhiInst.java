package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.*;
import utils.Pair;

import javax.swing.event.MenuListener;
import java.util.ArrayList;

public class PhiInst extends Inst{
    public Entity result;
    public ArrayList<Pair<Entity, String>> jump;
    public PhiInst(Entity en) {
        result = en;
        jump = new ArrayList<>();
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append(result.getName()).append(" = phi ").append(result.type).append(" ");
        for (int i = 0; i < jump.size(); i++) {
            ans.append("[ ").append(jump.get(i).getFirst().getName()).append(", %").append(jump.get(i).getSecond()).append(" ]");
            if (i != jump.size() - 1) ans.append(", ");
        }
        return ans.toString();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        for (var it: jump) {
            if (!it.getFirst().isConstValue()) operands.add(it.getFirst());
        }
        return operands;
    }
    @Override
    public Entity getDef(){
        return result;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        for (int i = 0; i < jump.size(); i++) {
            if (jump.get(i).getFirst().equals(old)) jump.set(i, new Pair<>(replace, jump.get(i).getSecond()));
        }
    }
}
