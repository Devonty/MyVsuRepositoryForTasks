package task_3_17;

public class HorizontalParabola {
    public double x0;
    public double y0;
    public double a;

    public HorizontalParabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    /**
     * Проверяет, находится ли точка (x, y) справа
     * (сверху, если повернуть изобюражение на 90 градусов
     * против часовой стрелки)
     * от параболы
     */
    public boolean isPointRightOfParabola(Point point) {
        return point.x > a * Math.pow(point.y - y0, 2) + x0;
    }

    public boolean isPointRightOfParabola(double x, double y) {
        return isPointRightOfParabola(new Point(x, y));
    }
}
