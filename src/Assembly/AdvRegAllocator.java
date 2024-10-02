package Assembly;

import Assembly.Inst.*;
import Assembly.Operand.Imm;
import Assembly.Operand.PhysicReg;
import Assembly.Operand.Reg;
import Assembly.Operand.VirtualReg;
import Assembly.utils.CGBuilder;
import Assembly.utils.CGEdge;
import Assembly.utils.RegStore;
import MIR.Instruction.Inst;
import Middleend.LivenessAnalysis;
import utils.Pair;

import java.util.*;

public class AdvRegAllocator {
    public ASMProgram program;
    public static int K = 27;
    //public RegStore RegStore = new RegStore();
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
    public HashSet<Reg> preColored = new HashSet<>(RegStore.regs.values());
    public HashSet<Reg> coloredNodes = new HashSet<>();
    public HashSet<Reg> spilledNodes = new HashSet<>();
    public HashSet<MvInst> constrainedMoves = new HashSet<>();
    public HashSet<MvInst> frozenMoves = new HashSet<>();
    public HashSet<Reg> newTemps = new HashSet<>();
    public HashSet<CGEdge> adjSet = new HashSet<>();
    public CGBuilder builder;
    public AdvRegAllocator(ASMProgram program) {
        this.program = program;
    }

    public void run() {
        for (var func: program.text) {
            coloring(func);
            // allocate Regs
            allocateRegs(func);
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
        } while (!simplifyWorklist.isEmpty() || !worklistMoves.isEmpty() || !freezeWorklist.isEmpty() || !spillWorklist.isEmpty());
        AssignColors();
        if (!spilledNodes.isEmpty()) {
            rewriteProgram(func);
            coloring(func);
        }
    }

