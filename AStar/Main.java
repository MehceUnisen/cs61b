package AStar;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
        // Adding edges
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 11);
        graph.addEdge(1, 4, 3);
        graph.addEdge(3, 4, 2);
        graph.addEdge(2, 5, 15);
        graph.addEdge(2, 4, 1);
        graph.addEdge(4, 5, 4);
        graph.addEdge(4, 6, 5);
        graph.addEdge(6, 3, 1);
        graph.addEdge(6, 5, 1);

        // graph.addEdge(2, 5, 15);
        // graph.addEdge(3, 4, 2);
        // graph.addEdge(4, 6, 5);
        // graph.addEdge(6, 5, 1);
        // graph.addEdge(6, 3, 1);
        List<Integer> heuristic = new ArrayList<Integer>(Stream.of(1, 3, 15, 1, 1, -1, 0).collect(Collectors.toList()));
        AStarSearch aStar = new AStarSearch(7, graph);
        Instant now = Instant.now();
        aStar.findPath(heuristic, graph.findVertex(0), graph.findVertex(6));
        System.out.println(Duration.between(now, Instant.now()));

        System.out.println(aStar.stringifyPath(graph.findVertex(6)));
        System.out.println(aStar.getWeight(graph.findVertex(6)));

    }
}
