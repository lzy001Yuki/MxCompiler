import java.io.*;

import Assembly.InstSelector;
import Assembly.RegAllocator;
import MIR.IRBuilder;
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
// pass: e bubble floyd quick_sort selection_sort t1-60 t62-63 t66-70 t72-74
public class Main {
    public static void main(String[] args) throws Exception {
        InputStream input = System.in;
        //var input = new FileInputStream("Compiler-Design-Implementation/testcases/codegen/t3.mx");
        //var input = new FileInputStream("test.txt");
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
            IRBuilder irBuilder = new IRBuilder(globalScope);
            irBuilder.visit(root);
//            var output = new PrintStream(new FileOutputStream("irOutput.txt"));
//            output.println(irBuilder);
            InstSelector selector = new InstSelector(globalScope);
            selector.visit(globalScope);
//            var output2 = new PrintStream(new FileOutputStream("asm.txt"));
//            output2.println(selector.asmProgram);
            RegAllocator regAllocator = new RegAllocator(selector.asmProgram);
            regAllocator.run();
            //var output1 = new PrintStream(new FileOutputStream("tmp/test.s"));
            //output1.println(regAllocator);
            String filePath = "src/builtin/builtin.s";
            PrintStream outputStream = System.out;
            printFileToOutputStream(filePath, outputStream);
            System.out.println(regAllocator);
        } catch (Error error) {
            System.out.println(error.toString());
            System.exit(1);
        }
        System.exit(0);
    }
    public static void printFileToOutputStream(String filePath, PrintStream outputStream) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                outputStream.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}