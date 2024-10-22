package Middleend;

import MIR.IRBuilder;
import MIR.Instruction.*;
import MIR.irEntity.Entity;
import MIR.irEntity.function;
import MIR.type.voidType;
import MIR.utils.block;
import utils.Pair;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SimpleInline {
    public GlobalScope globalScope;
    public IRBuilder builder;
    public int inlineLimit = 4;
    public SimpleInline(GlobalScope globalScope, IRBuilder builder) {
        this.globalScope = globalScope;
        this.builder = builder;
    }
    public void run() {
        for (var func: globalScope.irFunction.entrySet()) {
            runOnFunc(func.getValue());
        }
        /*
        for (var func: globalScope.irFunction.entrySet()) {
            for (var inline: func.getValue().insertInline.entrySet()) {
                block curBlock = inline.getValue().getFirst();
                Inst nxtInst = curBlock.instructions.get(inline.getValue().getSecond() + 1);
                block firInlineBlk = inline.getKey().blocks.getFirst();
                int delIndex = inline.getValue().getSecond();
                curBlock.instructions.remove(delIndex);
                for (int i = 0; i < firInlineBlk.instructions.size(); i++) {
                    int ini = inline.getValue().getSecond();
                    curBlock.instructions.add(ini + i, firInlineBlk.instructions.get(i));
                }
                int curIdx = func.getValue().blocks.indexOf(curBlock);
                for (int i = 1; i < inline.getKey().blocks.size(); i++) {
                    curIdx++;
                    if (curIdx != -1) func.getValue().blocks.add(curIdx + 1, inline.getKey().blocks.get(i));
                }
                int nxtIndex = curBlock.instructions.indexOf(nxtInst);
                Iterator<Inst> iter = curBlock.instructions.listIterator(nxtIndex);
                block newBlk = new block(inline.getKey().retLab, func.getValue());
                while (iter.hasNext()) {
                    var itt = iter.next();
                    newBlk.addInst(itt);
                    iter.remove();
                }
                func.getValue().blocks.add(curIdx + 1, newBlk);
            }
        }*/
        for (var func: globalScope.irFunction.entrySet()) {
            ArrayList<block> newBlocks = new ArrayList<>();
            for (var blk: func.getValue().blocks) {
                if (!blk.hasInline) newBlocks.add(blk);
                else {
                    block curBlk = new block(blk.lab, blk.parentFunc);
                    for (Inst inst : blk.instructions) {
                        if (inst instanceof CallInst call && func.getValue().insertInline.containsKey(call)) {
                            InlineInst inline = func.getValue().insertInline.get(call);
                            block firInlineBlk = inline.blocks.getFirst();
                            for (var fInst : firInlineBlk.instructions) curBlk.addInst(fInst);
                            newBlocks.add(curBlk);
                            for (int i = 1; i < inline.blocks.size(); i++) {
                                newBlocks.add(inline.blocks.get(i));
                            }
                            curBlk = new block(inline.retLab, func.getValue());
                        } else curBlk.addInst(inst);
                    }
                    newBlocks.add(curBlk);
                }
            }
            func.getValue().blocks = newBlocks;
        }
    }
    public void runOnFunc(function func) {
        for (var blk : func.blocks) {
            for (int i = 0; i < blk.instructions.size(); i++) {
                var inst = blk.instructions.get(i);
                if (inst instanceof CallInst call) {
                    function inFunction = globalScope.irFunction.get(call.funcName);
                    if (inFunction != null && canInline(inFunction) && !func.equals(inFunction)) {
                        InlineInst inlined = getInline(call, inFunction, func);
                        func.insertInline.put(call, inlined);
                        //blk.instructions.set(i, inlined);
                        blk.hasInline = true;
                    }
                }
            }
        }
    }

    public InlineInst getInline(CallInst call, function func, function parent) {
        HashMap<Entity, Entity> replaceName = new HashMap<>();
        for (int i = 0; i < func.paraList.size(); i++) {
            replaceName.put(func.paraList.get(i), call.para.get(i));
        }
        String inlineNxt = builder.rename("inline_nxt_blk");
        String inlineLab = getLabel();
        InlineInst inline = new InlineInst(inlineNxt);
        for (var blk: func.blocks) {
            block inlineBlock = new block(inlineLab+ blk.lab, parent);
            for (var inst: blk.instructions) {
                var newInst = inst.getCopy();
                for (var use: newInst.getUses()) {
                    if (replaceName.containsKey(use)) newInst.replaceOperand(use, replaceName.get(use));
                }
                if (replaceName.containsKey(newInst.getDef())) newInst.replaceOperand(newInst.getDef(), replaceName.get(newInst.getDef()));
                if (newInst instanceof BrInst brInst) {
                    if (brInst.iffalse != null) brInst.iffalse = inlineLab + brInst.iffalse;
                    if (brInst.iftrue != null) brInst.iftrue = inlineLab + brInst.iftrue;
                }
                if (newInst instanceof RetInst retInst) {
                    if (!(retInst.retType.type instanceof voidType)) {
                        newInst = new MoveInst(call.ret, retInst.retType);
                        inlineBlock.addInst(newInst);
                    }
                    inlineBlock.addInst(new BrInst(null, inlineNxt, null));
                } else inlineBlock.addInst(newInst);
            }
            inline.addBlock(inlineBlock);
        }
        return inline;
    }

    public boolean canInline(function func) {
        return func.blocks.size() <= inlineLimit && !func.irName.equals("global_init");
    }

    public int inlineNum = 0;

    public String getLabel() {
        inlineNum++;
        return "inline" + inlineNum + ".";
    }
}
