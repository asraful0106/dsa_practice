package dp;

public class o1_unbounted_knapsak {
    public static int unbountedKnapsak(int val[], int wt[], int w) {
        int dp[][] = new int[val.length + 1][w + 1];
        // Initilized dp[i][0] to deafult value 0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        // Initilized dp[0][j] to deafult value 0
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[val.length][w];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int w = 7;
        System.out.println(unbountedKnapsak(val, wt, w));
    }
}
