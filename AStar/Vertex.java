package AStar;

import java.util.*;

public class Vertex {
    public Vertex(int data) {
        this.data = data;
    }

    int data;
    int distTo;
    int edgeTo;
    HashMap<Vertex, Integer> edges = new HashMap<>();

}
