package graph;

public class DisjointSetUnion {
    static int n = 7;
    static int parent[] = new int[n];
    static int rank[] = new int[n];

    public static void init(int parent[]) {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int leaderA = find(a);
        int leaderB = find(b);

        if (rank[leaderA] == rank[leaderB]) {
            parent[leaderB] = leaderA;
            rank[leaderA]++;
        }
        if (rank[leaderA] < rank[leaderB]) {
            parent[leaderA] = leaderB;
        } else {
            parent[leaderB] = leaderA;
        }
    }

    public static void main(String[] args) {
        init(parent);
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
    }
}
