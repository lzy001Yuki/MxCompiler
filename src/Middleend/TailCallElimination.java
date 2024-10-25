package Middleend;

import Assembly.utils.RegStore;
import MIR.Instruction.BrInst;
import MIR.Instruction.CallInst;
import MIR.Instruction.Inst;
import MIR.Instruction.MoveInst;
import MIR.irEntity.Entity;
import MIR.irEntity.function;
import MIR.type.voidType;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.Iterator;

public class TailCallElimination {
    public GlobalScope globalScope;
    public TailCallElimination(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }
    public void run() {
        for (var func: globalScope.irFunction.entrySet()) {
            runOnFunc(func.getValue());
        }
    }
    public void runOnFunc(function func) {
        for (var retBlk: func.retBlks) {
            //Inst it = null;
            //if (retBlk.instructions.size() >= 2) it = retBlk.instructions.get(retBlk.instructions.size() - 2);
            if (retBlk.retCall) {
                for (int itt = retBlk.instructions.size() - 1; itt >= 0; itt--) {
                    var in = retBlk.instructions.get(itt);
                    if (in instanceof CallInst call && call.funcName.equals(func.irName)) {
                        for (int j = itt; j < retBlk.instructions.size(); j++) {
                            var otherIn = retBlk.instructions.get(j);
                            otherIn.isDead = true;
                        }
                        for (int i = 0; i < func.paraList.size(); i++) {
                            Entity paraReg = new Entity(new voidType(), "paraReg__a" + i);
                            paraReg.operand = RegStore.regs.get("a" + i);
                            retBlk.instructions.add(new MoveInst(paraReg, call.para.get(i)));
                        }
                        retBlk.addInst(new BrInst(null, "entry", null));
                        break;
                    }
                }
            }
            retBlk.instructions.removeIf(inst->inst.isDead);
        }

    }
}
