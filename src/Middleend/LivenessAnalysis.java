package Middleend;

import Assembly.ASMBlock;
import Assembly.ASMFunction;
import Assembly.Operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LivenessAnalysis {
    public void run(ASMFunction func) {
        var iter = func.blocks.iterator();
        //ASMBlock lastBlk = null;
        // propagate in the reverse order
        LinkedList<ASMBlock> queue = new LinkedList<>();
        while (iter.hasNext()) {
            var blk = iter.next();
            collect(blk);
            //if (!blk.prev.isEmpty() || blk == func.blocks.getFirst()) lastBlk = blk;
            if (!blk.prev.isEmpty() || blk == func.blocks.getFirst()) {
                if (blk.next.isEmpty()) queue.add(blk);
            }
        }

        //queue.add(lastBlk);
        while (!queue.isEmpty()) {
            ASMBlock curBlk = queue.pollFirst();
            HashSet<Reg> newOut = new HashSet<>();

            for (var nxt: curBlk.next) {
                newOut.addAll(nxt.ins);
            }

            HashSet<Reg> newIn = new HashSet<>(newOut);
            newIn.removeAll(curBlk.defs);
            newIn.addAll(curBlk.uses);

            if (!newIn.equals(curBlk.ins) || !newOut.equals(curBlk.outs)) {
                curBlk.ins.addAll(newIn);
                curBlk.outs.addAll(newOut);
                for (var pred: curBlk.prev) {
                    if (!queue.contains(pred)) queue.add(pred);
                }
            }
        }
    }

    private void collect(ASMBlock blk) {
        blk.ins.clear();
        blk.outs.clear();
        blk.defs.clear();
        blk.ins.clear();
        for (var inst: blk.inst) {
            for (var use: inst.getUse()) {
                if (!blk.defs.contains(use)) blk.uses.add(use);
            }
            blk.defs.addAll(inst.getDef());
        }
    }
}
