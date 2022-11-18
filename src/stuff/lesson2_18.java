package stuff;

import java.security.AlgorithmConstraints;
import java.util.Scanner;

public class lesson2_18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r1, r2;

        System.out.println("Введите малый, а затем больший радиус: ");
        r1 = scanner.nextDouble();
        r2 = scanner.nextDouble();

        for(int i=0;i<10;i++){

        }

        if (r1 > r2) {
            System.out.println("Вы указали малый радиус, который превышает больший радиус.\n" +
                    "Значения радиусов были поменяны местами.");
            double tmp_r;
            tmp_r = r1;
            r1 = r2;
            r2 = tmp_r;
        }

        double square = getSquare(r1, r2);
        System.out.println("Площадь закрашенной части: " + square);


    }

    public static double getSquare(double r1, double r2) {
        double s1 = 0, s2 = 0, s3 = 0;
        s1 = 2 * (1. / 8.) * Math.PI * (Math.pow(r2, 2) - Math.pow(r1, 2));
        s2 = 3 * (1. / 8.) * Math.PI * Math.pow(r1, 2);
        s3 = 1 * (1. / 8.) * (Math.pow(2 * r2, 2)) - (1. / 8.) * (Math.PI * Math.pow(r2, 2));

        return s1 + s2 + s3;
    }
}
