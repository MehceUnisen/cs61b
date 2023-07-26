package IntegerHop;

import java.util.*;

public class Vertex {
    public Vertex(int data) {
        this.data = data;
    }

    int data;
    int distTo;
    int edgeTo;
    HashMap<Vertex, Integer> edges = new HashMap<>();

    public int getWeight(Vertex vert) {
        int x = edges.get(vert);
        return edges.get(vert);
    }

    // public void assignDistAndEdge(int distTo, int edgeTo, Vertex vert) {
    // for (int i = 0; i < edges.size(); i++) {
    // if (vert.data == edges.) {
    // this.distTo = distTo;
    // this.edgeTo = edgeTo;
    // }
    // }
    // }

}
