package task_3_17;

public class Circle {
    public double x0;
    public double y0;
    public double r;

    public Circle(double x0, double y0, double r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    public boolean isPointInsideCircle(Point point){
        return Math.pow(this.r, 2) >= Math.pow(this.x0 - point.x, 2) + Math.pow(this.y0 - point.y, 2);
    }

    public boolean isPointInsideCircle(double x, double y){
        return this.isPointInsideCircle(new Point(x, y));
    }
}
