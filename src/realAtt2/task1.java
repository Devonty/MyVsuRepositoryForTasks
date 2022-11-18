package realAtt2;

public class task1 {
    public static int solve(int v1, int v2, int v3) {
        int mn = v1;
        if (mn > v2) {
            mn = v2;
        }
        if (mn > v3) {
            mn = v3;
        }
        return v3 + v2 + v1 - mn;
    }
}
