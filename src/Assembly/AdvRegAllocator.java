package Assembly;

import Assembly.Inst.MvInst;
import Assembly.Operand.Reg;
import Assembly.utils.CGBuilder;
import Middleend.LivenessAnalysis;

import java.util.HashSet;
import java.util.LinkedList;

public class AdvRegAllocator {
    public ASMProgram program;
    public static int K = 27;
    public LivenessAnalysis analyzer = new LivenessAnalysis();
    public LinkedList<MvInst> worklistMoves = new LinkedList<>();
    public HashSet<Reg> initial = new HashSet<>();
    public LinkedList<Reg> simplifyWorklist = new LinkedList<>();
    public LinkedList<Reg> freezeWorklist = new LinkedList<>();
    public LinkedList<Reg> spillWorklist = new LinkedList<>();
    public HashSet<MvInst> activeMoves = new HashSet<>();
    public AdvRegAllocator(ASMProgram program) {
        this.program = program;
    }
    public void run() {
        for (var func: program.text) {
            analyzer.run(func);
            new CGBuilder(func).build(worklistMoves);
            makeWorkList();
        }
    }

    public void makeWorkList() {
        for (var n: initial) {
            if (n.degree >= K) {
                spillWorklist.add(n);
            } else if (MoveRelated(n)) {
                freezeWorklist.add(n);
            } else {
                simplifyWorklist.add(n);
            }
        }
    }

    public HashSet<MvInst> NodeMoves(Reg reg) {
        HashSet<MvInst> tmp = new HashSet<>();
        for (var r: reg.moveList) {
            if (activeMoves.contains(r)) tmp.add(r);
            else if (worklistMoves.contains(r)) tmp.add(r);
        }
        return tmp;
    }

    public boolean MoveRelated(Reg reg) {
        return !NodeMoves(reg).isEmpty();
    }
}
