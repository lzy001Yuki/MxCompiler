package Middleend;

import MIR.IRBuilder;
import MIR.Instruction.CallInst;
import MIR.irEntity.function;
import MIR.utils.block;
import utils.Scope.GlobalScope;

import java.util.ArrayList;

public class Inline {
    GlobalScope globalScope;
    IRBuilder irBuilder;
    public Inline(GlobalScope globalScope, IRBuilder builder) {
        this.globalScope = globalScope;
        irBuilder = builder;
    }

    public void run() {
        // FuncCallGraph
        buildFCG();
        int inlineCnt = 3;
        Optimizer optimizer = new Optimizer(globalScope, irBuilder);
    }
    public void buildFCG() {
        for (var func: globalScope.irFunction.entrySet()) {
            collectInFunc(func.getValue());
        }
    }
    public void collectInFunc(function func) {
        for (var blk: func.blocks) {
            for (var inst: blk.instructions) {
                if (inst instanceof CallInst call) {
                    function inFunction = globalScope.irFunction.get(call.funcName);
                    if (inFunction != null) {
                        if (!func.inFunc.containsKey(inFunction)) {
                            ArrayList<block> bArray = new ArrayList<>();
                            bArray.add(blk);
                            func.inFunc.put(inFunction, bArray);
                        } else {
                            func.inFunc.get(inFunction).add(blk);
                            func.inFunc.put(inFunction,func.inFunc.get(inFunction));
                        }
                    }
                }
            }
        }
        // don't consider recursion

    }
}
