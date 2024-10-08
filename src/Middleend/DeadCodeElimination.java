package Middleend;

import MIR.Instruction.CallInst;
import MIR.Instruction.Inst;
import MIR.Instruction.MoveInst;
import MIR.Instruction.StoreInst;
import MIR.irEntity.Entity;
import MIR.irEntity.Ptr;
import MIR.irEntity.function;
import MIR.irEntity.globalVar;
import MIR.type.IRType;
import MIR.type.classType;
import MIR.type.ptrType;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
        HashMap<Entity, HashSet<Inst>> entity2use = new HashMap<>();
        HashMap<Entity, Inst> entity2def = new HashMap<>();
        LinkedList<Entity> defs = new LinkedList<>();
        for (var blk: func.blocks) {
            for (var inst: blk.instructions) {
                if (inst.getDef() != null) {
                    entity2def.put(inst.getDef(), inst);
                    defs.add(inst.getDef());
                }
                for (var use: inst.getUses()) {
                    if (!entity2use.containsKey(use)) entity2use.put(use, new HashSet<>());
                    entity2use.get(use).add(inst);
                }
            }
        }
        while (!defs.isEmpty()) {
            Entity def = defs.removeFirst();
            if (entity2use.containsKey(def) && !entity2use.get(def).isEmpty()) continue;
            Inst defInst = entity2def.get(def);
            if (noDel(defInst)) continue;
            if (func.irName.equals("update")) continue;
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
        func.entity2use = entity2use;
    }

    public boolean noDel(Inst defInst) {
        if (defInst instanceof CallInst || defInst == null || defInst instanceof MoveInst) return true;
        if (defInst instanceof StoreInst store) {
            if (store.pointer instanceof globalVar || ((Ptr)store.pointer).isElement) return true;
            else return false;
        }
        return false;
    }

    public boolean isClassPtr(ptrType ptr) {
        IRType curPtr = ptr.baseType;
        while (curPtr instanceof ptrType) {
            curPtr = ((ptrType) curPtr).baseType;
        }
        return (curPtr instanceof classType);
    }

    public boolean isArrayPtr(String name) {
        if (name == null) return false;
        if (name.contains("array_ptr")) return true;
        else if (name.contains("malloc_ptr")) return true;
        else return false;
    }
}
