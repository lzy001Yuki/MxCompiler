package Middleend;

import MIR.IRBuilder;
import MIR.Instruction.*;
import MIR.irEntity.Entity;
import MIR.irEntity.function;
import MIR.irEntity.localVar;
import MIR.type.ptrType;
import MIR.utils.block;
import utils.Pair;
import utils.Scope.GlobalScope;

import java.util.*;

public class Mem2Reg {
    public HashMap<Entity, HashSet<block>> collectAlloca;
    public HashMap<PhiInst, String> Phi2Name;
    public IRBuilder builder;
    public HashMap<String, Stack<Entity>> Name2Entity;

    public Mem2Reg(IRBuilder builder) {
        collectAlloca = new HashMap<>();
        Phi2Name = new HashMap<>();
        Name2Entity = new HashMap<>();
        this.builder = builder;
    }

    public void run(GlobalScope globalScope){
        for (var func: globalScope.irFunction.entrySet()) {
            insertPhi(func.getValue());
            renameVar(func.getValue().blocks.getFirst());
        }
    }

    public void collectVars(function func) {
        collectAlloca.clear();
        for (var inst: func.blocks.getFirst().instructions) {
            if (inst instanceof AllocaInst) collectAlloca.put(((AllocaInst) inst).result, new HashSet<>());
        }
        for (var blk: func.blocks) {
            for (var iter: blk.instructions) {
                if (iter instanceof StoreInst) {
                    if (collectAlloca.containsKey(((StoreInst) iter).pointer)) collectAlloca.get(((StoreInst) iter).pointer).add(blk);
                }
            }
        }
    }

    public void insertPhi(function func) {
        collectVars(func);
        for (var collected: collectAlloca.entrySet()) {
            ArrayDeque<block> queue = new ArrayDeque<>();
            HashSet<block> visited = new HashSet<>();
            for (var blk: collected.getValue()) {
                queue.push(blk);
            }
            while (!queue.isEmpty()) {
                var back = queue.poll();
                for (var df: back.df) {
                    if (visited.contains(df)) continue;
                    visited.add(df);
                    queue.add(df);
                    localVar phiRes = new localVar(((ptrType)collected.getKey().type).baseType, builder.rename(collected.getKey().irName));
                    PhiInst phi = new PhiInst(phiRes);
                    df.phiInsts.add(phi);
                    Phi2Name.put(phi, collected.getKey().irName);
                }
            }
        }
    }

    public void renameVar(block blk) {
        ArrayList<String> curVar = new ArrayList<>();
        for (var phi: blk.phiInsts) {
            String name = Phi2Name.get(phi);
            pushCurVar(name, phi.result);
            curVar.add(name);
        }
        Iterator<Inst> iterator = blk.instructions.iterator();
        while (iterator.hasNext()) {
            Inst inst = iterator.next();
            if (inst instanceof LoadInst load) {
                if (!load.pointer.irName.contains("array_ptr")) {
                    Entity replaced = replaceName(load.pointer.irName);
                    inst.replaceOperand(load.pointer, replaced);
                    pushCurVar(load.result.irName, load.pointer);
                    curVar.add(load.result.irName);
                    iterator.remove();
                }
            } else if (inst instanceof StoreInst store) {
                if (!store.pointer.irName.contains("malloc_ptr") && !store.pointer.irName.contains("next_ptr") && !store.pointer.irName.contains("array_ptr")) {
                    pushCurVar(store.pointer.irName, store.value);
                    curVar.add(store.pointer.irName);
                    iterator.remove();
                }
            } else if (inst instanceof AllocaInst alloca) {
                // do nothing
            } else {
                for (var uses: inst.getUses()) {
                    if (!uses.irName.contains("malloc_ptr")) {
                        Entity replaced = replaceName(uses.irName);
                        if (replaced != null) inst.replaceOperand(uses, replaced);
                    }
                }
            }
        }
        for (var nxt: blk.next) {
            for (var phi: nxt.phiInsts) {
                String name = Phi2Name.get(phi);
                if (name != null) {
                    phi.jump.add(new Pair<>(replaceName(name), blk.lab));
                }
            }
        }
        for (var child: blk.dc) {
            renameVar(child);
        }
        for (var name: curVar) {
            if (Name2Entity.get(name) != null && !Name2Entity.get(name).isEmpty()) Name2Entity.get(name).pop();
        }
    }

    public void pushCurVar(String name, Entity entity) {
        if (Name2Entity.containsKey(name)) Name2Entity.get(name).push(entity);
        else {
            Stack<Entity> newStack = new Stack<>();
            newStack.add(entity);
            Name2Entity.put(name, newStack);
        }
    }

    public Entity replaceName(String name) {
        Entity replace1 = null;
        String curname = name;
        while (Name2Entity.containsKey(curname) && !Name2Entity.get(curname).isEmpty()) {
            replace1 = Name2Entity.get(curname).getLast();
            curname = replace1.irName;
        }
        return replace1;
    }
}
