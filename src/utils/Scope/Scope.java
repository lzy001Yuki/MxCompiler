package utils.Scope;
import utils.DataType;
import utils.Error;
import utils.Position;

import java.util.HashMap;

public class Scope {
    protected HashMap<String, DataType> members;
    protected Scope parentScope = null;
    protected boolean isLoopScope;
    protected String className = null;
    public Scope(Scope parent) {
        this.parentScope = parent;
        this.members = new HashMap<>();
        if (parent != null)  this.className = parent.className;
    }
    public Scope(Scope parent, boolean ils) {
        this.parentScope = parent;
        if (parent != null)  this.className = parent.className;
        this.members = new HashMap<>();
        this.isLoopScope = ils;
    }
    public Scope getParentScope() {return parentScope;}

    void addVar(String name, Position pos, DataType type) {
        if (members.containsKey(name)) throw new Error("SemanticError", "variable name " + name + " redefined", pos);
        members.put(name, type);
    }

    public DataType findVarGlobally(String name) {
        if (members.containsKey(name)) return members.get(name);
        if (parentScope == null) return null;
        else return parentScope.findVarGlobally(name);
    }

    public boolean checkVarPartially(String name) {
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

}
