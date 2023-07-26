package Project2B;

import java.util.*;

public class KDTree {
    private List<Point> points;
    public Node root;

    public class Node {
        public Node(Point point) {
            this.point = point;
            points[0] = point.getX();
            points[1] = point.getY();
            n1 = null;
            n2 = null;
        }

        double[] points = new double[2];
        Node n1, n2;
        private Point point;
    }

    public KDTree(List<Point> points) {
        this.points = points;
        root = new Node(points.get(0));
        insertInTree();
    }

    private void insertInTree() {
        for (Point point : points) {
            root = insertPoint(point, root, 0);
        }
    }

    private Node insertPoint(Point point, Node root, int depth) {
        if (root == null) {
            return new Node(point);
        }
        int directionId = depth % 2;
        if (root.points[directionId] > point.returnByDirectionId(directionId)) {
            root.n1 = insertPoint(point, root.n1, ++depth);
        } else if (root.points[directionId] < point.returnByDirectionId(directionId)) {
            root.n2 = insertPoint(point, root.n2, ++depth);
        }
        return root;
    }

    public Point nearest(double x, double y) {
        Point ret = points.get(0);
        double[] arr = new double[2];
        arr[0] = x;
        arr[1] = y;
        double dist = root.point.getDistance(x, y);
        return nearest(arr, root, dist, ret, 0);
    }

    int sanity = 0;

    private Point nearest(double[] arrPoints, Node root, double dist, Point nearest, int depth) {
        if (root == null) {
            return nearest;
        }
        double newDist = root.point.getDistance(arrPoints[0], arrPoints[1]);
        if (newDist > dist) {
            sanity++;
            if (sanity == 2)
                return nearest;
        }
        int id = depth % 2;
        dist = newDist;
        nearest = root.point;
        Node xNode = null;
        if (arrPoints[id] < root.point.returnByDirectionId(id)) {
            xNode = root.n2;
            nearest = nearest(arrPoints, root.n1, dist, nearest, ++depth);
        } else if (arrPoints[id] >= root.point.returnByDirectionId(id)) {
            xNode = root.n1;
            nearest = nearest(arrPoints, root.n2, dist, nearest, ++depth);
        }
        if (Math.abs(arrPoints[id] - nearest.returnByDirectionId(id)) > Math.abs(arrPoints[id] - root.points[id])) {
            nearest = nearest(arrPoints, xNode, dist, xNode.point, depth);
        }
        return nearest;
    }

}
