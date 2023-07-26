package IntegerHop;

import java.util.*;

public class AStarSearch {
    ArrayHeapMinPq pq;
    Graph graph;
    Set<Integer> visited;
    String path = "";

    public AStarSearch(int size, Graph graph) {
        pq = new ArrayHeapMinPq(size);
        this.graph = graph;
        visited = new HashSet<Integer>(size);
    }

    public boolean findPath(Vertex start, Vertex goal) {

        createNeighbour(start);
        for (Vertex edgVertex : start.edges.keySet()) {

            if (!visited.contains(edgVertex.data)) {
                if (edgVertex.distTo == 0 || start.distTo + start.getWeight(edgVertex) < start.distTo) {

                    edgVertex.edgeTo = start.data;
                    edgVertex.distTo = start.distTo + start.getWeight(edgVertex);
                    if (edgVertex.data == 16) {
                        System.out.println(edgVertex.distTo);
                    }
                    pq.add(heuristic() + edgVertex.distTo, edgVertex.data);

                    if (pq.getSmallest() == goal.data) {
                        return true;
                    }

                }
                visited.add(pq.getSmallest());
            }
        }

        if (findPath(graph.findVertex(pq.removeSmallest()), goal)) {
            return true;
        }

        return false;

    }

    public int heuristic() {
        return 0;
    }

    public String stringifyPath(Vertex goal) {
        String ret = "";

        if (goal.data == 16) {
            return "0";
        }
        if (goal.edgeTo == goal.data) {
            return Integer.toString(goal.data);
        }
        System.out.println("mey edge to = " + goal.edgeTo);
        ret = stringifyPath(graph.findVertex(goal.edgeTo));
        ret += " --> " + Integer.toString(goal.data);
        return ret;
    }

    public int getWeight(Vertex goal) {
        return goal.distTo;
    }

    public void createNeighbour(Vertex vertex) {
        graph.addVertex(vertex.data * vertex.data);
        graph.addEdge(vertex.data, vertex.data * vertex.data, 10);

        graph.addVertex(vertex.data * 2);
        graph.addEdge(vertex.data, vertex.data * 2, 5);

        graph.addVertex(vertex.data / 2);
        graph.addEdge(vertex.data, vertex.data / 2, 5);

        graph.addVertex(vertex.data - 1);
        graph.addEdge(vertex.data, vertex.data - 1, 1);

        graph.addVertex(vertex.data + 1);
        graph.addEdge(vertex.data, vertex.data + 1, 1);

    }

}
