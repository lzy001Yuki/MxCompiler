package MIR.Instruction;

import MIR.irEntity.Entity;
import MIR.irEntity.localVar;
import com.sun.jdi.VoidType;

import java.util.ArrayList;

public class CallInst extends Inst{
    public String funcName; //无@
    public localVar ret;
    public ArrayList<Entity> para;
    public CallInst(String name, localVar r) {
        para = new ArrayList<>();
        funcName = name;
        ret = r;
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        if (ret.type instanceof VoidType) ans.append("call void");
        else ans.append(ret.getName()).append(" = call ").append(ret.type);
        ans.append(" @").append(funcName).append("(");
        for (int i = 0; i < para.size(); i++) {
            ans.append(para.get(i).type).append(" ").append(para.get(i).getName());
            if (i != para.size() - 1) ans.append(",");
        }
        ans.append(")");
        return ans.toString();
    }
}
