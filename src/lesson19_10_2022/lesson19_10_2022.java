package lesson19_10_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lesson19_10_2022 {
    public static void main(String[] args) {
        sovleGausButArrays();
    }

    public static void sovleGaus() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Введите число точек: ");
        int n = scn.nextInt();

        List<Point> points = new ArrayList<Point>();

        points.add(new Point(3, 4));
        points.add(new Point(5, 11));
        points.add(new Point(12, 8));
        points.add(new Point(9, 5));
        points.add(new Point(5, 6));

        for (int i = 0; i < n; i++) {
            if(true)break;
            double x, y;
            System.out.printf("Введите x%s: ", i);
            x = scn.nextDouble();
            System.out.printf("Введите y%s: ", i);
            y = scn.nextDouble();
            System.out.println();

            points.add(new Point(x, y));
        }

        System.out.println("Площадь ммногоугольника равна: " + getSqare(points));
    }
    public static double getSqare(List<Point> points) {
        double sum1 = 0;
        double sum2 = 0;
        int len = points.size();

        for (int i = 0; i < len; i++) {
            sum1 += points.get(i % len).x * points.get((i + 1) % len).y;
        }

        for (int i = 0; i < len; i++) {
            sum2 += points.get(i % len).x * points.get((i - 1 + len) % len).y;
        }

        System.out.println(sum1 + " " + sum2);
        return (1. / 2) * Math.abs(sum1 - sum2);
    }

    public static void solve1() {
        Scanner scn = new Scanner(System.in);
        List<Integer> lst = new ArrayList<>();
        System.out.println("Вводите числа, чтобы завершить ввод - введите не число. К примеру:  \"-\"");
        while (scn.hasNextInt()) {
            lst.add(scn.nextInt());
        }
        scn.next(); // skip
        System.out.println("Введите число, кол-во вхождение которого нужно посчитать: ");
        int keyToFind = scn.nextInt();
        int coutIn = 0;
        for (int num : lst) {
            coutIn += (num == keyToFind) ? 1 : 0;
        }
        System.out.println(coutIn);
    }

    public static double getSqare(Point[] points) {
        double sum1 = 0;
        double sum2 = 0;
        int len = points.length;

        for (int i = 0; i < len; i++) {
            sum1 += points[i % len].x * points[((i + 1) % len)].y;
        }

        for (int i = 0; i < len; i++) {
            sum2 += points[(i % len)].x * points[((i - 1 + len) % len)].y;
        }

        System.out.println(sum1 + " " + sum2);
        return (1. / 2) * Math.abs(sum1 - sum2);
    }

    public static void sovleGausButArrays() {
        Scanner scn = new Scanner(System.in);

        System.out.print("Введите число точек: ");
        int n = scn.nextInt();

        Point[] points = new Point[n];

        points[0] = (new Point(3, 4));
        points[1] = (new Point(5, 11));
        points[2] = (new Point(12, 8));
        points[3] = (new Point(9, 5));
        points[4] = (new Point(5, 6));

        for (int i = 0; i < n; i++) {
            if(true)break;
            double x, y;
            System.out.printf("Введите x%s: ", i);
            x = scn.nextDouble();
            System.out.printf("Введите y%s: ", i);
            y = scn.nextDouble();
            System.out.println();

            points[i] = (new Point(x, y));
        }

        System.out.println("Площадь ммногоугольника равна: " + getSqare(points));
    }
}
