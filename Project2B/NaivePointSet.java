package Project2B;

import java.util.*;

public class NaivePointSet implements PointSet {

    private List<Point> points;

    public NaivePointSet(List<Point> points) {
        this.points = points;
    }

    public void updatePoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public Point nearest(double x, double y) {
        Point closest = points.get(0);
        double dist = closest.getDistance(x, y);
        for (int i = 1; i < points.size(); i++) {
            double tempDst = points.get(i).getDistance(x, y);
            if (tempDst < dist) {
                closest = points.get(i);
            }
        }
        return closest;
    }

}
