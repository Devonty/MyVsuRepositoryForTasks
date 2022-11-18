package realAtt2;

public class task2 {
    public static double solve(double a, double b, int n) {
        double totalNow = 1;
        for (int i = 1; i <= n; i++) {
            totalNow = a - (i * b) * totalNow;
        }
        return totalNow;
    }
}
