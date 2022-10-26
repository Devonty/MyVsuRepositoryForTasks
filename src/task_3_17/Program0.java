package task_3_17;

import java.util.Locale;
import java.util.Scanner;

public class Program0 {
    public static final Line line1 = new Line(3, 1, -4);
    public static final HorizontalParabola hor_parabola1 = new HorizontalParabola(6, -6, 1. / 9);
    public static final Circle circle1 = new Circle(0, -1, 2);
    public static final Rect rect_left = new Rect(new Point(-3, 1), new Point(0, -3));
    public static final Rect rect_right = new Rect(new Point(0, 1), new Point(3, -3));


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        Point green1 = new Point(-5, 5);
        Point green2 = new Point(-5, -5);
        Point blue1 = new Point(0, 0);
        Point blue2 = new Point(-2, -2);
        Point blue3 = new Point(5, 5);
        Point gray1 = new Point(2, -2);
        Point gray2 = new Point(2, 0);
        Point orange1 = new Point(7, -4);

        // extra point
        Scanner scanner = new Scanner(System.in);
        double x, y;

        System.out.print("Введите x: ");
        x = scanner.nextDouble();
        System.out.print("Введите y: ");
        y = scanner.nextDouble();

        Point extra = new Point(x, y);

        // check
        System.out.println("Набор точек:");
        printColorForPoint(green1);
        printColorForPoint(green2);
        printColorForPoint(blue1);
        printColorForPoint(blue2);
        printColorForPoint(blue3);
        printColorForPoint(gray1);
        printColorForPoint(gray2);
        printColorForPoint(orange1);
        System.out.println("Ваша точка:");
        printColorForPoint(extra);

    }

    public static void printColorForPoint(Point point) {
        System.out.printf("x: %f \t y: %f \t -> \t color: %s \n", point.x, point.y, getColor(point));

    }

    public static void printColorForPoint(double x, double y) {
        printColorForPoint(new Point(x, y));
    }

    public static Enum.SimpleColor getColor(Point point) {
        if (hor_parabola1.isPointRightOfParabola(point)) return Enum.SimpleColor.ORANGE;
        if (line1.isPointAboveLine(point)) return Enum.SimpleColor.BLUE;
        if (circle1.isPointInsideCircle(point)) return Enum.SimpleColor.BLUE;
        if (rect_left.isPointInsideRect(point)) return Enum.SimpleColor.BLUE;
        if (rect_right.isPointInsideRect(point)) return Enum.SimpleColor.GRAY;
        return Enum.SimpleColor.GREEN;
    }

    public static Enum.SimpleColor getColor(double x, double y) {
        return getColor(new Point(x, y));
    }

}
