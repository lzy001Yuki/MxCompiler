package MIR.utils;

public class label {
    public static int cnt = 0;
    public String labelName;
    public int idx = 0;
    public label(String str) {
        if (str.equals("entry")) labelName = "entry";
        else {
            labelName = str;
            idx = cnt;
            cnt++;
        }
    }
    @Override
    public String toString() {
        if (labelName.equals("entry")) return labelName;
        return "%"+labelName + idx;
    }
}
