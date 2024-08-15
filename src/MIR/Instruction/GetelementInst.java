package MIR.Instruction;

import MIR.irEntity.*;

import java.util.ArrayList;

public class GetelementInst extends Inst{
    public localPtr result;
    public localPtr ptrVal;
    public ArrayList<Entity> index;
    public GetelementInst(localPtr res, localPtr ptr) {
        result = res;
        ptrVal = ptr;
        index = new ArrayList<>();
    }
    public void addIndex(Entity obj) {
        if (!obj.type.typeName.equals("i32")) throw new RuntimeException("index type is wrong");
        index.add(obj);
    }
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        String str = result.getName() + " = getelementptr " + ptrVal.type + ", ptr " + ptrVal.getName() + " ";
        ans.append(str);
        for (int i = 0; i < index.size(); i++) {
            ans.append(", ").append(index.get(i).type).append(" ").append(index.get(i).getName());
        }
        return ans.toString();
    }
}
