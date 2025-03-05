package graph;

import java.util.ArrayList;

public class BellmanFordAlgo {
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

    // BallmanFord will not work if the minmum distance is negative on a cycle
    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, -4));

        graph[2].add(new Edge(2, 3, 2));

        graph[3].add(new Edge(3, 4, 4));

        graph[4].add(new Edge(4, 1, -1));
    }

    public static void bellmanFordAlgo(ArrayList<Edge> graph[], int src) {
        int distance[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src)
                distance[i] = Integer.MAX_VALUE;
        }

        // O(VE)
        for (int i = 0; i < graph.length - 1; i++) {
            // O(V)
            for (int j = 0; j < graph.length; j++) {
                // O(E)
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    // relaxation
                    if (distance[e.strNode] != Integer.MAX_VALUE
                            && distance[e.strNode] + e.weight < distance[e.dstNode])
                        distance[e.dstNode] = distance[e.strNode] + e.weight;
                }
            }
        }

        for(int i = 0; i<distance.length; i++){
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
        bellmanFordAlgo(graph, 0);
    }
}
