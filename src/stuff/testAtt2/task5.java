package stuff.testAtt2;

public class task5 {
    public static void solve(int h) {
        int w = h * 2 - 1;
        int jM = (w - 1) / 2;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == h - 1) {
                    if (j == 0 || j == jM || j == w - 1) {
                        System.out.print('*');
                    } else {
                        System.out.print('-');
                    }
                } else if (i == 0 && j == jM) {
                    System.out.print('*');
                } else if (j == jM) {
                    System.out.print('|');
                } else if (jM - j == i) {
                    System.out.print('/');
                } else if (jM - j == -i) {
                    System.out.print('\\');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}
