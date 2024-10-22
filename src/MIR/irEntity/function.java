package MIR.irEntity;

import MIR.IRVisitor;
import MIR.Instruction.CallInst;
import MIR.Instruction.InlineInst;
import MIR.Instruction.Inst;
import MIR.type.IRType;
import MIR.type.classType;
import MIR.utils.block;
import utils.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class function extends Entity{
    public boolean isMember;
    public ArrayList<Entity> paraList;
    public ArrayList<block> blocks;
    public HashMap<String, block> blockMap;
    public String className;
    public HashMap<globalVar, ArrayList<Inst>> usedGlobal = new HashMap<>(); // only const value allowed
    public HashSet<globalVar> defGlobal = new HashSet<>();
    public HashSet<globalVar> affineGlobal = new HashSet<>();
    public ArrayList<block> retBlks = new ArrayList<>();
    public HashMap<function, ArrayList<block>> inFunc = new HashMap<>();
    public HashMap<CallInst, InlineInst> insertInline = new HashMap<>();

    public HashMap<Entity, HashSet<Inst>> entity2use = new HashMap<>();
    public function(String funcName, IRType ret, boolean flag, String clsName) {
        super(ret, funcName);
        this.isMember = flag;
        paraList = new ArrayList<>();
        if (flag) paraList.add(new localPtr(new classType(clsName), "this"));
        blocks = new ArrayList<>();
        this.className = clsName;
        blockMap = new HashMap<>();
    }
    public void addBlock(block blk) {
        blocks.add(blk);
        blockMap.put(blk.lab, blk);
    }
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
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
