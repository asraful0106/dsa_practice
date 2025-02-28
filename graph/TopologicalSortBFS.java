// Topological sort using BFS (Kahn's algorithm)
package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    static class Edge {
        int strNode;
        int dstNode;

        public Edge(int strNode, int dstNode) {
            this.strNode = strNode;
            this.dstNode = dstNode;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void calculateIndeg(ArrayList<Edge>[] graph, int[] indeg) {
        for (int vertex = 0; vertex < graph.length; vertex++) {
            for (int edge = 0; edge < graph[vertex].size(); edge++) {
                Edge e = graph[vertex].get(edge);
                indeg[e.dstNode]++;
            }
        }
    }

    public static void topologicalSortBFS(ArrayList<Edge>[] graph) {
        int[] indeg = new int[graph.length];
        calculateIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < indeg.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indeg[e.dstNode]--;
                if (indeg[e.dstNode] == 0)
                    q.add(e.dstNode);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        topologicalSortBFS(graph);
    }
}
