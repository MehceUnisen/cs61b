package graph;

import java.util.ArrayList;
import java.util.*;

public class Graph {
    Vertex root;

    Set<Vertex> vertices = new HashSet<>();
    ArrayList<Vertex> visited = new ArrayList<>();

    public class Vertex {
        public Vertex(int data) {
            this.data = data;
        }

        int data;
        Set<Vertex> edges = new HashSet<>();
    }

    public Graph(int data) {
        root = new Vertex(data);
        vertices.add(root);
    }

    public void addVertex(int data) {
        vertices.add(new Vertex(data));
    }

    public void addEdge(int vertex1, int vertex2) {
        Vertex v1 = findVertex(vertex1);
        Vertex v2 = findVertex(vertex2);
        if (v1 != null && v2 != null) {
            v1.edges.add(v2);
            v2.edges.add(v1);
        }
    }

    private Vertex findVertex(int data) {
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
            for (Vertex edges : vertex.edges) {
                System.out.print(edges.data + " ");
            }
            System.out.println();
        }
    }

    public boolean dfsSearch(int vertex1, int vertex2) {
        Vertex v1 = findVertex(vertex1);
        Vertex v2 = findVertex(vertex2);

        if (v1.data == v2.data) {
            return true;
        }

        visited.add(v1);

        for (Vertex vertex : v1.edges) {
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

    public static void main(String[] args) {
        Graph graph = new Graph(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        graph.addVertex(7);
        graph.addVertex(8);

        // Adding edges
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        // graph.addEdge(5, 3);
        // graph.addEdge(6, 4);

        graph.printVertices();
        graph.printEdges();

        System.out.println(graph.dfsSearch(3, 5));
    }

}
