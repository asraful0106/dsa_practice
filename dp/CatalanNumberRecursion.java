package dp;

public class CatalanNumberRecursion {
    public static int catalanRecursion(int n) {
        // Base Case
        if (n == 0 || n == 1)
            return 1;
        // Recursion
        int ans = 0;
        for (int i = 0; i <= n - 1; i++) {
            ans += catalanRecursion(i) * catalanRecursion(n - i - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(catalanRecursion(4));
    }
}
