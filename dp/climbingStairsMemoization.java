package dp;

public class climbingStairsMemoization {
    public static int countWays(int n, int table[]) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        if (table[n] != 0)
            return table[n];
        // Memoization step
        return table[n] = countWays(n - 1, table) + countWays(n - 2, table);
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.println(countWays(n, new int[n + 1]));
    }
}
