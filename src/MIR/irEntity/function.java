package MIR.irEntity;

import MIR.type.IRType;
import MIR.utils.block;
import java.util.ArrayList;

public class function extends Entity{
    public boolean isMember;
    public ArrayList<Entity> paraList;
    public ArrayList<block> blocks;
    public function(String funcName, IRType ret, boolean flag) {
        super(ret, funcName);
        this.isMember = flag;
        paraList = new ArrayList<>();
        if (flag) paraList.add(new localPtr("this"));
        blocks = new ArrayList<>();
    }
    public void addBlock(block blk) {blocks.add(blk);}
    public void addPara(Entity en) {paraList.add(en);}
    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        ans.append("define ").append(type).append(" @").append(irName).append("(");
        for (int i = 0; i < paraList.size(); i++) {
            ans.append(paraList.get(i).type).append(" ").append(paraList.get(i).getName());
            if (i != paraList.size() - 1) ans.append(", ");
        }
        ans.append(") {\n");
        for (int i = 0; i < blocks.size(); i++) {
            ans.append(blocks.get(i));
        }
        ans.append("}\n");
        return ans.toString();
    }
    public String declare() {
        StringBuilder ans = new StringBuilder();
        ans.append("declare ").append(type).append(" @").append(irName).append("(");
        for (int i = 0; i < paraList.size(); i++) {
            ans.append(paraList.get(i).type).append(" ").append(paraList.get(i).getName());
            if (i != paraList.size() - 1) ans.append(", ");
        }
        ans.append(")\n");
        return ans.toString();
    }
}
