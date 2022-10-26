package task_3_17;

public class Line {
    public double x0;
    public double y0;
    public double a;

    /**
     * Линия вида y = a * (x - x0) + y0
     * (можно обойтись без y0, но с ним удобнее;
     *  будем считать, что линия всегда наклонная)
     */

    public Line(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    /**
     * Проверяет, находится ли точка (x, y) выше линии
     */
    public boolean isPointAboveLine(Point point) {
        return point.y > a * (point.x - x0) + y0;
    }
    public boolean isPointAboveLine(double x, double y) {
        return isPointAboveLine(new Point(x, y));
    }
}
