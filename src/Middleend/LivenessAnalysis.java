package Middleend;

import Assembly.ASMBlock;
import Assembly.ASMFunction;
import Assembly.Operand.Reg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LivenessAnalysis {
    public void run(ASMFunction func) {
        for (var blk: func.blocks) collect(blk);

        // propagate in the reverse order
        ASMBlock lastBlk = func.blocks.getLast();
        HashSet<ASMBlock> visited = new HashSet<>();
        LinkedList<ASMBlock> queue = new LinkedList<>();
        queue.add(lastBlk);
        while (!queue.isEmpty()) {
            ASMBlock curBlk = queue.pollFirst();
            if (visited.contains(curBlk)) continue;
            visited.add(curBlk);
            HashSet<Reg> newOut = new HashSet<>();

            for (var nxt: curBlk.next) {
                newOut.addAll(nxt.ins);
            }

            HashSet<Reg> newIn = new HashSet<>(newOut);
            newIn.removeAll(curBlk.defs);
            newIn.addAll(curBlk.ins);

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
        for (var inst: blk.inst) {
            for (var use: inst.getUse()) {
                if (!blk.defs.contains(use)) blk.uses.add(use);
            }
            blk.defs.add(inst.getDef());
        }
    }
}
