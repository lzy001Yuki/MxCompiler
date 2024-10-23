package Assembly;

import Assembly.Inst.*;
import Assembly.Operand.Imm;
import Assembly.Operand.PhysicReg;
import Assembly.Operand.Reg;
import Assembly.Operand.VirtualReg;
import Assembly.utils.RegStore;
import MIR.Instruction.Inst;
import utils.Pair;

import java.util.*;

public class RegAllocator {
    public ASMProgram program;
    public ArrayDeque<Integer> idleReg;
    public int usedRegNum = 0;
    public LinkedList<ASMInst> allocateInsts;
    public RegStore regs;
    public int allocSpace;
    public RegAllocator(ASMProgram p) {
        program = p;
        regs = new RegStore();
        idleReg = new ArrayDeque<>();
        allocateInsts = new LinkedList<>();
    }

    public void run() {
        for (var func: program.text) {
            allocSpace = func.allocSpace + func.spilledSpace;
            usedRegNum = 0;
            idleReg.clear();
            ArrayList<Pair<ASMBlock, Integer>> retInsts = new ArrayList<>();
            for (var block: func.blocks) {
                for (var inst: block.inst) {
                    allocate(inst);
                    if (inst instanceof Assembly.Inst.RetInst) {
                        retInsts.add(new Pair<>(block, allocateInsts.indexOf(inst)));
                    }
                }
                block.inst = allocateInsts;
                allocateInsts = new LinkedList<>();
            }
            int totalSpace = allocSpace + 4 * (func.virtualNum);
            if (totalSpace == 0) continue;
            for (int i = 0; i < usedRegNum; i++) {
                if (totalSpace < 2048) {
                    func.addLast(new LoadInst("lw", regs.getPhyReg("t" + i), regs.getPhyReg("sp"), new Imm(totalSpace)));
                    func.addFirst(new StoreInst("sw", regs.getPhyReg("t" + i), regs.getPhyReg("sp"), new Imm(totalSpace)));
                } else {
                    PhysicReg tmp1 = getIdleReg();
                    func.addFirst(new StoreInst("sw", regs.getPhyReg("t" + i), tmp1, new Imm(0)));
                    func.addFirst(new BinaryInst("add", tmp1, tmp1, regs.getPhyReg("sp")));
                    func.addFirst(new LiInst(tmp1, new Imm(totalSpace)));
                    setIdle(tmp1);
                    PhysicReg tmp2 = getIdleReg();
                    func.addLast(new LiInst(tmp2, new Imm(totalSpace)));
                    func.addLast(new BinaryInst("add", tmp2, tmp2, regs.getPhyReg("sp")));
                    func.addLast(new LoadInst("lw", regs.getPhyReg("t" + i), tmp2, new Imm(0)));
                }
                totalSpace += 4;
            }
            int stackSpace = (totalSpace + 15) / 16 * 16;
            ITypeInst in = new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(stackSpace));
            for (var retBlock: retInsts) {
                for (int k = retBlock.getSecond(); k < retBlock.getFirst().inst.size(); k++) {
                    if (retBlock.getFirst().inst.get(k) instanceof Assembly.Inst.RetInst) {
                        if (stackSpace < 2048) retBlock.getFirst().inst.add(k, in);
                        else {
                            PhysicReg tmp = getIdleReg();
                            retBlock.getFirst().inst.add(k, new BinaryInst("add", regs.getPhyReg("sp"), regs.getPhyReg("sp"), tmp));
                            retBlock.getFirst().inst.add(k, new LiInst(tmp, new Imm(stackSpace)));
                            setIdle(tmp);
                        }
                        break;
                    }
                }
            }
            if (stackSpace < 2048) func.addFirst(new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(-stackSpace)));
            else {
                PhysicReg tmp = getIdleReg();
                func.addFirst(new LiInst(tmp, new Imm(-stackSpace)));
                func.addFirst(new BinaryInst("add", regs.getPhyReg("sp"), regs.getPhyReg("sp"), tmp));

                setIdle(tmp);
            }
            func.addFirst(new MvInst(regs.getPhyReg("sp"), regs.getPhyReg("s0")));
        }
    }

    public void allocate(ASMInst it) {
        PhysicReg phyRs2 = null, phyRs1 = null, phyRd = null;
        if (it.rs1 instanceof VirtualReg) {
            int location = ((VirtualReg) it.rs1).index * 4 + allocSpace;
            phyRs1 = getIdleReg();
            if (location < 2048) allocateInsts.add(new LoadInst("lw", phyRs1, regs.getPhyReg("sp"), new Imm(location)));
            else {
                PhysicReg tmp = getIdleReg();
                allocateInsts.add(new LiInst(tmp, new Imm(location)));
                allocateInsts.add(new BinaryInst("add", tmp, tmp, regs.getPhyReg("sp")));
                allocateInsts.add(new LoadInst("lw", phyRs1, tmp, new Imm(0)));
                setIdle(tmp);
            }
            it.rs1 = phyRs1;
        }
        if (it.rs2 instanceof VirtualReg) {
            int location = ((VirtualReg) it.rs2).index * 4 + allocSpace;
            phyRs2 = getIdleReg();
            if (location < 2048) allocateInsts.add(new LoadInst("lw", phyRs2, regs.getPhyReg("sp"), new Imm(location)));
            else {
                PhysicReg tmp = getIdleReg();
                allocateInsts.add(new LiInst(tmp, new Imm(location)));
                allocateInsts.add(new BinaryInst("add", tmp, tmp, regs.getPhyReg("sp")));
                allocateInsts.add(new LoadInst("lw", phyRs2, tmp, new Imm(0)));
                setIdle(tmp);
            }
            it.rs2 = phyRs2;
        }
        checkInst(it);
        if (it.rd instanceof VirtualReg) {
            int location = ((VirtualReg) it.rd).index * 4 + allocSpace;
            phyRd = getIdleReg();
            if (location < 2048) allocateInsts.add(new StoreInst("sw", phyRd, regs.getPhyReg("sp"), new Imm(location)));
            else {
                PhysicReg tmp = getIdleReg();
                allocateInsts.add(new LiInst(tmp, new Imm(location)));
                allocateInsts.add(new BinaryInst("add", tmp, tmp, regs.getPhyReg("sp")));
                allocateInsts.add(new StoreInst("sw", phyRd, tmp, new Imm(0)));
                setIdle(tmp);
            }
            it.rd = phyRd;
        }
        setIdle(phyRs1);
        setIdle(phyRs2);
        setIdle(phyRd);
    }

    public PhysicReg getIdleReg() {
        if (idleReg.isEmpty()) {
            usedRegNum++;
            if (usedRegNum == 6) throw new RuntimeException("no available register");
            return regs.getPhyReg("t" + (usedRegNum - 1));
        } else {
            return regs.getPhyReg("t" + idleReg.removeFirst());
        }
    }
    public void setIdle(PhysicReg reg) {
        if (reg == null) return;
        int num = Integer.parseInt(reg.name.substring(1));
        idleReg.push(num);
    }

    @Override
    public String toString() {
        return program.toString();
    }
    public void checkInst(ASMInst inst) {
        if (inst instanceof ITypeInst && (((ITypeInst) inst).imm.value > 2047 || ((ITypeInst) inst).imm.value < -2048)) {
            PhysicReg tmp = getIdleReg();
            allocateInsts.add(new LiInst(tmp, ((ITypeInst) inst).imm));
            allocateInsts.add(new BinaryInst("add", inst.rd, inst.rs1, tmp));
            setIdle(tmp);
        } else {
            allocateInsts.add(inst);
        }
    }
}
