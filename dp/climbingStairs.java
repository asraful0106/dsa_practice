package dp;

public class climbingStairs {
    public static int countWays(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        return countWays(n - 1) + countWays(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(countWays(5));
    }
}
