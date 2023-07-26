package Project2B;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double returnByDirectionId(int id) {
        if (id == 0) {
            return x;
        }
        return y;
    }

    public double getDistance(double x, double y) {
        return Math.sqrt(Math.pow((this.x - x), 2.0) + Math.pow((this.y - y), 2.0));
    }
}
