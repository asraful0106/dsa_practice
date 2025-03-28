package dp;

// Time Complexity O(nm) where n = str1.length() and m = str2.length()
public class LCSubstring {
    public static int lcs(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int ans = 0;
        // Intilization dp[i][0] & dp[0][j] = 0 is not required because java do it by
        // deafult

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        System.out.println(lcs(str1, str2));
    }
}
