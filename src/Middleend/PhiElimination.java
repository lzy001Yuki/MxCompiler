package Middleend;

import Assembly.Operand.VirtualReg;
import MIR.Instruction.MoveInst;
import MIR.irEntity.Entity;
import MIR.utils.block;
import utils.Scope.GlobalScope;

public class PhiElimination {
    public GlobalScope globalScope;
    public int phiIdx = 0;
    public PhiElimination(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }
    public void run(){
        for (var func: globalScope.irFunction.entrySet()) {
            for (var blk: func.getValue().blocks) {
                for (var phiInst: blk.phiInsts) {
                    Entity phiDest = new Entity(phiInst.result.type, "phi." + phiIdx);
                    phiIdx++;
                    for (var it: phiInst.jump) {
                        MoveInst inst = new MoveInst(phiDest, it.getFirst());
                        if (func.getValue().entity2use.get(it.getFirst()) != null && !globalScope.irFunction.containsKey("Ksm")) {
                            func.getValue().entity2use.get(it.getFirst()).add(inst);
                        }
                        block phiBlock = func.getValue().blockMap.get(it.getSecond());
                        if (phiBlock != null) phiBlock.instructions.add(phiBlock.instructions.size() - 1, inst);
                    }
                    MoveInst inst1 = new MoveInst(phiInst.result, phiDest);
                    blk.instructions.addFirst(inst1);
                }
                blk.phiInsts.clear();
            }
        }
    }
}
