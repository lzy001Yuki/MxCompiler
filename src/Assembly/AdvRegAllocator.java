package Assembly;

import Assembly.Inst.MvInst;
import Assembly.Operand.Reg;
import Assembly.Operand.VirtualReg;
import Assembly.utils.CGBuilder;
import Assembly.utils.CGEdge;
import Assembly.utils.RegStore;
import Middleend.LivenessAnalysis;

import java.util.*;

public class AdvRegAllocator {
    public ASMProgram program;
    public static int K = 27;
    public RegStore regStore = new RegStore();
    public LivenessAnalysis analyzer = new LivenessAnalysis();
    public LinkedList<MvInst> worklistMoves = new LinkedList<>();
    public HashSet<Reg> initial = new HashSet<>();
    public LinkedList<Reg> simplifyWorklist = new LinkedList<>();
    public LinkedList<Reg> freezeWorklist = new LinkedList<>();
    public LinkedList<Reg> spillWorklist = new LinkedList<>();
    public HashSet<MvInst> activeMoves = new HashSet<>();
    public HashSet<MvInst> coalescedMoves = new HashSet<>();
    public Stack<Reg> selectStack = new Stack<>();
    public HashSet<Reg> coalescedNodes = new HashSet<>();
    public HashSet<Reg> preColored = new HashSet<>(regStore.regs.values());
    public HashSet<Reg> coloredNodes = new HashSet<>();
    public HashSet<Reg> spilledNodes = new HashSet<>();
    public HashSet<MvInst> constrainedMoves = new HashSet<>();
    public HashSet<MvInst> frozenMoves = new HashSet<>();
    public HashSet<CGEdge> adjSet;
    public CGBuilder builder;
    public AdvRegAllocator(ASMProgram program) {
        this.program = program;
    }

    public void run() {
        for (var func: program.text) {
            coloring(func);
            for (var blk: func.blocks) {
                blk.inst.removeIf(inst -> inst instanceof MvInst mv && mv.rs1.color == mv.rd.color);
            }
        }
    }

    public void coloring(ASMFunction func) {
        init(func);
        analyzer.run(func);
        builder = new CGBuilder(func);
        builder.build(worklistMoves);
        adjSet = builder.adjSet;
        makeWorkList();
        do {
            if (!simplifyWorklist.isEmpty()) Simplify();
            else if (!worklistMoves.isEmpty()) Coalesce();
            else if (!freezeWorklist.isEmpty()) Freeze();
            else if (!spillWorklist.isEmpty()) SelectSpill();
        } while (!simplifyWorklist.isEmpty() || !worklistMoves.isEmpty() || !freezeWorklist.isEmpty() || spillWorklist.isEmpty());
        AssignColors();
        if (!spilledNodes.isEmpty()) {
            rewriteProgram();
            coloring(func);
        }
    }

