package dp;

public class LCS_memoization {
    public static int lcs(StringBuilder str1, StringBuilder str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = lcs(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            return dp[n][m] = Math.max(lcs(str1, str2, n - 1, m, dp), lcs(str1, str2, n, m - 1, dp));
        }
    }

    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("abcdge");
        StringBuilder str2 = new StringBuilder("abedg");
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        // Intilize dp[][] with -1
        for (int i = 0; i < dp.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        System.out.println(lcs(str1, str2, str1.length(), str2.length(), dp));
    }
}
