package Assembly;

import Assembly.Inst.*;
import Assembly.Inst.BinaryInst;
import Assembly.Inst.CallInst;
import Assembly.Inst.LoadInst;
import Assembly.Inst.RetInst;
import Assembly.Inst.StoreInst;
import Assembly.Operand.*;
import Assembly.utils.RegStore;
import MIR.IRVisitor;
import MIR.Instruction.*;
import MIR.irEntity.function;
import MIR.utils.block;
import com.sun.jdi.VoidType;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import MIR.irEntity.*;
import MIR.type.*;

public class InstSelector implements IRVisitor {
    public Scope globalScope;
    public ASMBlock curBlock;
    public ASMFunction curFunc;
    public int funcNum = 0;
    public RegStore regs;
    public ASMProgram asmProgram;
    public HashMap<String, ASMBlock> blockMap;
    public int cnt = 0;

    public InstSelector(GlobalScope global) {
        globalScope = global;
        asmProgram = new ASMProgram();
        regs = new RegStore();
        blockMap = new HashMap<>();
    }
    @Override
    public void visit(GlobalScope it){
        for (Map.Entry<String, Ptr> entry: it.pointers.entrySet()) {
            asmProgram.data.add(new varGlobal(entry.getKey(), (globalVar) entry.getValue()));
        }
        for (var cString: it.globalString) {
            asmProgram.rodata.add(new stringGlobal(cString.irName, cString.value));
        }
        for (Map.Entry<String, function> entry: it.irFunction.entrySet()) {
            funcNum++;
            curFunc = new ASMFunction(entry.getValue().irName);
            asmProgram.text.add(curFunc);
            entry.getValue().accept(this);
            curFunc.virtualNum = VirtualReg.cnt;
        }
    }
    @Override
    public void visit(block it){
        for (var iter: it.phiInsts) {
            iter.accept(this);
        }
        for (var iter: it.instructions) {
            iter.accept(this);
        }

    }
    @Override
    public void visit(function it){
        VirtualReg.cnt = 0;
        for (var iter: it.blocks) {
            ASMBlock b = new ASMBlock(getLabel() + iter.lab);
            blockMap.put(getLabel() + iter.lab, b);
            curFunc.addBlock(b);
        }
        for (int i = 0; i < it.paraList.size(); i++) {
            if (i < 7) it.paraList.get(i).operand = regs.getPhyReg("a" + i);
            else it.paraList.get(i).operand = regs.getPhyReg("s0");
            Reg paraCopy = new VirtualReg();
            ASMBlock entryBlock = curFunc.blocks.getFirst();
            entryBlock.addInst(new MvInst((Reg)it.paraList.get(i).operand, paraCopy));
            it.paraList.get(i).operand = paraCopy;
        }
        for (var iter: it.blocks) {
            curBlock = blockMap.get(getLabel() + iter.lab);
            iter.accept(this);
        }
    }
    @Override
    public void visit(AllocaInst it){
        curBlock.addInst(new Comment(it.toString()));
        it.result.operand = new VirtualReg();
        curBlock.addInst(new ITypeInst("addi", regs.getPhyReg("sp"), (VirtualReg) it.result.operand, new Imm(curFunc.allocSpace)));
        curFunc.allocSpace += 4;
    }
    @Override
    public void visit(BasicInst it){}
    @Override
    public void visit(MIR.Instruction.BinaryInst it){
        curBlock.addInst(new Comment(it.toString()));
        it.result.operand = new VirtualReg();
        Reg lhs, rhs;
        lhs = getVirReg(it.op1);
        rhs = getVirReg(it.op2);
        switch (it.op) {
            case "add" -> curBlock.addInst(new BinaryInst("add", (Reg) it.result.operand, lhs, rhs));
            case "sub" -> curBlock.addInst(new BinaryInst("sub", (Reg) it.result.operand, lhs, rhs));
            case "mul" -> curBlock.addInst(new BinaryInst("mul", (Reg) it.result.operand, lhs, rhs));
            case "sdiv" -> curBlock.addInst(new BinaryInst("div", (Reg) it.result.operand, lhs, rhs));
            case "srem" -> curBlock.addInst(new BinaryInst("rem", (Reg) it.result.operand, lhs, rhs));
            case "shl" -> curBlock.addInst(new BinaryInst("sll", (Reg) it.result.operand, lhs, rhs));
            case "ashr" -> curBlock.addInst(new BinaryInst("sra", (Reg) it.result.operand, lhs, rhs));
            case "and" -> curBlock.addInst(new BinaryInst("and", (Reg) it.result.operand, lhs, rhs));
            case "or" -> curBlock.addInst(new BinaryInst("or", (Reg) it.result.operand, lhs, rhs));
            case "xor" -> curBlock.addInst(new BinaryInst("xor", (Reg) it.result.operand, lhs, rhs));
        }
    }
    @Override
    public void visit(BrInst it){
        curBlock.addInst(new Comment(it.toString()));
        Reg tmp = null;
        Label label = null;
        if (it.iffalse != null) {
            tmp = new VirtualReg();
            curBlock.addInst(new LaInst(tmp, getLabel() + it.iffalse));
            label = new Label(getLabel() + "skip" + cnt);
            cnt++;
            curBlock.addInst(new BeqzInst(getVirReg(it.cond), label.symbol));
        }
        curBlock.addInst(new JumpInst(getLabel() + it.iftrue));
        link(curBlock.label, getLabel() + it.iftrue);
        if (it.iffalse != null) {
            curBlock.addInst(label);
            curBlock.addInst(new JrInst(tmp));
            link(curBlock.label, getLabel() + it.iffalse);
        }
    }
    @Override
    public void visit(MIR.Instruction.CallInst it){
        int reserveSpace = 0;
        curBlock.addInst(new Comment(it.toString()));
        // sp-4 store return address
        reserveSpace -= 4;
        curBlock.addInst(new StoreInst("sw", regs.getPhyReg("ra"), regs.getPhyReg("sp"), new Imm(reserveSpace)));
        for (int i = 0; i < it.para.size(); i++) {
            if (i < 8) {
                Reg paraReg = getVirReg(it.para.get(i));
                curBlock.addInst(new MvInst(paraReg, regs.getPhyReg("a" + i)));
            } else {
                reserveSpace -= 4;
                Reg paraReg = getVirReg(it.para.get(i));
                curBlock.addInst(new StoreInst("sw", paraReg, regs.getPhyReg("sp"), new Imm(reserveSpace)));
            }
        }
        curBlock.addInst(new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(reserveSpace)));
        curBlock.addInst(new CallInst(it.funcName));
        curBlock.addInst(new ITypeInst("addi", regs.getPhyReg("sp"), regs.getPhyReg("sp"), new Imm(-reserveSpace)));
        if (!(it.ret.type instanceof voidType)) {
            it.ret.operand = new VirtualReg();
            curBlock.addInst(new MvInst((regs.getPhyReg("a0")), (Reg) it.ret.operand));
        }
        curBlock.addInst(new LoadInst("lw", regs.getPhyReg("ra"), regs.getPhyReg("sp"), new Imm(-4)));
    }
    @Override
    public void visit(GetelementInst it){
        curBlock.addInst(new Comment(it.toString()));
        Reg tmp = null;
        it.result.operand = new VirtualReg();
        if (it.index.getLast().isConstValue()) {
            tmp = new VirtualReg();
            curBlock.addInst(new LiInst(tmp, new Imm(it.index.getLast())));
        } else tmp = (Reg) it.index.getLast().operand;
        Reg tmp1 = new VirtualReg();
        curBlock.addInst(new ITypeInst("slli", tmp, tmp1, new Imm(2)));
        curBlock.addInst(new BinaryInst("add", (Reg) it.result.operand, tmp1, (Reg)it.ptrVal.operand));
    }
    @Override
    public void visit(IcmpInst it){
        curBlock.addInst(new Comment(it.toString()));
        it.result.operand = new VirtualReg();
        Reg lhs, rhs;
        lhs = getVirReg(it.op1);
        rhs = getVirReg(it.op2);
        switch (it.op) {
            case "slt" -> curBlock.addInst(new BinaryInst("slt", (Reg) it.result.operand, lhs, rhs));
            case "sgt" -> curBlock.addInst(new BinaryInst("slt", (Reg) it.result.operand, rhs, lhs));
            case "eq" -> {
                curBlock.addInst(new BinaryInst("xor", (Reg) it.result.operand, lhs, rhs));
                curBlock.addInst(new BinaryInst("seqz", (Reg) it.result.operand, (Reg) it.result.operand, null));
            }
            case "ne" -> {
                curBlock.addInst(new BinaryInst("xor", (Reg) it.result.operand, lhs, rhs));
                curBlock.addInst(new BinaryInst("snez", (Reg) it.result.operand, (Reg) it.result.operand, null));
            }
            case "sle" -> {
                Reg lessReg = new VirtualReg();
                Reg equalReg = new VirtualReg();
                curBlock.addInst(new BinaryInst("sub", lessReg, lhs, rhs));
                curBlock.addInst(new BinaryInst("seqz", equalReg, lessReg, null));
                curBlock.addInst(new BinaryInst("slt", lessReg, lessReg, regs.getPhyReg("zero")));
                curBlock.addInst(new BinaryInst("or", (Reg) it.result.operand, lessReg, equalReg));
            }
            case "sge" -> {
                Reg lessReg = new VirtualReg();
                Reg equalReg = new VirtualReg();
                curBlock.addInst(new BinaryInst("sub", lessReg, lhs, rhs));
                curBlock.addInst(new BinaryInst("seqz", equalReg, lessReg, null));
                curBlock.addInst(new BinaryInst("slt", lessReg, regs.getPhyReg("zero"), lessReg));
                curBlock.addInst(new BinaryInst("or", (Reg) it.result.operand, lessReg, equalReg));
            }
        }
    }
    @Override
    public void visit(MIR.Instruction.LoadInst it){
        curBlock.addInst(new Comment(it.toString()));
        it.result.operand = new VirtualReg();
        Reg pointerReg = (Reg) it.pointer.operand;
        if (it.pointer instanceof globalVar || it.pointer instanceof constString) {
            pointerReg = new VirtualReg();
            curBlock.addInst(new LaInst(pointerReg, it.pointer.irName));
        }
        curBlock.addInst(new LoadInst("lw", (Reg) it.result.operand, pointerReg, new Imm(0)));
    }
    // currently no critical edge
    @Override
    public void visit(PhiInst it){

        // phi elimination instead
        curBlock.addInst(new Comment(it.toString()));
        it.result.operand = new VirtualReg();
        ASMBlock preBlock1 = null, preBlock2 = null;
        for (int i = curFunc.blocks.size() - 1; i >= 0; i--) {
            if (curFunc.blocks.get(i).label.equals(getLabel() + it.jump.get(1).getSecond())) preBlock2 = curFunc.blocks.get(i);
            if (curFunc.blocks.get(i).label.equals(getLabel() + it.jump.get(0).getSecond())) {
                preBlock1 = curFunc.blocks.get(i);
                break;
            }
        }
        Reg mid = new VirtualReg();
        Reg newReg1 = judgeReg(it.jump.get(0).getFirst());
        Reg newReg2 = judgeReg(it.jump.get(1).getFirst());
        if (preBlock1.inst.isEmpty()) preBlock1.inst.add(new ITypeInst("addi", regs.getPhyReg("sp"), mid, new Imm(curFunc.allocSpace)));
        else preBlock1.inst.add(preBlock1.inst.size() - 1, new ITypeInst("addi", regs.getPhyReg("sp"), mid, new Imm(curFunc.allocSpace)));
        if (preBlock2.inst.isEmpty()) preBlock2.inst.add(new ITypeInst("addi", regs.getPhyReg("sp"), mid, new Imm(curFunc.allocSpace)));
        else preBlock2.inst.add(preBlock2.inst.size() - 1, new ITypeInst("addi", regs.getPhyReg("sp"), mid, new Imm(curFunc.allocSpace)));
        addVirReg(it.jump.get(1).getFirst(), newReg2, preBlock2);
        addVirReg(it.jump.get(0).getFirst(), newReg1, preBlock1);
        preBlock2.inst.add(preBlock2.inst.size() - 1, new StoreInst("sw", newReg2, mid, new Imm(0)));
        preBlock1.inst.add(preBlock1.inst.size() - 1, new StoreInst("sw", newReg1, mid, new Imm(0)));
        curFunc.allocSpace += 4;
        Reg mid1 = new VirtualReg();
        curBlock.addInst(new LoadInst("lw", mid1, mid, new Imm(0)));
        curBlock.addInst(new MvInst(mid1, (Reg) it.result.operand));
    }
    @Override
    public void visit(MIR.Instruction.RetInst it){
        curBlock.addInst(new Comment(it.toString()));
        if (it.retType.type instanceof voidType) {
            curBlock.addInst(new RetInst());
            return;
        }
        Reg dest = getVirReg(it.retType);
        curBlock.addInst(new MvInst(dest, regs.getPhyReg("a0")));
        curBlock.addInst(new RetInst());
    }
    @Override
    public void visit(MIR.Instruction.StoreInst it){
        curBlock.addInst(new Comment(it.toString()));
        Reg dest = getVirReg(it.value);
        Reg pointerReg = (Reg) it.pointer.operand;
        if (it.pointer instanceof globalVar || it.pointer instanceof constString) {
            pointerReg = new VirtualReg();
            curBlock.addInst(new LaInst(pointerReg, it.pointer.irName));
        }
        curBlock.addInst(new StoreInst("sw", dest, pointerReg, new Imm(0)));
    }

    @Override
    public void visit(MIR.Instruction.MoveInst it) {
        curBlock.addInst(new Comment(it.toString()));
        if (it.dest.operand == null) it.dest.operand = new VirtualReg();
        Reg src = getVirReg(it.src);
        curBlock.addInst(new MvInst(src, (Reg)it.dest.operand));
    }

    private String getLabel() {return ".Lfunc" + funcNum + ".";}

    private Reg getVirReg(Entity it) {
        if (it.isConstValue()) {
            Reg tmp = new VirtualReg();
            curBlock.addInst(new LiInst(tmp, new Imm(it)));
            return tmp;
        } else if (it instanceof globalVar || it instanceof constString) {
            Reg tmp = new VirtualReg();
            curBlock.addInst(new LaInst(tmp, it.irName));
            return tmp;
        } else if (it instanceof constNull) {
            Reg tmp = new VirtualReg();
            curBlock.addInst(new LiInst(tmp, new Imm(0)));
            return tmp;
        } else return (Reg) it.operand;
    }

    private Reg judgeReg(Entity it) {
        if (it.isConstValue() || it instanceof globalVar || it instanceof constString || it instanceof constNull) {
            return new VirtualReg();
        } else return (Reg) it.operand;
    }

    private void addVirReg(Entity it, Reg reg, ASMBlock block) {
        if (it.isConstValue()) {
            block.inst.add(block.inst.size() - 1, new LiInst(reg, new Imm(it)));
        } else if (it instanceof globalVar || it instanceof constString) {
            block.inst.add(block.inst.size() - 1, new LaInst(reg, it.irName));
        } else if (it instanceof constNull) block.inst.add(block.inst.size() - 1, new LiInst(reg, new Imm(0)));
    }

    private void link(String pre, String nxt) {
        ASMBlock first = blockMap.get(pre);
        ASMBlock second = blockMap.get(nxt);
        first.next.add(second);
        second.prev.add(first);
    }

}
