package graph;

import java.util.ArrayList;

public class CreatingGraph {
    static class Edge {
        int strEdg;
        int disEdg;
        int wight;

        public Edge(int strEdg, int disEdg, int wight) {
            this.strEdg = strEdg;
            this.disEdg = disEdg;
            this.wight = wight;
        }
    }

    /*
     ************ Graph********
     * (5)
     * 0------------1
     * / \
     * (1)/ \(3)
     * / \
     * 2-------3
     * | (1)
     * (2)|
     * |
     * 4
     */
    public static void main(String[] args) {
        // --------Array list for 5 vertex
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];

        // assing a empty array for each vertex(currently there is stored "null")
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        // For node 0
        graph[0].add(new Edge(0, 1, 5));

        // For node 1
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));

        // For node 2
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        // For node 3
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));

        // For node 4
        graph[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.disEdg + " ");
        }
        System.out.println();
    }
}