    public void allocateRegs(ASMFunction func) {
        ArrayList<ASMBlock> retBlock = new ArrayList<>();
        for (var blk: func.blocks) {
            LinkedList<ASMInst> newInst = new LinkedList<>();
            for (var inst: blk.inst) {
                if (inst instanceof RetInst) {
                    retBlock.add(blk);
                }
                if (inst.rs1 instanceof VirtualReg) {
                    inst.rs1 = inst.rs1.color;
                }
                if (inst.rs2 instanceof VirtualReg) {
                    inst.rs2 = inst.rs2.color;
                }
                if (inst.rd instanceof VirtualReg) {
                    inst.rd = inst.rd.color;
                }
                if (!(inst instanceof MvInst) || inst.rs1 != inst.rd) {
                    newInst.add(inst);
                }
            }
            blk.inst = newInst;
        }
        ASMBlock entryBlk = func.blocks.getFirst();
        int totalSpace = func.allocSpace + func.spilledSpace + 4 * func.virtualNum;
        int stackSpace = (totalSpace + 15) / 16 * 16;
        ITypeInst in = new ITypeInst("addi", RegStore.regs.get("sp"), RegStore.regs.get("sp"), new Imm(-stackSpace));
        ITypeInst out = new ITypeInst("addi", RegStore.regs.get("sp"), RegStore.regs.get("sp"), new Imm(stackSpace));
        checkImm(entryBlk.inst, in, 0, in.imm, true);
        for (var retBlk: retBlock) {
            int pos = 0;
            for (int i = 0; i < retBlk.inst.size(); i++) {
                if (retBlk.inst.get(i) instanceof RetInst) pos = i;
            }
            checkImm(retBlk.inst, out, pos, out.imm, true);
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
        initial.clear();
        newTemps.clear();

        for (var blk: func.blocks) {
            for (var inst: blk.inst) {
                for (var def: inst.getDef()) {
                    if (def instanceof VirtualReg) {
                        def.init();
                        initial.add(def);
                        def.defNum++;
                    }
                }
                for (var use: inst.getUse()) {
                    if (use instanceof VirtualReg) use.init();
                    initial.add(use);
                    use.useNum++;
                }
            }
        }
        initial.removeAll(preColored);
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
            //double activeness = 1.0 - (double) r.useNum / (r.useNum + r.defNum);
            double activeness = (r.useNum + r.defNum) * 1.0 / r.degree;
            if (activeness < min && !newTemps.contains(r) && !(r instanceof PhysicReg)) {
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
            for (int i = 0; i < 7; i++) {
                color.add(RegStore.regs.get("t" + i));
            }

            for (int i = 0; i < 8; i++) {
                color.add(RegStore.regs.get("a" + i));
            }
            for (int i = 0; i < 12; i++) {
                color.add(RegStore.regs.get("s" + i));
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
    public void rewriteProgram(ASMFunction func) {
        HashMap<Reg, Integer> spillToMem = new HashMap<>();
        for (var spill: spilledNodes) {
            spillToMem.put(spill, func.spilledSpace);
            func.spilledSpace += 4;
        }
        for (var blk: func.blocks) {
            LinkedList<ASMInst> newInst = new LinkedList<>();
            for (var inst: blk.inst) {
                if (spilledNodes.contains(inst.rs1)) {
                    VirtualReg spillReg = new VirtualReg();
                    newTemps.add(spillReg);
                    LoadInst newLoad = new LoadInst("lw", spillReg, RegStore.regs.get("sp"), new Imm(func.allocSpace + spillToMem.get(inst.rs1)));
                    allocate(newLoad, newInst);
                    inst.rs1 = spillReg;
                }
                if (spilledNodes.contains(inst.rs2)) {
                    VirtualReg spillReg = new VirtualReg();
                    newTemps.add(spillReg);
                    LoadInst newLoad = new LoadInst("lw", spillReg, RegStore.regs.get("sp"), new Imm(func.allocSpace + spillToMem.get(inst.rs2)));
                    allocate(newLoad, newInst);
                    inst.rs2 = spillReg;
                }
                if (inst instanceof ITypeInst i) checkImm(newInst, inst, newInst.size(), i.imm, false);
                else newInst.add(inst);
                if (spilledNodes.contains(inst.rd)) {
                    VirtualReg spillReg = new VirtualReg();
                    newTemps.add(spillReg);
                    StoreInst newStore = new StoreInst("sw", spillReg, RegStore.regs.get("sp"), new Imm(func.allocSpace + spillToMem.get(inst.rd)));
                    allocate(newStore, newInst);
                    inst.rd = spillReg;
                }
            }
            blk.inst = newInst;
        }
    }

    public boolean checkImm(LinkedList<ASMInst> insts, ASMInst inst, int pos, Imm imm, boolean type) {
        if (imm.value < 2047 && imm.value > -2048) {
            insts.add(pos, inst);
            return true;
        } else {
            if (type) {
                insts.add(pos, new LiInst(RegStore.regs.get("t0"), imm));
                insts.add(pos + 1, new BinaryInst("add", inst.rd, inst.rd, RegStore.regs.get("t0")));
            } else {
                insts.add(pos, new LiInst(inst.rd, imm));
                insts.add(pos + 1, new BinaryInst("add", inst.rs1, inst.rd, inst.rd));
            }
            return false;
        }
    }

    public void allocate(ASMInst inst, LinkedList<ASMInst> newInst) {
        if (inst instanceof LoadInst load) {
            if (!checkImm(newInst, inst, newInst.size() - 1, load.offset, false)) {
                newInst.add(new LoadInst("lw", inst.rd, inst.rd, new Imm(0)));
            }
        } else if (inst instanceof StoreInst store) {
            if (store.offset.value < 2047 && store.offset.value > -2048) {
                newInst.add(inst);
            } else {
                VirtualReg address = new VirtualReg();
                newTemps.add(address);
                newInst.add(new LiInst(address, store.offset));
                newInst.add(new BinaryInst("add", address, RegStore.regs.get("sp"), address));
                newInst.add(new StoreInst("sw", inst.rs2, address, new Imm(0)));
            }
        }
    }

    @Override
    public String toString() {
        return program.toString();
    }
}
