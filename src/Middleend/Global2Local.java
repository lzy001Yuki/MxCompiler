package Middleend;

import MIR.IRBuilder;
import MIR.Instruction.*;
import MIR.irEntity.*;
import MIR.utils.block;
import utils.Scope.GlobalScope;

import java.util.*;

public class Global2Local {
    public IRBuilder irBuilder;
    public GlobalScope globalScope;
    public Global2Local(IRBuilder irBuilder) {
        this.irBuilder = irBuilder;
        globalScope = irBuilder.globalScope;
    }

    public void run() {
        //最后做
        //
        for (var entry: globalScope.irFunction.entrySet()) {
            // for small size blocks
            //if (entry.getValue().blocks.size() < 2000) runOnFunc(entry.getValue());
            //else
                OrunOnFunc(entry.getValue());
        }
        globalScope.globalInst.entrySet().removeIf(entry -> entry.getKey() instanceof globalVar global && !global.changed);
    }

    public void runOnFunc(function func) {
        block entryBlk = func.blocks.getFirst();
        HashMap<Entity, Entity> loc2glo = new HashMap<>();
        HashMap<Entity, Entity> glo2replace = new HashMap<>();
        HashMap<Entity, Entity> rep2global = new HashMap<>();
        for (var entry: func.usedGlobal.entrySet()) {
            globalVar global = entry.getKey();
            if (global.changed) {
                Entity replace = irBuilder.loadPtr(entry.getKey());
                glo2replace.put(global, replace);
                rep2global.put(replace, global);
                //entryBlk.instructions.addFirst(new LoadInst(replace, global));
                for (var in : entry.getValue()) {
                    if (in instanceof LoadInst load && !loc2glo.containsKey(load.result)) loc2glo.put(load.result, replace);
                    //if (in instanceof StoreInst store && !loc2glo.containsKey(store.value) && store.value.isConstValue()) loc2glo.put(store.value, replace);
                }
            } else {
                Entity replace = null;
                if (global.init != null) replace = global.init;
                else replace = new constInt(0);
                glo2replace.put(global, replace);
                rep2global.put(replace, global);
                for (var in: entry.getValue()) {
                    if (in instanceof LoadInst load) loc2glo.put(load.result, replace);
                }
            }
        }
        HashSet<Entity> gloUsedBefore = new HashSet<>();
        HashSet<Entity> gloDefBefore = new HashSet<>();
        // dfs on CFG
        // load before first used
        // if changed before funcCall, store it
        // analyze global used in funcCall
        // after funcCall, if use global in previous funcCalls, load it
        HashSet<block> visited = new HashSet<>();
        HashSet<Entity> gloFuncBefore = new HashSet<>();
        analyzeGlobal(func.blocks.getFirst(), gloUsedBefore, gloDefBefore, loc2glo, glo2replace, rep2global, func, visited, gloFuncBefore);
        collectGloDef(func, rep2global);
        /*
        for (var blk: func.blocks) {
            ArrayList<Inst> newInsts = new ArrayList<>();
            for (var inst: blk.instructions) {
                newInsts.add(inst);
                if (inst instanceof CallInst call) {
                    function next = globalScope.irFunction.get(call.funcName);
                    if (next != null) {
                        for (var exa: func.usedGlobal.entrySet()) {
                            if (next.affineGlobal.contains(exa.getKey())) {
                                Entity getReplace = glo2replace.get(exa.getKey());
                                if (gloUsedBefore.contains(getReplace)) {
                                    newInsts.add(newInsts.size() - 1, new StoreInst(getReplace, exa.getKey()));
                                    gloUsedBefore.remove(getReplace);
                                }
                                //newInsts.add(new LoadInst(glo2replace.get(exa.getKey()), exa.getKey()));
                            }
                        }
                        for (var exa: func.usedGlobal.entrySet()) {
                            if (next.affineGlobal.contains(exa.getKey()) && next.defGlobal.contains(exa.getKey())) {
                                //newInsts.add(newInsts.size() - 1, new StoreInst(glo2replace.get(exa.getKey()), exa.getKey()));
                                //newInsts.add(new LoadInst(glo2replace.get(exa.getKey()), exa.getKey()));
                            }
                        }
                    }
                }
                if (inst instanceof StoreInst store && store.pointer instanceof globalVar) {
                    if (glo2replace.containsKey(store.pointer)) {
                        newInsts.removeLast();
                        MoveInst move;
                        if (store.value.isConstValue() || !loc2glo.containsKey(store.value))
                            move = new MoveInst(glo2replace.get(store.pointer), store.value);
                        else move = new MoveInst(glo2replace.get(store.pointer), loc2glo.get(store.value));
                        if (!move.dest.equals(move.src)) {
                            newInsts.add(move);
                            gloUsedBefore.add(glo2replace.get(store.pointer));
                        }
                    }
                }
                Entity replace = loc2glo.get(inst.getDef());
                if (replace != null) inst.replaceOperand(inst.getDef(), replace);
                if (! (inst instanceof LoadInst) && rep2global.get(inst.getDef()) != null) gloUsedBefore.add(replace);
                for (var use: inst.getUses()) {
                    replace = loc2glo.get(use);
                    if (replace != null) {
                        inst.replaceOperand(use, replace);
                        if (!gloUsedBefore.contains(replace)) {
                            newInsts.add(newInsts.size() - 1, new LoadInst(replace, rep2global.get(replace)));
                            gloUsedBefore.add(replace);
                        }
                    }
                }
            }
            blk.instructions = newInsts;
        }
        for (var entry: func.usedGlobal.entrySet()) {
            globalVar global = entry.getKey();
            if (global.changed) {
                for (var rets: func.retBlks) {
                    rets.instructions.add(rets.instructions.size() - 1, new StoreInst(glo2replace.get(global), global));
                }
            }
        }*/

    }

