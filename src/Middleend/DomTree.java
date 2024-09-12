package Middleend;

import MIR.irEntity.function;
import MIR.utils.block;
import utils.Scope.GlobalScope;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// L-T Algorithm
public class DomTree {
    ArrayList<block> poList = null;
    HashSet<block> visited = null;
    GlobalScope globalScope = null;
    public DomTree(GlobalScope globalScope) {
        this.globalScope = globalScope;
    }

    public void build() {
        for (Map.Entry<String, function> entry: globalScope.irFunction.entrySet()) {
            work(entry.getValue());
        }
    }

    public void work(function func) {
        poList = new ArrayList<>();
        visited = new HashSet<>();
        block firstBlk = func.blocks.getFirst();
        getRpo(firstBlk);
        firstBlk.iDom = firstBlk;
        getIDom();;
        firstBlk.iDom = null;
        getDfDc();
    }

    public void getIDom() {
        boolean changed = true;
        while(changed) {
            changed = false;
            for (int i = poList.size() - 2; i >= 0; --i) {
                block obj = poList.get(i);
                block copy = null;
                for (var prev: obj.prev) {
                    if (prev.iDom != null) copy = intersect(prev, copy);
                    else if (copy == null) copy = prev;
                }
                if (copy != obj.iDom) {
                    obj.iDom = copy;
                    changed = true;
                }
            }
        }
    }

    public void getDfDc() {
        for (var it: poList) {
            if (it.iDom != null) it.iDom.dc.add(it);
            if (it.prev.size() >= 2) {
                for (var pre: it.prev) {
                    var copy = pre;
                    while (copy != it.iDom) {
                        copy.df.add(it);
                        copy = copy.iDom;
                    }
                }
            }
        }
    }

    void getRpo(block target) {
        visited.add(target);
        for (var suc: target.next) {
            if (!visited.contains(suc)) getRpo(suc);
        }
        poList.add(target);
    }
    block intersect(block lhs, block rhs) {
        if (rhs == null) return lhs;
        while (lhs != rhs) {
            while (poList.indexOf(lhs) < poList.indexOf(rhs)) lhs = lhs.iDom;
            while (poList.indexOf(lhs) > poList.indexOf(rhs)) rhs = rhs.iDom;
        }
        return lhs;
    }

}
