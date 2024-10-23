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
        CFGBuilder cfgBuilder = new CFGBuilder(globalScope);
        cfgBuilder.buildCFG();
        DomTree domTree = new DomTree(globalScope);
        domTree.build();
        Mem2Reg optimizer = new Mem2Reg(irBuilder);
        optimizer.run(globalScope);
        DeadCodeElimination deadCodeElimination = new DeadCodeElimination(globalScope);
        deadCodeElimination.run();

        PhiElimination phiElimination = new PhiElimination(globalScope);
        phiElimination.run();

        SCCP sccp = new SCCP(globalScope);
        sccp.run();
        PrintStream output = null;
//        try {
//            output = new PrintStream(new FileOutputStream("sccp.txt"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        output.println(irBuilder);
       Global2Local g2l = new Global2Local(irBuilder);
       g2l.run();

//        try {
//            output = new PrintStream(new FileOutputStream("mem2reg.txt"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        output.println(irBuilder);
        TailCallElimination tailCallElimination = new TailCallElimination(globalScope);
        tailCallElimination.run();
//        SimpleInline simpleInline = new SimpleInline(globalScope, irBuilder);
//        simpleInline.run();
    }
}
