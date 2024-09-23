package Assembly.Operand;

import Assembly.Inst.MvInst;

import java.util.HashSet;

public abstract class Reg extends Operand{
    public HashSet<Reg> adjList;
    public int degree = 0;
    public Reg alias = null;
    public Reg color = null;
    public int useNum = 0;
    public int defNum = 0;
    public boolean isTemp = false;
    public HashSet<MvInst> moveList;
    public void init() {
        adjList.clear();
        moveList.clear();
    }
}
