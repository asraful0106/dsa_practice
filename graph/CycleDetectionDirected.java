package graph;

import java.util.ArrayList;

public class CycleDetectionDirected {
    static class Edge {
        int strNode;
        int dstNode;

        public Edge(int strNode, int dstNode) {
            this.strNode = strNode;
            this.dstNode = dstNode;
        }
    }

    /*
        1------>0<------2
                /\     /\
                  \   /
                   \ /
                    3
     */

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, -1));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 2));
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        boolean[] isVisited = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];

        for (int i = 0; i < isVisited.length; i++) {
            if (!isVisited[i])
                if (isCycleUtil(graph, i, isVisited, stack))
                    return true;
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] isVisited, boolean[] stack) {
        isVisited[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (stack[e.dstNode])
                return true;
            if (!stack[e.dstNode] && isCycleUtil(graph, e.dstNode, isVisited, stack))
                return true;
        }
        stack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[4];
        createGraph(graph);
        System.out.println("Is circle in the graph: " + isCycle(graph));
    }
}
