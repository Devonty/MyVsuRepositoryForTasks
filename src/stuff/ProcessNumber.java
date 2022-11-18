package stuff;

public class ProcessNumber {
    private static final String digits = "0123456789ABCDEF";

    /* Преобразует строку num в десятичное число типа double
    из указанного основания base
    Может вызвать переполнение (выход за пределы диапазона целых чисел)!
    */
    private static double parseNumber(String num, int base){
        num = num.toUpperCase(); // digits are in UPPER_CASE
        double val = 0;
        int i = 0;
        while(i < num.length()) // пока не кончилась строка
        {
            char c = num.charAt(i);
            if(c == '.') { // нашли точку '.'
                i++; // Переместить на следующий символ и выйти из цикла.
                break;
            }
            int d = digits.indexOf(c); // Индексы совпадают с числами из [0..15]
            if(d == -1 || d >= base)
                return Double.NaN;
            val = base * val + d;
            i++;
        }

        int power = 1; // вычислить лишний порядок.
        while(i < num.length())
        {
            char c = num.charAt(i);
            int d = digits.indexOf(c);
            if(d == -1 || d >= base)
                return Double.NaN;
            power *= base; // увеличиваем степень порядка на единицу
            val = base * val + d;
            i++;
        }
        return val / power;
    }
    public static double parse(String num, String e, char et,
                               int base, int sign, int esign)
    {
        if(num == null || num.length() == 0 || base < 1) // null значения => NaN.
            return Double.NaN;

        double exp = 1; // Экспонента

// Двоичная экспонента (по основанию 2)
        if((et == 'P' || et == 'p') && e != null && e.length() > 0)
            exp = Math.pow(2.0, parseNumber(e, 10));

// Десятичная экспонента (по основанию 10)
        else if( (et == 'E' || et == 'e' || et == 'H' || et == 'h')
                && e != null && e.length() > 0)
            exp = Math.pow(10.0, parseNumber(e, 10));

//e == null or e.length() == 0.
// Указан тип экспоненты, но сама она отсутствует
        else if(et == 'E' || et == 'e' || et == 'H' || et == 'h'
                || et == 'P' || et == 'p')
        {
            return Double.NaN;
        }
        else // et is not [PpEeHh] => ignore exponent (exp == 1) (Нет экспоненты)
            exp = 1;

        if(esign < 0)
            exp = 1 / exp;

        double result = parseNumber(num, base); // Преобразовать численную часть.
        result = (result == Double.NaN) ? result : result * exp;

        if(sign < 0)
            result = 0 - result; //make number negative (include minus sign)

        return result;
    }
    public static double parseNumber(String str){
        if(str == null || str.length() == 0) //null is NaN.
            return Double.NaN;

        int sign = 1; // знак числа.
        int esign = 1; // знак экспоненты.
        int base = 10; // по умолчанию основание равно 10.
        int i = 0;
        if(str.charAt(0) == '-') { // Минус -> sign < 0.
            sign = -1;
            i = 1; // перейти к следующему знаку.
        }
        if(i > 0 && i == str.length()) //str is '-' (строка состоит только из '-')
            return Double.NaN;

// suffix '0x' => 16 (hex)
        if(str.charAt(i) == '0' && (i + 1 != str.length()) && str.charAt(i + 1) == 'x') {
            base = 16;
            i += 2;
        }
//suffix '0b' => 2 (binary)
        else if(str.charAt(i) == '0' && (i + 1 != str.length()) && str.charAt(i + 1) == 'b') {
            base = 2;
            i += 2;
        }
//suffix '0c' => 8 (octal)
        else if(str.charAt(i) == '0' && (i + 1 != str.length()) && str.charAt(i + 1) == 'c'){
            base = 8;
            i += 2;
        }
        if(i == str.length())// строки вида (-0x -0b -0c 0x 0b 0c)
            return Double.NaN;

//Вычислить экспоненту.
        int idx = str.indexOf('H');
        idx = (idx == -1) ? str.indexOf('h') : idx;
        idx = (idx == -1) ? str.indexOf('P') : idx;
        idx = (idx == -1) ? str.indexOf('p') : idx;
        idx = (idx == -1 && base != 16) ? str.indexOf('E') : idx;
        idx = (idx == -1 && base != 16) ? str.indexOf('e') : idx;

        char etype = (idx == -1) ? 'N' : str.charAt(idx);

//Когда нет экспоненты (idx + 1) == 0.
        if(idx + 1 == str.length())// no more digits after exponent letter ('12E' or 'FFP')
            return Double.NaN;

        String exp = null;

//Отрицательная экспонента, но нет цифр 'E-' or 'P-' or 'h-'
        if(str.charAt(idx + 1) == '-' && idx != -1 && idx + 2 == str.length())
            return Double.NaN;

//Отрицательная экспонента. 'E-2' or 'p-10'
        if(str.charAt(idx + 1) == '-' && idx != -1){
            exp = str.substring(idx + 2);
            esign = -1;
        }
        else
            exp =
                    str.substring(idx + 1); //Положительная экспонента (после idx следует цифра)

        idx = (idx == -1) ? str.length() : idx; //if no exponent then idx <- length(str)

        String number = str.substring(i, idx);
        return parse(number, exp, etype, base, sign, esign);
    }
}