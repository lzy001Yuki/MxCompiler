package MIR.Instruction;

import MIR.irEntity.*;
import MIR.type.ptrType;

import java.util.ArrayList;

public class GetelementInst extends Inst{
    public localPtr result;
    public Ptr ptrVal;
    public ArrayList<Entity> index;
    public GetelementInst(localPtr res, Ptr ptr) {
        result = res;
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
}
