package utils.Scope;
import AST.Def.funcDefNode;
import MIR.irEntity.Entity;
import MIR.irEntity.Ptr;
import utils.DataType;
import utils.Error;
import utils.Position;

import java.util.HashMap;

public class Scope {
    public HashMap<String, DataType> members;
    public HashMap<String, Ptr> pointers;
    public Scope parentScope = null;
    public boolean isLoopScope;
    public String endLab, begLab;
    public boolean flag;
    public String className = null;
    public boolean returned = false;
    public Scope(Scope parent) {
        this.parentScope = parent;
        this.members = new HashMap<>();
        pointers = new HashMap<>();
        if (parent != null)  this.className = parent.className;
    }
    public Scope(Scope parent, boolean ils) {
        this.parentScope = parent;
        if (parent != null)  this.className = parent.className;
        this.members = new HashMap<>();
        pointers = new HashMap<>();
        this.isLoopScope = ils;
    }
    public Scope getParentScope() {return parentScope;}

    public void addVar(String name, Position pos, DataType type) {
        if (members.containsKey(name)) throw new Error("SemanticError", "Multiple Definitions", pos);
        members.put(name, type);
    }

    public DataType findVarGlobally(String name) {
        if (members.containsKey(name)) return members.get(name);
        if (parentScope == null) return null;
        else return parentScope.findVarGlobally(name);
    }

    public funcDefNode findFuncGlobally(String name) {
        if (this.members.containsKey(name)) return null;
        if (this instanceof ClassScope) {
            if (((ClassScope) this).funcMember.containsKey(name)) return ((ClassScope) this).funcMember.get(name);
        } else if (this instanceof GlobalScope) {
            if (((GlobalScope) this).funcMember.containsKey(name)) return ((GlobalScope) this).funcMember.get(name);
        }
        if (parentScope == null) return null;
        else return parentScope.findFuncGlobally(name);
    }

    public boolean checkVarCurrent(String name) {
        return members.containsKey(name);
    }

    public boolean isInLoop() {
        if (isLoopScope) return true;
        if (parentScope == null) return false;
        return parentScope.isInLoop();
    }

    public String isInClass() {
        if (parentScope == null) return null;
        if (className != null) return className;
        return parentScope.isInClass();
    }
    public void addPtr(String name, Ptr ptr) {pointers.put(name, ptr);}
    public Entity getPtrGlobally(String name) {
        if (pointers.containsKey(name)) return pointers.get(name);
        else if (parentScope != null) return parentScope.getPtrGlobally(name);
        else return null;
    }
}
