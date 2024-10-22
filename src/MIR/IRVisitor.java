package MIR;

import MIR.Instruction.*;
import MIR.irEntity.function;
import MIR.utils.block;
import Middleend.Inline;
import utils.Scope.GlobalScope;

public interface IRVisitor {
    public void visit(GlobalScope it);
    public void visit(block it);
    public void visit(function it);
    public void visit(AllocaInst it);
    public void visit(BasicInst it);
    public void visit(BinaryInst it);
    public void visit(BrInst it);
    public void visit(CallInst it);
    public void visit(GetelementInst it);
    public void visit(IcmpInst it);
    public void visit(LoadInst it);
    public void visit(PhiInst it);
    public void visit(RetInst it);
    public void visit(StoreInst it);
    public void visit(MoveInst it);
    public void visit(CommentInst it);
    public void visit(InlineInst it);
}
