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
        blocks = new ArrayList<>();
    }
}
