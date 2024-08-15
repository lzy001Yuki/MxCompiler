package MIR.utils;

public class label {
    public static int cnt = 0;
    public String labelName;
    public int idx = 0;
    public label(String str) {
        labelName = str;
        idx = cnt;
        cnt++;
    }
    @Override
    public String toString() {
        return "%"+labelName + idx;
    }
}
