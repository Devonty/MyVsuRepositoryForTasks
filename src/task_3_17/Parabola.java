package task_3_17;

public class Parabola {
    public double x0;
    public double y0;
    public double a;

    public Parabola(double x0, double y0, double a) {
        this.x0 = x0;
        this.y0 = y0;
        this.a = a;
    }

    public boolean isPointAboveOfParabola(Point point) {
        return point.y > a * Math.pow(point.x - x0, 2) + y0;
    }

    public boolean isPointAboveOfParabola(double x, double y) {
        return isPointAboveOfParabola(new Point(x, y));
    }
}

