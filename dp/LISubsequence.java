package dp;

import java.util.Arrays;
import java.util.HashSet;

// Time Complexity O(mn) where (m->arr1.length, n->arr2.length)
public class LISubsequence {
    public static int lcs(int arr1[], int arr2[]) {
        int dp[][] = new int[arr1.length + 1][arr2.length + 1];
        // Intilization dp[i][0] = dp[0][i] = 0 but in java it already initilized
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[arr1.length][arr2.length];
    }

    public static int lis(int arr1[]) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            hs.add(arr1[i]);
        }
        int arr2[] = new int[hs.size()];
        int i = 0;
        for (int num : hs) { // for each loop
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        return lcs(arr1, arr2);
    }

    public static void main(String[] args) {
        int arr[] = { 50, 3, 10, 7, 40, 80 };
        System.out.println(lis(arr));
    }
}
