package AStar;

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

    public boolean findPath(List<Integer> heuristic, Vertex start, Vertex goal) {
        for (Vertex edgVertex : start.edges.keySet()) {

            if (!visited.contains(edgVertex.data)) {
                edgVertex.edgeTo = start.data;
                edgVertex.distTo = start.distTo + start.edges.get(edgVertex);
                pq.add(heuristic.get(edgVertex.data) + edgVertex.distTo, edgVertex.data);
                if (pq.getSmallest() == goal.data) {
                    return true;
                }
            }

        }
        visited.add(pq.getSmallest());

        if (findPath(heuristic, graph.findVertex(pq.removeSmallest()), goal)) {
            return true;
        }

        return false;

    }

    public String stringifyPath(Vertex goal) {
        String ret = "";
        if (goal.edgeTo == goal.data) {
            return Integer.toString(goal.data);
        }
        ret = stringifyPath(graph.findVertex(goal.edgeTo));

        ret += " --> " + Integer.toString(goal.data);
        return ret;
    }

    public int getWeight(Vertex goal) {
        return goal.distTo;
    }

}
