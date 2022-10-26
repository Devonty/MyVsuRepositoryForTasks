import java.util.Locale;
import java.util.Scanner;

public class task_2_18 {
    static boolean flagI = false, flagII = false, flagIII = false, flagIV = false;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        // VAR
        Scanner scanner = new Scanner(System.in);
        double x1, x2, x3, y1, y2, y3;
        // INPUT
        x1 = scanner.nextDouble();
        y1 = scanner.nextDouble();
        x2 = scanner.nextDouble();
        y2 = scanner.nextDouble();
        x3 = scanner.nextDouble();
        y3 = scanner.nextDouble();
        // PreWORK for points
        sqrPartByPoint(x1, y1);
        sqrPartByPoint(x2, y2);
        sqrPartByPoint(x3, y3);
        // WORK
        lineChecker(x1, y1, x2, y2);
        lineChecker(x1, y1, x3, y3);
        lineChecker(x3, y3, x2, y2);
        // OUTPUT
        printFlags();
    }

    public static void printFlags() {
        System.out.println();
        if (!flagI && !flagII && !flagIII && !flagIV) System.out.println("Ни в одной из четвертей");
        if (flagI) System.out.print("I ");
        if (flagII) System.out.print("II ");
        if (flagIII) System.out.print("III ");
        if (flagIV) System.out.print("IV ");
        System.out.println();
    }

    public static void sqrPartByPoint(double x, double y) {
        if (x != 0 || y != 0) {
            if (x > 0 && y > 0) flagI = true;
            if (x < 0 && y > 0) flagII = true;
            if (x < 0 && y < 0) flagIII = true;
            if (x > 0 && y < 0) flagIV = true;
        }
    }

    public static boolean smartRangeChecker(double x, double y, double x1, double y1, double x2, double y2) {
        return Math.min(y1, y2) <= y && y <= Math.max(y1, y2) && Math.min(x1, x2) <= x && x <= Math.max(x1, x2);
    }

    public static void lineChecker(double x1, double y1, double x2, double y2) {
        double delta_x, delta_y;
        delta_x = x2 - x1;
        delta_y = y2 - y1;

        double x, y;
        if (delta_x != 0 && delta_y != 0) {
            boolean ox = false, oy = false;
            double x_ox_oy = 0, y_ox_oy = 0;
            double k, b;

            k = delta_y / delta_x;
            b = y2 - k * x2;

            if (k != 0) {
                x = -b / k;
                y = 0;
                if (smartRangeChecker(x, y, x1, y1, x2, y2)) {
                    ox = true;
                    x_ox_oy += x / 2;
                }
            }

            x = 0;
            y = b;

            if (smartRangeChecker(x, y, x1, y1, x2, y2)) {
                oy = true;
                y_ox_oy += y / 2;
            }
            if (ox && oy) {
                sqrPartByPoint(x_ox_oy, y_ox_oy);
            }
        }

    }
}