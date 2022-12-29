package stuff.testAtt2;

public class task4 {
    public static void solve(int n) {
        int charCount = 1;
        int charCountTmp = charCount;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.print('-');
            } else {
                if (charCountTmp == 0){
                    charCountTmp = ++charCount;
                }

                int char_id = 'a' + charCount - 1;
                char char_now = (char) char_id;

                charCountTmp--;

                System.out.print(char_now);
            }
        }
    }
}
