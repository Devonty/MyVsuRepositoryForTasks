package realAtt2;

public class task5 {
    public static void solve(int h) {
        int w = 2 * h - 1;
        for (int i = 0; i < h; i++) {
            int jFirst = i + 1;
            int jSecond = (w - 1) - i - 1;

            for (int j = 0; j < w; j++) {
                int deltaFirst = j - jFirst;
                int deltaSecond = j - jSecond;


                if (i == h - 1){
                    // last_line
                    if (j == (w - 1) / 2) {
                        System.out.print('#');
                    }
                    else {
                        System.out.print(' ');
                    }
                } else if (-1 <= deltaFirst && deltaFirst <= 1) {
                    System.out.print('#');
                } else if (-1 <= deltaSecond && deltaSecond <= 1) {
                    System.out.print('#');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
