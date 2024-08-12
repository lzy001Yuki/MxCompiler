import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import utils.Error;
import AST.ProgramNode;
import frontEnd.*;
import parser.MxParser;
import parser.MxLexer;
import utils.MxErrorListener;
import utils.Scope.GlobalScope;
// fail: misc condition.mx??
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        try{
            GlobalScope globalScope = new GlobalScope();
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            MxParser.ProgramContext parseTreeRoot = parser.program();
            ASTBuilder builder = new ASTBuilder();
            ProgramNode root = (ProgramNode) builder.visit(parseTreeRoot);
            SymbolCollector collector = new SymbolCollector(globalScope);
            collector.visit(root);
            SemanticChecker checker = new SemanticChecker(globalScope);
            checker.visit(root);
        } catch (Error error) {
            System.err.println(error.toString());
            throw new RuntimeException();
        }
        System.exit(0);
    }
}