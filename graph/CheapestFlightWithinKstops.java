package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKstops {
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

    static class Info {
        int v;
        int cost;
        int k;

        public Info(int v, int cost, int k) {
            this.v = v;
            this.cost = cost;
            this.k = k;
        }
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < flights.length; i++) {
            graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1], flights[i][2]));
        }
    }

    public static void cheapestFlights(ArrayList<Edge> graph[], int strNode, int dstNode, int k) {
        int distance[] = new int[graph.length];
        // For taraking the path
        int predecessor[] = new int[graph.length];
        // Assign Infinty from dstNode
        for (int i = 0; i < distance.length; i++) {
            if (i != strNode)
                distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1; // Initalized with -1
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(strNode, 0, 0));
        ArrayList<Integer> minimumPath = new ArrayList<>();

        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr.k > k) {
                break;
            }
            for (int i = 0; i < graph[curr.v].size(); i++) {
                Edge e = graph[curr.v].get(i);
                // Relaxation step (we use curr.v insted of e.strNode cause e.strNode give us
                // the minimum distance but we need curr distance)
                if (distance[curr.v] + e.weight < distance[e.dstNode] && curr.k <= k) {
                    distance[e.dstNode] = distance[curr.v] + e.weight;
                    q.add(new Info(e.dstNode, distance[e.dstNode], curr.k + 1));
                    predecessor[e.dstNode] = curr.v;
                }
            }
        }

        // Printing the minimum cost
        if (distance[dstNode] != Integer.MAX_VALUE) {
            System.out.println("Minimum Cost: " + distance[dstNode]);
            // Geting the minimum path
            for (int at = dstNode; at != -1; at = predecessor[at]) {
                minimumPath.add(0, at);
            }
            System.out.print("Minimum cost path: ");
            for (int i = 0; i < minimumPath.size(); i++) {
                System.out.print(minimumPath.get(i) + " ");
            }
        } else {
            System.out.println(-1);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[4];
        int flights[][] = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        createGraph(flights, graph);
        cheapestFlights(graph, 0, 3, 1);
    }
}
