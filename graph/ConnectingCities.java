package graph;

import java.util.PriorityQueue;

public class ConnectingCities {
    static class Edge implements Comparable<Edge> {
        int dstNode;
        int weight;

        public Edge(int dstNode, int weight) {
            this.dstNode = dstNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.weight - e2.weight;
        }
    }

    public static int connectCitis(int cities[][]) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean isVisited[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.remove();
            if (!isVisited[curr.dstNode]) {
                isVisited[curr.dstNode] = true;
                finalCost += curr.weight;

                for (int i = 0; i < cities[curr.dstNode].length; i++) {
                    if (cities[curr.dstNode][i] != 0) {
                        pq.add(new Edge(i, cities[curr.dstNode][i]));
                    }
                }
            }
        }

        return finalCost;
    }

    public static void main(String[] args) {
        int cities[][] = { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };
        System.out.println("Minimum cost(MST): " + connectCitis(cities));
    }
}
