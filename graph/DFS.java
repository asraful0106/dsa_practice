package graph;

import java.util.ArrayList;

public class DFS {
    static class Edge {
        int strNode;
        int dstNode;
        int weight;

        public Edge(int strNode, int dstNode, int weight) {
            this.strNode = strNode;
            this.dstNode = dstNode;
            this.weight = weight;
        }
    }

    /*
       1--------3
      /         | \
     /          |  \
    0           |   5-----6
     \          |  /
      \         | /
       2--------4

 */
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < 7; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 0));
        graph[0].add(new Edge(0, 2, 0));

        graph[1].add(new Edge(1, 0, 0));
        graph[1].add(new Edge(1, 3, 0));

        graph[2].add(new Edge(2, 0, 0));
        graph[2].add(new Edge(2, 4, 0));

        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 4, 0));
        graph[3].add(new Edge(3, 5, 0));

        graph[4].add(new Edge(4, 2, 0));
        graph[4].add(new Edge(4, 3, 0));
        graph[4].add(new Edge(4, 5, 0));

        graph[5].add(new Edge(5, 3, 0));
        graph[5].add(new Edge(5, 4, 0));
        graph[5].add(new Edge(5, 6, 0));

        graph[6].add(new Edge(6, 5, 0));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] isVisited) {
        System.out.print(curr + " ");
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!isVisited[e.dstNode]) {
                dfs(graph, e.dstNode, isVisited);
            }
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[7];
        createGraph(graph);
        dfs(graph, 0, new boolean[graph.length]);
        System.out.println();
    }
}
