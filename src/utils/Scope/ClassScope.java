package utils.Scope;

import java.util.HashMap;
import java.util.Map;

import AST.Def.*;
import utils.Error;

public class ClassScope extends Scope {
    HashMap<String, funcDefNode> funcMember;
    public ClassScope(Scope parent) {
        super(parent);
    }
}
