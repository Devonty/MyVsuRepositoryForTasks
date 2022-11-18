package realAtt2;

public class task3 {
    public static int solve(int n) {
        int twoInPow = 1;
        int countNum = 1;
        int countNowTmp = countNum;
        for (int i =0; i <= n;i++){
            if (countNowTmp == 0){
                countNowTmp = ++countNum;
                twoInPow *= 2;
            }

            countNowTmp--;
        }
        return twoInPow;
    }
}
