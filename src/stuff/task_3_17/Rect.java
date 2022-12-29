package stuff.task_3_17;

public class Rect {
    public Point p1;
    public Point p2;

    public Rect(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public boolean isPointInsideRect(Point point) {
        boolean in_x_range = Math.min(p1.x, p2.x) <= point.x && point.x <= Math.max(p1.x, p2.x);
        boolean in_y_range = Math.min(p1.y, p2.y) <= point.y && point.y <= Math.max(p1.y, p2.y);
        return in_x_range && in_y_range;
    }

    public boolean isPointInsideRect(double x, double y){
        return isPointInsideRect(new Point(x, y));
    }
}