    public void analyzeGlobal(block blk,
                              HashSet<Entity> gloUsedBefore,
                              HashSet<Entity> gloDefBefore,
                              HashMap<Entity, Entity> loc2glo,
                              HashMap<Entity, Entity> glo2replace,
                              HashMap<Entity, Entity> rep2global,
                              function curFunc,
                              HashSet<block> visited,
                              HashSet<Entity> gloFuncBefore) {
        if (visited.contains(blk)) return;
        else visited.add(blk);
        ArrayList<Inst> newInsts = new ArrayList<>();
        HashSet<Entity> gloUsedCur = new HashSet<>(gloUsedBefore);
        HashSet<Entity> gloDefCur = new HashSet<>(gloDefBefore);
        for (var inst: blk.instructions) {
            Entity replace = loc2glo.get(inst.getDef());
            if (replace != null) inst.replaceOperand(inst.getDef(), replace);
            for (var use : inst.getUses()) {
                replace = loc2glo.get(use);
                if (replace != null) {
                    inst.replaceOperand(use, replace);
                    if (!replace.isConstValue() && (!gloUsedCur.contains(replace) || gloFuncBefore.contains(replace))) {
                        newInsts.add(new LoadInst(replace, rep2global.get(replace)));
                        gloUsedCur.add(replace);
                        gloFuncBefore.remove(replace);
                    }
                }
            }
            if (inst instanceof CallInst call) {
                function next = globalScope.irFunction.get(call.funcName);
                if (next != null) {
                    for (var exa: curFunc.usedGlobal.entrySet()) {
                        if (next.affineGlobal.contains(exa.getKey())) {
                            Entity getReplace = glo2replace.get(exa.getKey());
                            if (gloDefCur.contains(getReplace)) {
                                newInsts.add(new StoreInst(getReplace, exa.getKey()));
                            }
                        }
                    }
                    newInsts.add(call);
                    for (var exa: curFunc.usedGlobal.entrySet()) {
                        if (next.affineGlobal.contains(exa.getKey()) && next.defGlobal.contains(exa.getKey())) {
                            if (gloUsedCur.contains(glo2replace.get(exa.getKey()))) {
                                gloDefCur.add(glo2replace.get(exa.getKey()));
                                gloFuncBefore.add(glo2replace.get(exa.getKey()));
                            }
                        }
                    }
                }else newInsts.add(call);
            } else if (inst instanceof StoreInst store && store.pointer instanceof globalVar) {
                if (glo2replace.containsKey(store.pointer)) {
                    MoveInst move;
                    if (store.value.isConstValue() || !loc2glo.containsKey(store.value))
                        move = new MoveInst(glo2replace.get(store.pointer), store.value);
                    else move = new MoveInst(glo2replace.get(store.pointer), loc2glo.get(store.value));
                    if (!move.dest.equals(move.src)) {
                        newInsts.add(move);
                        gloUsedCur.add(glo2replace.get(store.pointer));
                        gloDefCur.add(glo2replace.get(store.pointer));
                        blk.gloDefCur.add(glo2replace.get(store.pointer));
                    }
                }
            } else newInsts.add(inst);
            }

        blk.instructions = newInsts;
//        if (curFunc.retBlks.contains(blk)) {
//            for (var global: gloDefBefore) {
//                if (!gloFuncBefore.contains(global))
//                    newInsts.add(newInsts.size() - 1, new StoreInst(global, rep2global.get(global)));
//            }
//            return;
//        }

        for (var nxt: blk.next) {
            analyzeGlobal(nxt, gloUsedCur, gloDefCur, loc2glo, glo2replace, rep2global, curFunc, visited, gloFuncBefore);
        }
    }