    public void init(ASMFunction func) {
        freezeWorklist.clear();
        spillWorklist.clear();
        spilledNodes.clear();
        coloredNodes.clear();
        selectStack.clear();
        coalescedNodes.clear();
        simplifyWorklist.clear();
        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        worklistMoves.clear();
        activeMoves.clear();
        adjSet.clear();

        for (var blk: func.blocks) {
            for (var inst: blk.inst) {
                if (inst.getDef() instanceof VirtualReg) {
                    inst.getDef().init();
                    inst.getDef().defNum++;
                }
                for (var use: inst.getUse()) {
                    if (use instanceof VirtualReg) use.init();
                    use.useNum++;
                }
            }
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

    public HashSet<Reg> Adjacent(Reg n) {
        HashSet<Reg> tmp = new HashSet<>(n.adjList);
        for (var reg: n.adjList) {
            if (selectStack.contains(reg)) tmp.remove(reg);
            else if (coalescedNodes.contains(reg)) tmp.remove(reg);
        }
        return tmp;
    }

    public void Simplify() {
        Reg reg = simplifyWorklist.pollFirst();
        if (reg == null) throw new RuntimeException();
        selectStack.push(reg);
        for (var m: Adjacent(reg)) {
            DecrementDegree(m);
        }
    }

    public void DecrementDegree(Reg reg) {
        int d = reg.degree;
        reg.degree--;
        if (d == K) {
            HashSet<Reg> tmp = new HashSet<>(Adjacent(reg));
            tmp.add(reg);
            EnableMoves(tmp);
            spillWorklist.remove(reg);
            if (MoveRelated(reg)) {
                freezeWorklist.add(reg);
            } else {
                simplifyWorklist.add(reg);
            }
        }
    }

    public void EnableMoves(HashSet<Reg> nodes) {
        for (var n: nodes) {
            for (var m: NodeMoves(n)) {
                if (activeMoves.contains(m)) {
                    activeMoves.remove(m);
                    worklistMoves.add(m);
                }
            }
        }
    }

    public void Coalesce() {
        var move = worklistMoves.pollFirst();
        if (move == null) throw new RuntimeException();
        CGEdge preEdge = new CGEdge(GetAlias(move.rd), GetAlias(move.rs1));
        CGEdge newEdge;
        if (preColored.contains(preEdge.v)) {
            newEdge = new CGEdge(preEdge.v, preEdge.u);
        } else {
            newEdge = new CGEdge(preEdge.u, preEdge.v);
        }
        if (newEdge.u == newEdge.v) {
            coalescedMoves.add(move);
            AddWorkList(newEdge.u);
        } else if (preColored.contains(newEdge.v) || adjSet.contains(newEdge)) {
            constrainedMoves.add(move);
            AddWorkList(newEdge.u);
            AddWorkList(newEdge.v);
        } else if (judgeOK(newEdge.u, newEdge.v)) {
            coalescedMoves.add(move);
            Combine(newEdge.u, newEdge.v);
            AddWorkList(newEdge.u);
        } else {
            activeMoves.add(move);
        }
    }

    public void AddWorkList(Reg reg) {
        if (!preColored.contains(reg) && !MoveRelated(reg) && reg.degree < K) {
            freezeWorklist.remove(reg);
            simplifyWorklist.add(reg);
        }
    }

    public Reg GetAlias(Reg reg) {
        if (coalescedNodes.contains(reg)) return GetAlias(reg.alias);
        else return reg;
    }

    public boolean Conservative(HashSet<Reg> nodes) {
        int k = 0;
        for (var n: nodes) {
            if (n.degree >= K) k++;
        }
        return k < K;
    }

    public boolean OK(Reg t, Reg r) {
        return t.degree < K || preColored.contains(t) || adjSet.contains(new CGEdge(t, r));
    }

    public void Combine(Reg u, Reg v) {
        if (freezeWorklist.contains(v)) freezeWorklist.remove(v);
        else spillWorklist.remove(v);
        coalescedNodes.add(v);
        v.alias = u;
        u.moveList.addAll(v.moveList);
        HashSet<Reg> vSet = new HashSet<>();
        vSet.add(v);
        EnableMoves(vSet);
        for (var t: Adjacent(v)) {
            builder.addEdge(t, u);
            DecrementDegree(t);
        }
        if (u.degree >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    private boolean judgeOK(Reg u, Reg v) {
        boolean judge1 = true;
        for (var t: Adjacent(v)) {
            if (!OK(t, v)) {
                judge1 = false;
                break;
            }
        }
        HashSet<Reg> tmp = new HashSet<>(Adjacent(u));
        tmp.addAll(Adjacent(v));
        boolean judge2 = Conservative(tmp);
        return (preColored.contains(u) && judge1) || (judge2 && !preColored.contains(u));
    }

    public void Freeze() {
        var u = freezeWorklist.pollFirst();
        simplifyWorklist.add(u);
        FreezeMoves(u);
    }

    public void FreezeMoves(Reg reg) {
        Reg v;
        for (var move: NodeMoves(reg)) {
            if (GetAlias(move.rs1) == GetAlias(reg)) v = GetAlias(move.rd);
            else v = GetAlias(move.rs1);
            activeMoves.remove(move);
            frozenMoves.add(move);
            if (NodeMoves(v).isEmpty() && v.degree < K) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    public void SelectSpill() {
        // Spill the least frequently-used variable
        Reg m = null;
        double min = Double.MAX_VALUE;
        for (var r: spillWorklist) {
            double activeness = (double) r.useNum / (r.useNum + r.defNum);
            if (activeness < min && !r.isTemp) {
                min = activeness;
                m = r;
            }
        }
        spillWorklist.remove(m);
        simplifyWorklist.add(m);
        FreezeMoves(m);

    }

    public void AssignColors() {
        while (!selectStack.isEmpty()) {
            var n = selectStack.pop();
            ArrayList<Reg> color = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                color.add(regStore.getPhyReg("s" + i));
            }
            for (int i = 0; i < 8; i++) {
                color.add(regStore.getPhyReg("a" + i));
            }
            for (int i = 0; i < 7; i++) {
                color.add(regStore.getPhyReg("t" + i));
            }
            for (var w: n.adjList) {
                if (coloredNodes.contains(GetAlias(w)) || preColored.contains(GetAlias(w))) {
                    // whether need judgement for physReg??
                    color.remove(GetAlias(w).color);
                }
            }
            if (color.isEmpty()) {
                spilledNodes.add(n);
            } else {
                coloredNodes.add(n);
                var c = color.getFirst();
                color.remove(c);
                n.color = c;
            }
        }
        for (var n: coalescedNodes) {
            n.color = GetAlias(n).color;
        }
    }
    public void rewriteProgram() {

    }
}
