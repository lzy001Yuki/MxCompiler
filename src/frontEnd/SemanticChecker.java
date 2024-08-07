package frontEnd;

import AST.ASTVisitor;
import utils.Scope.GlobalScope;
import utils.Scope.Scope;

public class SemanticChecker implements ASTVisitor {
    Scope currentScope;
    GlobalScope globalScope;
}
