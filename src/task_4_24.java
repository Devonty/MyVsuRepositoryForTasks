public class task_4_24 {
    /*
    24.	Найти сумму всех чисел от 100 до 999, таких, что все цифры в числе разные.
    Строки не использовать, только целые числа.
    Для определения, подходит ли число под требования задачи, реализовать функцию.
    Также реализовать функцию для нахождения суммы чисел.
     */
    public static boolean checkNumber(int num) {
        int dig1, dig2, dig3;

        dig1 = num % 10;
        num /= 10;
        dig2 = num % 10;
        num /= 10;
        dig3 = num % 10;
        num /= 10;

        return dig1 != dig2 && dig1 != dig3 && dig2 != dig3;
    }

    public static int getSumUnique(int beg, int end) {
        int ans_sum = 0;
        for (int num = beg; num <= end; num++) {
            if (checkNumber(num)) {
                ans_sum += num;
            }
        }
        return ans_sum;
    }

    public static int getSumUnique() {
        // хз как еще значение по умолчанию сделать
        return getSumUnique(100, 999);
    }

    public static void main(String[] args) {
        System.out.println("Сумма всех чисел от 100 до 999, таких, что все цифры в числе разные: " + getSumUnique());
    }
}
