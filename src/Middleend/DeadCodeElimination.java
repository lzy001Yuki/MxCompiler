package Middleend;

import MIR.Instruction.CallInst;
import MIR.Instruction.Inst;
import MIR.Instruction.StoreInst;
import MIR.irEntity.Entity;
import MIR.irEntity.function;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class DeadCodeElimination {
    public GlobalScope globalScope;
    public DeadCodeElimination(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }
    public void run() {
        for (var func: globalScope.irFunction.entrySet()) {
            workOnFunc(func.getValue());
        }
    }
    public void workOnFunc(function func) {
        HashMap<Entity, ArrayList<Inst>> entity2use = new HashMap<>();
        HashMap<Entity, Inst> entity2def = new HashMap<>();
        LinkedList<Entity> defs = new LinkedList<>();
        for (var blk: func.blocks) {
            for (var inst: blk.instructions) {
                if (inst.getDef() != null) {
                    entity2def.put(inst.getDef(), inst);
                    defs.add(inst.getDef());
                }
                for (var use: inst.getUses()) {
                    if (!entity2use.containsKey(use)) entity2use.put(use, new ArrayList<>());
                    entity2use.get(use).add(inst);
                }
            }
        }
        while (!defs.isEmpty()) {
            Entity def = defs.removeFirst();
            if (entity2use.containsKey(def) && !entity2use.get(def).isEmpty()) continue;
            Inst defInst = entity2def.get(def);
            if (defInst instanceof CallInst || (defInst instanceof StoreInst && ((StoreInst) defInst).pointer.irName.contains("array_ptr")) || defInst == null) continue;
            defInst.isDead = true;
            for (var use: defInst.getUses()) {
                entity2use.get(use).remove(defInst);
                if (!defs.contains(use)) defs.add(use);
            }
        }

        for (var blk: func.blocks) {
            var iter = blk.instructions.iterator();
            while (iter.hasNext()) {
                if (iter.next().isDead) iter.remove();
            }
        }
    }
}
