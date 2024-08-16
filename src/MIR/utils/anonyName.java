package MIR.utils;

public class anonyName {
    public static int cnt = 0;
    public String name;
    public anonyName() {}
    public String getName() {
        name = "_" + cnt;
        cnt++;
        return name;
    }
}
