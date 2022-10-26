import java.util.Locale;
import java.util.Scanner;

public class task_6_7 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        Scanner scanner = new Scanner(System.in);
        int n;
        double e, x;


        x = scanner.nextDouble();
        n = scanner.nextInt();
        e = scanner.nextDouble();

        double sumN = 0;
        double sumE = 0;
        double sumEDiv10 = 0;
        double sumMath = 1. / (Math.sqrt(1 - Math.pow(x, 2)));

        double mulKoef = 1;
        double xInPow = 1; // x^0
        double aN;
        int cur = 1;

        while (n > 0) {
            n--;
            // aN calc
            aN = mulKoef * xInPow;
            System.out.println(aN);
            // param calc
            mulKoef = mulKoef * ((cur * 2 - 1.) / (cur * 2));
            xInPow *= Math.pow(x, 2);
            cur++;
            // sum calc
            sumN += aN;
            if (Math.abs(aN) > e) {
                sumE += aN;
            }
            if (Math.abs(aN) > e / 10) {
                sumEDiv10 += aN;
            }

        }

        System.out.println("Сумма n членов: " + sumN);
        System.out.println("Сумма членов больших e: " + sumE);
        System.out.println("Сумма членов больших e/10: " + sumEDiv10);
        System.out.println("Значение функции: " + sumMath);
    }
}
