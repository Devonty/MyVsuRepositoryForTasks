package stuff;

import java.util.Scanner;


public class lectia {
    public static void main(String[] args) {
        String sample1 = "abcd", sample2 = "aabbccdd", ans = "";
        int n = (new Scanner(System.in)).nextInt();
        while(n>0){

            ans += sample1.substring(0, Math.min(sample1.length(), n));
            n -= sample1.length();
            if (n < 0) break;

            ans += sample2.substring(0, Math.min(sample2.length(), n));
            n -= sample2.length();
        }
        System.out.println(ans);
    }
}
