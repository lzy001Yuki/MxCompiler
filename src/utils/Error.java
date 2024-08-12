package utils;
import utils.Position;

public class Error extends RuntimeException {
    private final Position pos;
    private final String msg;
    private final String errorType;

    public Error(String e, String str, Position p) {
        this.pos = p;
        this.msg = str;
        this.errorType = e;
    }

    @Override
    public String toString() {
        //return errorType + " : " + msg + " at " + pos.toString();
        return msg;
    }
}
