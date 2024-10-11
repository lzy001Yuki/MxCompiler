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
    public HashMap<String, HashSet<String>> func2call = new HashMap<>();
    public DeadCodeElimination(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }
    public void run() {
        for (var func: globalScope.irFunction.entrySet()) {
            workOnFunc(func.getValue());
        }
        for (var func: globalScope.irFunction.entrySet()) {
            func.getValue().affineGlobal = getOtherGlobal(func.getValue());
        }
    }
    public void workOnFunc(function func) {
        HashMap<Entity, HashSet<Inst>> entity2use = new HashMap<>();
        HashMap<Entity, Inst> entity2def = new HashMap<>();
        LinkedList<Entity> defs = new LinkedList<>();
        func2call.put(func.irName, new HashSet<>());
        for (var blk: func.blocks) {
            for (var inst: blk.instructions) {
                if (inst.getDef() != null) {
                    entity2def.put(inst.getDef(), inst);
                    defs.add(inst.getDef());
                    if (inst.getDef() instanceof globalVar global) {
                        global.changed = true;
                        if (((ptrType)global.type).baseType.constType()) {
                            if (func.usedGlobal.containsKey(global)) func.usedGlobal.get(global).add(inst);
                            else {
                                func.usedGlobal.put(global, new ArrayList<>());
                                func.usedGlobal.get(global).add(inst);
                            }
                            func.defGlobal.add(global);
                        }
                    }
                }
                for (var use: inst.getUses()) {
                    if (!entity2use.containsKey(use)) entity2use.put(use, new HashSet<>());
                    entity2use.get(use).add(inst);
                    if (use instanceof globalVar global && ((ptrType)global.type).baseType.constType()) {
                        if (func.usedGlobal.containsKey(global)) func.usedGlobal.get(global).add(inst);
                        else {
                            func.usedGlobal.put(global, new ArrayList<>());
                            func.usedGlobal.get(global).add(inst);
                        }
                        inst.isDead = true;
                    }
                }
                if (inst instanceof CallInst call) func2call.get(func.irName).add(call.funcName);
            }
            for (var inst: blk.phiInsts) {
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
            blk.instructions.removeIf(inst -> inst.isDead);
            blk.phiInsts.removeIf(phiInst -> phiInst.isDead);
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

    public HashSet<globalVar> getOtherGlobal(function func) {
        HashSet<globalVar> allVar = new HashSet<>();
        ArrayList<function> allFunc = new ArrayList<>();
        HashSet<function> visited = new HashSet<>();
        for (var str: func2call.get(func.irName)) {
            function affine = globalScope.irFunction.get(str);
            if (affine != null) allFunc.add(affine);
        }
        while (!allFunc.isEmpty()) {
            var curFunc = allFunc.removeLast();
            if (visited.contains(curFunc)) continue;
            visited.add(curFunc);
            for (var glo: curFunc.usedGlobal.entrySet()) {
                allVar.add(glo.getKey());
            }
            func.defGlobal.addAll(curFunc.defGlobal);
        }
        for (var entry: func.usedGlobal.entrySet()) {
            allVar.add(entry.getKey());
        }
        return allVar;
    }
}
