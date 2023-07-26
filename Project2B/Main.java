package Project2B;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(1.1, 2.2); // constructs a Point with x = 1.1, y = 2.2
        Point p2 = new Point(3.3, 4.4);
        Point p3 = new Point(-2.9, 4.2);
        Point p4 = new Point(0.9, 3.2);
        Point p5 = new Point(0.7, 5.6);
        Point p6 = new Point(0.8, 4.7);
        Point p7 = new Point(0.5, 4.0);
        Point p8 = new Point(0.6, 3.8);
        KDTree kdTree = new KDTree(List.of(p1, p2, p3, p4, p5, p6, p7, p8));

        Point x = kdTree.nearest(0.6, 3.7);
        System.out.println(x.getX());
        System.out.println(x.getY());
    }
}
