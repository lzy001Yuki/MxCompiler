package Middleend;

import MIR.IRBuilder;
import utils.Scope.GlobalScope;

public class Optimizer {
    public GlobalScope globalScope;
    public IRBuilder irBuilder;
    public Optimizer(GlobalScope globalScope, IRBuilder builder) {
        this.globalScope = globalScope;
        irBuilder = builder;
    }
    public void run() {
        CFGBuilder cfgBuilder = new CFGBuilder(globalScope);
        cfgBuilder.buildCFG();
        DomTree domTree = new DomTree(globalScope);
        domTree.build();
        Mem2Reg optimizer = new Mem2Reg(irBuilder);
        optimizer.run(globalScope);
        PhiElimination phiElimination = new PhiElimination(globalScope);
        phiElimination.run();
    }
}
