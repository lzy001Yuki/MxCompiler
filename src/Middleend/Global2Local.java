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
            runOnFunc(entry.getValue());
        }
        globalScope.globalInst.entrySet().removeIf(entry -> entry.getKey() instanceof globalVar global && !global.changed);
    }

    public void runOnFunc(function func) {
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