    public void collectGloDef(function func, HashMap<Entity, Entity> rep2global) {
        for (var retBlk: func.retBlks) {
            HashSet<block> visited = new HashSet<>();
            HashSet<Entity> defGlobal = new HashSet<>();
            LinkedList<block> que = new LinkedList<>();
            que.add(retBlk);
            while (!que.isEmpty()) {
                block cur = que.pop();
                if (!visited.contains(cur)) visited.add(cur);
                else continue;
                defGlobal.addAll(cur.gloDefCur);
                que.addAll(cur.prev);
            }
            for (var def: defGlobal) {
                retBlk.instructions.add(retBlk.instructions.size() - 1, new StoreInst(def, rep2global.get(def)));
            }
        }
    }

    public void OrunOnFunc(function func) {
        block entryBlk = func.blocks.getFirst();
        HashMap<Entity, Entity> loc2glo = new HashMap<>();
        HashMap<Entity, Entity> glo2replace = new HashMap<>();
        HashSet<Entity> allReplace = new HashSet<>();
        for (var entry: func.usedGlobal.entrySet()) {
            globalVar global = entry.getKey();
            if (global.changed) {
                Entity replace = irBuilder.loadPtr(entry.getKey());
                glo2replace.put(global, replace);
                allReplace.add(replace);
                entryBlk.instructions.addFirst(new LoadInst(replace, global));
                for (var in : entry.getValue()) {
                    if (in instanceof LoadInst load && !loc2glo.containsKey(load.result)) loc2glo.put(load.result, replace);
                    //if (in instanceof StoreInst store && !loc2glo.containsKey(store.value) && store.value.isConstValue()) loc2glo.put(store.value, replace);
                }
            } else {
                Entity replace = null;
                if (global.init != null) replace = global.init;
                else replace = new constInt(0);
                glo2replace.put(global, replace);
                for (var in: entry.getValue()) {
                    if (in instanceof LoadInst load) loc2glo.put(load.result, replace);
                }
            }
        }
        HashSet<Entity> gloUsedBefore = new HashSet<>();
        for (var blk: func.blocks) {
            ArrayList<Inst> newInsts = new ArrayList<>();
            for (var inst: blk.instructions) {
                newInsts.add(inst);
                if (inst instanceof CallInst call) {
                    function next = globalScope.irFunction.get(call.funcName);
                    if (next != null) {
                        for (var exa: func.usedGlobal.entrySet()) {
                            if (next.affineGlobal.contains(exa.getKey())) {
                                Entity getReplace = glo2replace.get(exa.getKey());
                                if (gloUsedBefore.contains(getReplace))
                                    newInsts.add(newInsts.size() - 1, new StoreInst(getReplace, exa.getKey()));
                                //newInsts.add(new LoadInst(glo2replace.get(exa.getKey()), exa.getKey()));
                            }
                        }
                        for (var exa: func.usedGlobal.entrySet()) {
                            if (next.affineGlobal.contains(exa.getKey()) && next.defGlobal.contains(exa.getKey())) {
                                //newInsts.add(newInsts.size() - 1, new StoreInst(glo2replace.get(exa.getKey()), exa.getKey()));
                                newInsts.add(new LoadInst(glo2replace.get(exa.getKey()), exa.getKey()));
                            }
                        }
                    }
                }
                if (inst instanceof StoreInst store && store.pointer instanceof globalVar) {
                    if (glo2replace.containsKey(store.pointer)) {
                        newInsts.removeLast();
                        MoveInst move;
                        if (store.value.isConstValue() || !loc2glo.containsKey(store.value))
                            move = new MoveInst(glo2replace.get(store.pointer), store.value);
                        else move = new MoveInst(glo2replace.get(store.pointer), loc2glo.get(store.value));
                        if (!move.dest.equals(move.src)) {
                            newInsts.add(move);
                            gloUsedBefore.add(glo2replace.get(store.pointer));
                        }
                    }
                }
                Entity replace = loc2glo.get(inst.getDef());
                if (replace != null) inst.replaceOperand(inst.getDef(), replace);
                if (! (inst instanceof LoadInst) && allReplace.contains(inst.getDef())) gloUsedBefore.add(replace);
                for (var use: inst.getUses()) {
                    replace = loc2glo.get(use);
                    if (replace != null) inst.replaceOperand(use, replace);
                }
            }
            blk.instructions = newInsts;
        }
        for (var entry: func.usedGlobal.entrySet()) {
            globalVar global = entry.getKey();
            if (global.changed) {
                for (var rets: func.retBlks) {
                    rets.instructions.add(rets.instructions.size() - 1, new StoreInst(glo2replace.get(global), global));
                }
            }
        }
    }

}
