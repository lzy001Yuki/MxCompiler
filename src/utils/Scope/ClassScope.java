package utils.Scope;

import java.util.HashMap;
import java.util.Map;

import AST.Def.*;
import utils.Error;

public class ClassScope extends Scope {
    HashMap<String, funcDefNode> funcMember;
    public ClassScope(Scope parent, classDefNode def) {
        super(parent);
        this.className = def.className;
        this.funcMember = new HashMap<>(def.funcMap);
        for (Map.Entry<String, varDefAtomNode> entry: def.varMap.entrySet()) {
            if (this.members.containsKey(entry.getKey())) throw new Error("SemanticError", "variable " + entry.getKey() + " redefined", entry.getValue().pos);
            this.members.put(entry.getKey(), entry.getValue().type);
        }
    }
}
