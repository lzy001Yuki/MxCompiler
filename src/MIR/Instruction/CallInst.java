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
        String ans = "";
        if (ret.type instanceof VoidType) ans += "call void ";
        else ans += (ret.getName() + " = call " + ret.type + " ");
        ans += ("@" + funcName + "(");
        for (int i = 0; i < para.size(); i++) {
            ans += (para.get(i).type + " " + para.get(i).getName());
            if (i != para.size() - 1) ans += ",";
        }
        ans += ")";
        return ans;
    }
}
