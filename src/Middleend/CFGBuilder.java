package Middleend;


import MIR.Instruction.BrInst;
import MIR.Instruction.Inst;
import MIR.irEntity.function;
import MIR.utils.block;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.Map;

public class CFGBuilder {
    public GlobalScope globalScope;
    public CFGBuilder(GlobalScope scope) {
        this.globalScope = scope;
    }
    public void buildCFG() {
        for (Map.Entry<String, function> entry: globalScope.irFunction.entrySet()) {
            function func = entry.getValue();
            new CondPhiElimination(func).run();
            var iter = func.blocks.iterator();
            while (iter.hasNext()) {
                var blk = iter.next();
                if (blk.isDead) {
                    iter.remove();
                    continue;
                }
                Inst lastInst = blk.instructions.getLast();
                if (lastInst instanceof BrInst) {
                    link(blk, func.blockMap.get(((BrInst) lastInst).iftrue));
                    if (((BrInst) lastInst).iffalse != null) {
                        link(blk, func.blockMap.get(((BrInst) lastInst).iffalse));
                    }
                }
            }
            // remove dead codes
            ArrayList<block> newBlocks = new ArrayList<>();
            for (var blk: func.blocks) {
                if (blk == func.blocks.getFirst() || !blk.prev.isEmpty()) newBlocks.add(blk);
            }
            func.blocks = newBlocks;
        }
    }
    private void link(block first, block second) {
        first.next.add(second);
        second.prev.add(first);
    }
}
