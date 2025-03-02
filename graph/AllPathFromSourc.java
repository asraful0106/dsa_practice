package graph;

import java.util.ArrayList;

public class AllPathFromSourc {
    static class Edge{
        int strNode;
        int dstNode;

        public Edge(int strNode, int dstNode){
            this.strNode = strNode;
            this.dstNode = dstNode;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 3));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void findPath(ArrayList<Edge>[] graph, int srcNode, int dstNode, StringBuilder path){
        // BaseCase
        if(srcNode == dstNode){
            System.out.println(path.append(srcNode));
            path.delete(0, path.length());
            return;
        }

        for(int i = 0; i<graph[srcNode].size(); i++){
            Edge e = graph[srcNode].get(i);
            findPath(graph, e.dstNode, dstNode, path.append(srcNode));
        }
    }

    public static void main(String[] args) {
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[6];
        createGraph(graph);
        findPath(graph, 5, 1, new StringBuilder(""));
    }
}
