package Middleend;

import MIR.Instruction.BrInst;
import MIR.Instruction.Inst;
import MIR.Instruction.PhiInst;
import MIR.irEntity.Entity;
import MIR.irEntity.constBool;
import MIR.irEntity.function;
import MIR.utils.block;
import utils.Pair;
import utils.Scope.GlobalScope;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class SCCP {
    public GlobalScope globalScope;
    LinkedList<Inst> que = new LinkedList<>();
    HashSet<Inst> constInsts = new HashSet<>();

    public SCCP(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }

    public void run() {
        for (var func: globalScope.irFunction.entrySet()) {
            workOnFunc(func.getValue());
        }
    }

    public void workOnFunc(function func) {
        for (var blk: func.blocks) {
            for (var phi: blk.phiInsts) {
                if (phi.getConst() != null) {
                    que.add(phi);
                    constInsts.add(phi);
                }
            }
            for (var inst: blk.instructions) {
                if (inst.getConst() != null) {
                    que.add(inst);
                    constInsts.add(inst);
                }
            }
        }
        while (!que.isEmpty()) {
            Inst inst = que.removeFirst();
            constInsts.remove(inst);
            if (inst.isDead) continue;
            var conVal = inst.getConst();
            if (conVal != null) {
                var def = inst.getDef();
                if (! (inst instanceof BrInst br)) {
                    inst.isDead = true;
                    for (var useInst: func.entity2use.get(def)) {
                        // for phi case
                        if (!conVal.isConstValue()) func.entity2use.get(conVal).add(useInst);
                        useInst.entity2const(def, conVal);
                        if (!constInsts.contains(useInst)) {
                            constInsts.add(useInst);
                            que.add(useInst);
                        }
                    }
                } else {
                    var curBlock = inst.belongedBlock;
                    var trueBlock = func.blockMap.get(br.iftrue);
                    var falseBlock = func.blockMap.get(br.iffalse);
                    var retained = ((constBool) conVal).value ? trueBlock : falseBlock;
                    var removed = ((constBool) conVal).value ? falseBlock : trueBlock;
                    if (!(curBlock.instructions.getLast() instanceof BrInst)) throw new RuntimeException();
                    curBlock.instructions.removeLast();
                    curBlock.next.remove(removed);
                    curBlock.instructions.add(new BrInst(null, retained.lab, null));
                    processPhi(removed, curBlock, func);
                }
            }
        }
        func.blockMap.clear();
        for (var blk: func.blocks) {
            blk.phiInsts.removeIf(phiInst -> phiInst.isDead);
            blk.instructions.removeIf(it -> it.isDead);
            func.blockMap.put(blk.lab, blk);
        }
    }

    public void analyzeCFG(block obj, function func) {
        for (var inst: obj.instructions) {
            for (var use: inst.getUses()) {
                if (func.entity2use.containsKey(use)) func.entity2use.get(use).remove(inst);
            }
        }
        func.blocks.remove(obj);
        for (var nxt: obj.next) {
            processPhi(nxt, obj, func);
        }
    }

    public void processPhi(block blk, block prev, function func) {
        if (!blk.phiInsts.isEmpty()) {
            for (var phi: blk.phiInsts) {
                boolean flag = false;
                Iterator<Pair<Entity, String>> iter= phi.jump.iterator();
                while (iter.hasNext()) {
                    var j = iter.next();
                    if (j.getSecond().equals(blk.lab)) {
                        iter.remove();
                        flag = true;
                        break;
                    }
                }
                if (flag && !constInsts.contains(phi)) {
                    constInsts.add(phi);
                    que.add(phi);
                }
            }
        }
        blk.prev.remove(prev);
        if (blk.prev.isEmpty()) analyzeCFG(blk, func);
    }
}
