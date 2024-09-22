package Assembly.utils;

import Assembly.ASMFunction;
import Assembly.ASMProgram;
import Assembly.Inst.MvInst;
import Assembly.Operand.PhysicReg;
import Assembly.Operand.Reg;
import Assembly.Operand.VirtualReg;
import MIR.irEntity.function;

import java.util.HashSet;
import java.util.LinkedList;

// ConflictGraph Builder
public class CGBuilder {
    public ASMFunction func;
    public HashSet<CGEdge> adjSet;
    public CGBuilder(ASMFunction func) {
        this.func = func;
        adjSet = new HashSet<>();
    }

    public void build(LinkedList<MvInst> worklistMoves) {
        for (var blk: func.blocks) {
            var curLive = new HashSet<>(blk.outs);
            for (int i = blk.inst.size() - 1; i >= 0; i--) {
                var curInst = blk.inst.get(i);
                if (curInst instanceof MvInst curMv) {
                    curLive.removeAll(curMv.getUse());
                    curMv.getDef().moveList.add(curMv);
                    for (var use: curMv.getUse()) {
                        use.moveList.add(curMv);
                    }
                    worklistMoves.add(curMv);
                }
                for (var live: curLive) {
                    addEdge(live, curInst.getDef());
                }
                curLive.addAll(curInst.getUse());
            }
        }
    }

    public void addEdge(Reg u, Reg v) {
        if (u == v) return;
        CGEdge edge1 = new CGEdge(u, v);
        CGEdge edge2 = new CGEdge(v, u);
        if (!adjSet.contains(edge1)) {
            adjSet.add(edge1);
            adjSet.add(edge2);
            if (u instanceof VirtualReg vu) {
                vu.adjList.add(v);
                vu.degree++;
            }
            if (v instanceof VirtualReg vv) {
                vv.adjList.add(u);
                vv.degree++;
            }
        }
    }

}
