package dp;

public class o1_kanpsakMemoization {
    public static int knapsakMemo(int val[], int wt[], int capacity, int n, int dp[][]) {
        if (capacity == 0 || n == 0)
            return 0;
        if (dp[n][capacity] != -1)
            return dp[n][capacity];
        if (wt[n - 1] <= capacity) {
            // Insert in bag
            int ans1 = val[n - 1] + knapsakMemo(val, wt, capacity - wt[n - 1], n - 1, dp);
            // Discard from bag
            int ans2 = knapsakMemo(val, wt, capacity, n - 1, dp);
            return dp[n][capacity] = Math.max(ans1, ans2);
        } else {
            return dp[n][capacity] = knapsakMemo(val, wt, capacity, n - 1, dp);
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int capacity = 7;
        int dp[][] = new int[val.length + 1][capacity + 1];
        for (int i = 0; i < dp.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }
        System.out.println(knapsakMemo(val, wt, capacity, val.length, dp));
    }
}
