package graph;

import java.util.ArrayList;

public class KruskalsAlgo {
    static class Edge implements Comparable<Edge> {
        int strNode;
        int dstNode;
        int weight;

        public Edge(int strNode, int dstNode, int weight) {
            this.strNode = strNode;
            this.dstNode = dstNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    // Function to create the graph
    public static void createGraph(ArrayList<Edge> edges) {
        // Edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Creating Union dataset for kruskal's Algorithm
    public static int n = 4; // Vertex Number
    public static int parent[] = new int[n];
    public static int rank[] = new int[n];

    public static void init() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        // Optimized through path compression
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (rank[parentA] == rank[parentB]) {
            parent[parentB] = parentA;
            rank[parentA]++;
        }
        if (rank[parentA] > rank[parentB]) {
            parent[parentB] = parentA;
        } else {
            parent[parentA] = parentB;
        }
    }

    public static int kruskalAlgo(ArrayList<Edge> graph, int V) {
        init();
        int minimumCount = 0;
        int vertexCount = 0;

        for (int i = 0; vertexCount < V - 1; i++) {
            Edge e = graph.get(i);
            if (find(e.strNode) != find(e.dstNode)) {
                union(e.strNode, e.dstNode);
                minimumCount += e.weight;
                vertexCount++;
            }
        }
        return minimumCount;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        createGraph(graph);
        System.out.println("MST: " + kruskalAlgo(graph, n));
    }
}
