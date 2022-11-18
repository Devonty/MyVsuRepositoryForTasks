package stuff;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        int a, b, c;
        Scanner scanner = new Scanner(System.in);


        System.out.println("Введите 3 целых числа: ");

        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        int mx, mn, md;
        mn = Math.min(a, Math.min(b, c));
        mx = Math.max(a, Math.max(b, c));
        md = a+b+c-mx-mn;

        System.out.println("Среднее по значению число: " + md);
    }
}