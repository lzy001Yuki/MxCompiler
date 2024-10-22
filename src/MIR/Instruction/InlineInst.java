package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;
import MIR.utils.block;

import java.util.ArrayList;

public class InlineInst extends Inst{
    public ArrayList<block> blocks;
    public String retLab;
    public InlineInst(String lab) {
        blocks = new ArrayList<>();
        retLab = lab;
    }
    @Override
    public Inst getCopy() {
        InlineInst newInst = new InlineInst(retLab);
        newInst.blocks.addAll(blocks);
        return newInst;
    }

    public void addBlock(block newBlk) {
        blocks.add(newBlk);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("#InlineInsts:  \n");
        for (var blk: blocks) {
            builder.append(blk).append("\n");
        }
        return builder.toString();
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ArrayList<Entity> getUses(){
        return new ArrayList<>();}
    @Override
    public Entity getDef(){return null;}
    @Override
    public void replaceOperand(Entity old, Entity replace) {}
    @Override
    public Entity getConst() {
        return null;
    }

    @Override
    public void entity2const(Entity old, Entity val) {}

}
