package IntegerHop;

import java.util.*;

public class Graph {
    Vertex root;

    private Set<Vertex> vertices = new HashSet<>();
    private ArrayList<Vertex> visited = new ArrayList<>();

    public Graph(int data) {
        root = new Vertex(data);
        vertices.add(root);
    }

    public void addVertex(int data) {
        vertices.add(new Vertex(data));
    }

    public void addEdge(int vertex1, int vertex2, int weight) {
        Vertex v1 = findVertex(vertex1);
        Vertex v2 = findVertex(vertex2);
        if (v1 != null && v2 != null) {
            v1.edges.put(v2, weight);
        }
    }

    public Vertex findVertex(int data) {
        for (Vertex vertex : vertices) {
            if (vertex.data == data) {
                return vertex;
            }
        }
        System.out.println("The vertex you are looking for is invalid!");
        return null;
    }

    public void printVertices() {
        for (Vertex vertex : vertices) {
            System.out.println(vertex.data);
        }
    }

    public void printEdges() {
        for (Vertex vertex : vertices) {
            System.out.print("Data of this Vertex = " + vertex.data + " -> ");
            for (Vertex edges : vertex.edges.keySet()) {
                System.out.print(edges.data + " ");
            }
            System.out.println();
        }
    }

    public boolean dfsSearch(int vertex1, int vertex2) {
        Vertex v1 = findVertex(vertex1);
        Vertex v2 = findVertex(vertex2);

        if (v1.data == v2.data) {
            System.out.println();
            return true;
        }

        visited.add(v1);

        for (Vertex vertex : v1.edges.keySet()) {
            if (!isVisited(vertex)) {

                if (dfsSearch(vertex.data, v2.data)) {
                    return true;
                }
            }
        }

        visited = new ArrayList<>();
        return false;
    }

    private boolean isVisited(Vertex v) {
        for (Vertex vertex : visited) {
            if (vertex.data == v.data) {
                return true;
            }
        }
        return false;
    }

    public Set<Vertex> getVertices() {
        return vertices;
    }

    // public static void main(String[] args) {
    // Graph graph = new Graph(0);
    // graph.addVertex(1);
    // graph.addVertex(2);
    // graph.addVertex(3);
    // graph.addVertex(4);
    // graph.addVertex(5);
    // graph.addVertex(6);

    // // Adding edges
    // graph.addEdge(0, 1, 2);
    // graph.addEdge(0, 2, 1);
    // graph.addEdge(1, 2, 5);
    // graph.addEdge(1, 3, 11);
    // graph.addEdge(1, 4, 3);
    // graph.addEdge(4, 2, 1);
    // graph.addEdge(4, 5, 4);
    // graph.addEdge(2, 5, 15);
    // graph.addEdge(3, 4, 2);
    // graph.addEdge(4, 6, 5);
    // graph.addEdge(6, 5, 1);
    // graph.addEdge(6, 3, 1);

    // // graph.printVertices();
    // graph.printEdges();

    // // System.out.println(graph.dfsSearch(0, 8));

    // }

}
