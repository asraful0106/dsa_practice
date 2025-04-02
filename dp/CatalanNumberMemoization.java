package dp;

import java.util.Arrays;

public class CatalanNumberMemoization {
    public static int catalanMemoization(int n, int dp[]) {
        // Base case
        if (n == 0 || n == 1)
            return 1;
        // Memoization
        if (dp[n] != -1)
            return dp[n];

        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanMemoization(i, dp) * catalanMemoization(n - i - 1, dp);
        }
        return dp[n] = ans;
    }

    public static void main(String[] agrs) {
        int n = 4;
        int[] dp = new int[n + 1];
        // Initlize dp with -1
        Arrays.fill(dp, -1);

        System.out.println(catalanMemoization(n, dp));
    }
}
