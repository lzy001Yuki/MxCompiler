package Assembly.utils;

import Assembly.Operand.PhysicReg;
import Assembly.Operand.Reg;

import java.util.HashMap;
import java.util.HashSet;

public class RegStore {
    public static HashMap<String, PhysicReg> regs = construct();
    private static HashMap<String, PhysicReg> construct() {
        HashMap<String, PhysicReg> regs = new HashMap<>();
        regs.put("zero", new PhysicReg("zero"));
        regs.put("ra", new PhysicReg("ra"));
        regs.put("sp", new PhysicReg("sp"));
        for (int i = 0; i < 7; i++) {
            regs.put("t" + i, new PhysicReg("t" + i));
        }
        for (int i = 0; i < 8; i++) {
            regs.put("a" + i, new PhysicReg("a" + i));
        }
        for (int i = 0; i < 12; i++) {
            regs.put("s" + i, new PhysicReg("s" + i));
        }
        return regs;
    }
    public PhysicReg getPhyReg(String name) {return regs.get(name);}
    public static HashSet<Reg> callerSave() {
        HashSet<Reg> caller = new HashSet<>();
        caller.add(regs.get("ra"));
        for (int i = 0; i < 7; i++) {
            caller.add(regs.get("t" + i));
        }
        for (int i = 0; i < 8; i++) {
            caller.add(regs.get("a" + i));
        }
        return caller;
    }

    public static HashSet<Reg> calleeSave() {
        HashSet<Reg> callee = new HashSet<>();
        for (int i = 0; i < 12; i++) {
            callee.add(regs.get("s" + i));
        }
        return callee;
    }
}
