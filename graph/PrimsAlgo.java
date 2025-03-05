package graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

// To find the Minimum Spaning Tree(MST)
public class PrimsAlgo {
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

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void primsAlgo(ArrayList<Edge> graph[], int src) {
        boolean isVisited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        int totalCost = 0;
        ArrayList<Integer> edge = new ArrayList<>();
        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            for (int i = 0; i < graph.length; i++) {
                if (!isVisited[curr.v]) {
                    isVisited[curr.v] = true;
                    totalCost += curr.cost;
                    edge.add(curr.v);

                    for (int j = 0; j < graph[i].size(); j++) {
                        Edge e = graph[i].get(j);
                        pq.add(new Pair(e.dstNode, e.weight));
                    }
                }
            }
        }

        System.out.println("MST cost: " + totalCost);
        for (int i = 0; i < edge.size(); i++) {
            System.out.print(edge.get(i) + " ");
        }
    }
    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[4];
        createGraph(graph);
        primsAlgo(graph, 0);
    }
}
