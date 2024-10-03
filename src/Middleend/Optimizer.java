package Middleend;

import MIR.IRBuilder;
import utils.Scope.GlobalScope;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Optimizer {
    public GlobalScope globalScope;
    public IRBuilder irBuilder;
    public Optimizer(GlobalScope globalScope, IRBuilder builder) {
        this.globalScope = globalScope;
        irBuilder = builder;
    }
    public void run() {
        boolean opt = true;
        for (var func: globalScope.irFunction.entrySet()) {
            if (func.getValue().blocks.size() > 5000) opt = false;
        }
            CFGBuilder cfgBuilder = new CFGBuilder(globalScope);
            cfgBuilder.buildCFG();
            DomTree domTree = new DomTree(globalScope);
            domTree.build();
            Mem2Reg optimizer = new Mem2Reg(irBuilder);
            optimizer.run(globalScope);
//        PrintStream output = null;
//        try {
//            output = new PrintStream(new FileOutputStream("mem2reg.txt"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//       }
//        output.println(irBuilder);
        PhiElimination phiElimination = new PhiElimination(globalScope);
        phiElimination.run();
        if (opt) {
            DeadCodeElimination deadCodeElimination = new DeadCodeElimination(globalScope);
            deadCodeElimination.run();
        }
    }
}
