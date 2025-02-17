package graph;

import java.util.ArrayList;

public class CycleDetectionUnderected {
    static class Edge {
        int strNode;
        int dstNode;

        public Edge(int strNode, int dstNode) {
            this.strNode = strNode;
            this.dstNode = dstNode;
        }
    }
    /*
            0--------3
           /|        |
          1 |        |
           \|        |
            2        4
     */
    public static void creatGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        // graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean detectCycle(ArrayList<Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i])
                return detectCycleUtill(graph, isVisited, i, -1);
        }
        return false;
    }

    public static boolean detectCycleUtill(ArrayList<Edge>[] graph, boolean[] isVisited, int curr, int parent) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            // if destination is visited and
            if (!isVisited[e.dstNode]) {
                if (detectCycleUtill(graph, isVisited, e.dstNode, curr))
                    return true;
            } else if (isVisited[e.dstNode] && e.dstNode != parent) { // if destination node is visited and destination
                                                                      // node is notequal to parrent
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        creatGraph(graph);
        System.out.println(detectCycle(graph));
    }
}
