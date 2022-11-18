package stuff;

import java.util.Scanner;

public class task_5_16 {
    public static void main(String[] args) {
        int s;
        Scanner scanner = new Scanner(System.in);

        s = scanner.nextInt();

        drawShape(s);


    }

    public static String repeat(String with, int count) {
        // умножает строки
        return new String(new char[count]).replace("\0", with);
    }


    public static void drawShape(int s) {
        for (int i = 0; i < s / 2; i++) {
            String line = repeat("|", i) + '*' + repeat("-", (s - 2 - i * 2)) + '*' + repeat("|", i);
            System.out.println(line);
        }

        if (s % 2 == 1) {
            String line = repeat("|", s / 2) + '*' + repeat("|", s / 2);
            System.out.println(line);
        }

        for (int i = 2; i >= 0; i--) {
            String line = repeat("|", i) + '*' + repeat("-", (s - 2 - i * 2)) + '*' + repeat("|", i);
            System.out.println(line);
        }
    }

}
