package MIR.Instruction;

import MIR.IRVisitor;
import MIR.irEntity.Entity;

import java.util.ArrayList;

public class CommentInst extends Inst{
    public String comment;
    public CommentInst(String comment) {
        this.comment = comment;
    }
    @Override
    public Inst getCopy() {return new CommentInst(comment);}
    @Override
    public String toString() {
        return comment;
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
