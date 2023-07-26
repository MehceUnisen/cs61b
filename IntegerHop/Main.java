package IntegerHop;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(17);
        graph.addVertex(111);
        AStarSearch aStar = new AStarSearch(5000, graph);

        Instant now = Instant.now();

        aStar.findPath(graph.findVertex(17), graph.findVertex(111));
        // System.out.println(Duration.between(now, Instant.now()));

        System.out.println(aStar.stringifyPath(graph.findVertex(111)));
        // System.out.println(aStar.getWeight(graph.findVertex(111)));

        System.out.println("ben sizin babanizim = " + graph.findVertex(225).edgeTo);
        System.out.println(graph.findVertex(16).edgeTo);

    }
}
