package MIR.irEntity;

import MIR.type.IRType;
import MIR.type.classType;

import java.util.ArrayList;

public class globalClass extends Entity{
    public ArrayList<IRType> members;
    public globalClass(String name) {
        super(new classType(name), name);
        members = new ArrayList<>();
    }
    public String print() {
        StringBuilder ans = new StringBuilder();
        ans.append(this.type);
        ans.append(" = type {");
        for (int i = 0; i < members.size(); i++) {
            ans.append(members.get(i));
            if (i != members.size() - 1) ans.append(", ");
        }
        ans.append("}");
        return ans.toString();
    }
}
