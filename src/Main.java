import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import utils.Error;
import AST.ProgramNode;
import frontEnd.*;
import parser.MxParser;
import parser.MxLexer;
import utils.MxErrorListener;

public class Main {
    public static void main(String[] args) throws Exception {
        String name = "test.txt";
        InputStream input = new FileInputStream(name);
        try{
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            MxParser.ProgramContext parseTreeRoot = parser.program();
            ASTBuilder builder = new ASTBuilder();
            ProgramNode root = (ProgramNode) builder.visit(parseTreeRoot);
        } catch (Error err) {
            throw new RuntimeException();
        }
    }
}