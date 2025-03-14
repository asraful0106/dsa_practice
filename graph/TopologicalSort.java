package graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
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

    public static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < graph.length; i++) {
            if (!isVisited[i])
                topologicalSortUtil(graph, i, isVisited, s);
        }

        while (!s.empty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void topologicalSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, Stack<Integer> s) {
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dstNode])
                topologicalSortUtil(graph, e.dstNode, isVisited, s);
        }
        s.push(curr);
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        topologicalSort(graph);
        System.out.println();
    }
}
