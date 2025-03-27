package dp;

public class LCS_tabulation {
    public static int lcs(StringBuilder str1, StringBuilder str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];
        // The base case is dp[0][i] = dp[0][j] = 0 (For java it autometically
        // initilized with 0)

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("abcdge");
        StringBuilder str2 = new StringBuilder("abedg");
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}
