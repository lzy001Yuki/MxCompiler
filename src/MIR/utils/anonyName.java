package MIR.utils;

public class anonyName {
    public static int cnt = 0;
    public int idx = 0;
    public String name;
    public anonyName() {
        name = "_" + idx;
        idx = cnt;
        cnt++;
    }
    public String getName() {return name;}
}
