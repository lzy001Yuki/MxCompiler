package Assembly.utils;

import Assembly.Operand.PhysicReg;

import java.util.HashMap;

public class RegStore {
    private final HashMap<String, PhysicReg> regs = new HashMap<>();
    public RegStore() {
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
    }
    public PhysicReg getPhyReg(String name) {return regs.get(name);}
}
