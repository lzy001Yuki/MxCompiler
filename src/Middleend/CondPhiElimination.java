package Middleend;

import MIR.Instruction.BrInst;
import MIR.Instruction.PhiInst;
import MIR.irEntity.function;
import MIR.utils.block;
import utils.Scope.GlobalScope;

// only apply to short_ block
public class CondPhiElimination {
    public function func;
    public CondPhiElimination(function func) {
        this.func = func;
    }
    public void run() {
        var iter = func.blocks.iterator();
        while (iter.hasNext()) {
            var blk = iter.next();
            if ((blk.lab.contains("short_end") || blk.lab.contains("ternary_end")) && blk.instructions.getFirst() instanceof BrInst br && br.cond != null) {
                // check if used later...
                PhiInst phi = blk.phiInsts.getFirst();
                if (phi.result == br.cond) {
                    block phiBlock1 = func.blockMap.get(phi.jump.getFirst().getSecond());
                    block phiBlock2 = func.blockMap.get(phi.jump.get(1).getSecond());
                    phiBlock1.instructions.clear();
                    phiBlock1.instructions.add(new BrInst(null, br.iftrue, null));
                    phiBlock2.instructions.clear();
                    phiBlock2.instructions.add(new BrInst(null, br.iffalse, null));
                    iter.remove();
                }
            } else if ((blk.lab.contains("short_end") || blk.lab.contains("ternary_end") )&& !blk.phiInsts.isEmpty()) {
                PhiInst phi = blk.phiInsts.getFirst();
                block phiBlock1 = func.blockMap.get(phi.jump.getFirst().getSecond());
                phiBlock1.needPhi = true;
                block phiBlock2 = func.blockMap.get(phi.jump.get(1).getSecond());
                phiBlock2.needPhi = true;
            }
        }
        iter = func.blocks.iterator();
        while (iter.hasNext()) {
            var blk = iter.next();
            if (blk.instructions.getLast() instanceof BrInst br && br.cond != null) {
                block phiBlock1 = func.blockMap.get(br.iftrue);
                block phiBlock2 = func.blockMap.get(br.iffalse);
                String trueStr = getFinalLab(phiBlock1);
                br.iftrue = (trueStr == null) ? br.iftrue : trueStr;
                String falseStr = getFinalLab(phiBlock2);
                br.iffalse = (falseStr == null) ? br.iffalse : falseStr;
            } else if (blk.instructions.getLast() instanceof BrInst br && br.cond == null) {
                block phiBlock = func.blockMap.get(br.iftrue);
                String trueStr = getFinalLab(phiBlock);
                br.iftrue = (trueStr == null) ? br.iftrue : trueStr;
            }
        }
    }

    public String getFinalLab(block blk) {
        String str = null;
        block cur = blk;
        while (cur.instructions.size() == 1 && cur.instructions.getFirst() instanceof BrInst br) {
            if (br.cond == null && !cur.lab.contains("for")) {
                if (cur.needPhi) return str;
                str = br.iftrue;
                cur.isDead = true;
                cur = func.blockMap.get(str);
            } else return str;
        }
        return str;
    }
}
