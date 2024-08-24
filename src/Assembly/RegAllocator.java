package Assembly;

import Assembly.Inst.*;
import Assembly.Operand.Imm;
import Assembly.Operand.PhysicReg;
import Assembly.Operand.VirtualReg;
import Assembly.utils.RegStore;
import MIR.Instruction.Inst;

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
            allocSpace = func.allocSpace;
            usedRegNum = 0;
            for (var block: func.blocks) {
                for (var inst: block.inst) {
                    allocate(inst);
                }
                block.inst = allocateInsts;
                allocateInsts = new LinkedList<>();
            }
            int totalSpace = allocSpace + 4 * (func.virtualNum);
            if (totalSpace == 0) continue;
            for (int i = 0; i < usedRegNum; i++) {
                func.addLast(new LoadInst("lw", regs.getPhyReg("t" + i), regs.getPhyReg("sp"), new Imm(totalSpace)));
                func.addFirst(new StoreInst("sw", regs.getPhyReg("t" + i), regs.getPhyReg("sp"), new Imm(totalSpace)));
                totalSpace += 4;
            }
            int stackSpace = (totalSpace + 15) / 16 * 16;
            func.addLast(new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(stackSpace)));
            func.addFirst(new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(stackSpace)));
            func.addFirst(new MvInst(regs.getPhyReg("sp"), regs.getPhyReg("s0")));
        }
    }

    public void allocate(ASMInst it) {
        PhysicReg phyRs2 = null, phyRs1 = null, phyRd = null;
        if (it.rs1 instanceof VirtualReg) {
            int location = ((VirtualReg) it.rs1).index * 4 + allocSpace;
            phyRs1 = getIdleReg();
            allocateInsts.add(new LoadInst("lw", phyRs1, regs.getPhyReg("sp"), new Imm(location)));
            it.rs1 = phyRs1;
        }
        if (it.rs2 instanceof VirtualReg) {
            int location = ((VirtualReg) it.rs2).index * 4 + allocSpace;
            phyRs2 = getIdleReg();
            allocateInsts.add(new LoadInst("lw", phyRs2, regs.getPhyReg("sp"), new Imm(location)));
            it.rs2 = phyRs2;
        }
        allocateInsts.add(it);
        if (it.rd instanceof VirtualReg) {
            int location = ((VirtualReg) it.rd).index * 4 + allocSpace;
            phyRd = getIdleReg();
            allocateInsts.add(new StoreInst("sw", phyRd, regs.getPhyReg("sp"), new Imm(location)));
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
}
