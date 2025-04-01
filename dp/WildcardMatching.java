package dp;

// Time Complexity -> O(nm)
public class WildcardMatching {
    public static boolean isMatching(String word, String partern) {
        int n = word.length();
        int m = partern.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        // Initalization
        dp[0][0] = true;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if (partern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];
        }

        // Tabulation
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word.charAt(i - 1) == partern.charAt(j - 1) || partern.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (partern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word = "baaabab";
        String partern = "*****ba*****ab";
        System.out.println(isMatching(word, partern));
    }
}
