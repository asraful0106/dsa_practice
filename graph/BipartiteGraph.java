package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int strNode;
        int dstNode;

        public Edge(int strNode, int dstNode) {
            this.strNode = strNode;
            this.dstNode = dstNode;
        }
    }

    /*
                0
              /   \
             /     \
            1       2
             \      |
              \     |
                3---4
     */

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] coller = new int[graph.length];
        for (int i = 0; i < coller.length; i++) {
            coller[i] = -1; // initially assigned -1 which indicates no color
        }
        for (int i = 0; i < coller.length; i++) {
            if (coller[i] == -1) {
                if (!isBipartetUtil(graph, coller, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartetUtil(ArrayList<Edge>[] graph, int[] coller, int col_index) {
        Queue<Integer> q = new LinkedList<>();
        q.add(col_index);
        coller[col_index] = 0; // black

        while (!q.isEmpty()) {
            int curr = q.remove();
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (coller[e.dstNode] == -1) {
                    int nextColler = coller[curr] == 0 ? 1 : 0;
                    coller[e.dstNode] = nextColler;
                    q.add(e.dstNode);
                } else if (coller[e.dstNode] == coller[curr]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[5];
        createGraph(graph);
        System.out.println(isBipartite(graph));
    }
}