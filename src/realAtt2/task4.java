package realAtt2;

public class task4 {
    public static void solve(int n) {
        int countAlf = 1;
        int countAlfTmp = countAlf;

        boolean reverse = false;

        for (int i =1; i <= n;i++){
            // to 'a'
            if (countAlfTmp == 0){
                countAlfTmp = 2;
                reverse = true;
            }
            // from 'a'
            if (reverse && countAlfTmp > countAlf){
                countAlfTmp = ++countAlf;
                reverse = false;
                System.out.println();
            }

            int char_id = 'a' + countAlfTmp - 1;
            char char_now = (char) char_id;
            System.out.print(char_now);

            if (!reverse) {
                countAlfTmp--;
            }
            else {
                countAlfTmp++;
            }
        }
    }
}
