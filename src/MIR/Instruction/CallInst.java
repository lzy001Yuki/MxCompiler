package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.irEntity.function;
import MIR.irEntity.localVar;
import MIR.type.voidType;
import com.sun.jdi.VoidType;

import java.util.ArrayList;

public class CallInst extends Inst{
    public String funcName; //无@
    public Entity ret;
    public ArrayList<Entity> para;
    public CallInst(function func, String name) {
        para = new ArrayList<>();
        if (!func.paraList.isEmpty()) {
            para.addAll(func.paraList);
        }
        funcName = func.irName;
        ret = new localVar(func.type, name);
    }
    public CallInst(String funcName) {
        this.funcName = funcName;
        para = new ArrayList<>();
    }
    @Override
    public Inst getCopy() {
        CallInst call = new CallInst(funcName);
        call.ret = ret;
        call.para.addAll(para);
        return call;
    }
    public CallInst(function func, Entity vari) {
        para = new ArrayList<>();
        if (!func.paraList.isEmpty()) {
            para.addAll(func.paraList);
        }
        funcName = func.irName;
        ret = vari;
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        if (ret.type instanceof voidType) ans.append("call void");
        else ans.append(ret.getName()).append(" = call ").append(ret.type);
        ans.append(" @").append(funcName).append("(");
        for (int i = 0; i < para.size(); i++) {
            ans.append(para.get(i).type).append(" ").append(para.get(i).getName());
            if (i != para.size() - 1) ans.append(", ");
        }
        ans.append(")");
        return ans.toString();
    }
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
    @Override
    public ArrayList<Entity> getUses(){
        ArrayList<Entity> operands = new ArrayList<>();
        for(var it: para) {
            if (!it.isConstValue()) operands.add(it);
        }
        return operands;
    }
    @Override
    public Entity getDef(){
        return ret;
    }
    @Override
    public void replaceOperand(Entity old, Entity replace) {
        for (int i = 0; i < para.size(); i++) {
            if (para.get(i).equals(old)) para.set(i, replace);
        }
        if (old.equals(ret)) ret = replace;
    }
    @Override
    public Entity getConst() {return null;}

    @Override
    public void entity2const(Entity old, Entity val) {
        for (int i = 0; i < para.size(); i++) {
            if (para.get(i).equals(old)) para.set(i, val);
        }
    }
}
