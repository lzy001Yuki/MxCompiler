package utils;
import utils.Position;
import utils.Error;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;

// recognize syntaxError
public class MxErrorListener extends BaseErrorListener{
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        throw new Error("SyntaxError", msg, new Position(line, charPositionInLine));
    }
}
