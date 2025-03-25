package dp;

public class RodCutting {
    public static int maxVal(int length[], int price[], int totalRod) {
        // Creating table for tabulation
        int dp[][] = new int[length.length + 1][totalRod + 1];
        // here is no need to initilized dp[i][0] & dp[0][j] with 0 because java did it
        // by deafult

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (length[i - 1] <= j) { // Valid case
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else { // Invalid case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length.length][totalRod];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int totalRod = 8;
        System.out.println(maxVal(length, price, totalRod));
    }
}
