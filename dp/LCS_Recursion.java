package dp;

// Longest Common Subset using recursion
public class LCS_Recursion {
    public static int lcs(StringBuilder str1, StringBuilder str2, int n, int m) {
        if (n == 0 || m == 0)
            return 0;

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return lcs(str1, str2, n - 1, m - 1) + 1;
        } else {
            return Math.max(lcs(str1, str2, n - 1, m), lcs(str1, str2, n, m - 1));
        }
    }

    public static void main(String[] args) {
        StringBuilder str1 = new StringBuilder("abcdge");
        StringBuilder str2 = new StringBuilder("abedg");
        System.out.println(lcs(str1, str2, str1.length(), str2.length()));
    }
}
