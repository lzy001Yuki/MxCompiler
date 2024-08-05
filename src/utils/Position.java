package utils;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

// the position of the token
public class Position {
    private final int row, column;

    public Position(int row, int col) {
        this.row = row;
        this.column = col;
    }

    public Position(Token token) {
        //The line number on which the 1st character of this token was matched, line=1..n
        this.row = token.getLine();
        // The index of the first character of this token
        // relative to the beginning of the line at which it occurs, 0..n-1
        this.column = token.getCharPositionInLine();
    }

    public Position(TerminalNode terminal) {
        // refers to its Token
        this(terminal.getSymbol());
    }

    public Position(ParserRuleContext ctx) {
        // Get the initial token in this context that the rule recognizes
        this(ctx.getStart());
    }

    public int row() { return row; }

    public int col() {
        return column;
    }

    @Override
    public String toString() { return "(" + row + "," + column + ")"; }
}