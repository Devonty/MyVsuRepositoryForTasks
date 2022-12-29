package stuff.testAtt2;

public class task2 {
    public static double solve(double x, int n) {
        double xInPow = x;
        double sum = 0;

        for(int i = 1; i <= n; i++){
            sum += xInPow/(x - i);

            xInPow *= x;
        }
        return sum;
    }
}
