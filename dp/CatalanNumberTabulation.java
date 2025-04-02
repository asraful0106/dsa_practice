package dp;

public class CatalanNumberTabulation {
    public static int calanTabulation(int n) {
        int[] dp = new int[n + 1];

        // initilization
        dp[0] = dp[1] = 1;

        // Tabulation
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1]; // Cn = Cj * Ci-j-1
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(calanTabulation(4));
    }
}
