package dp;

public class climbingStairsTabulation {
    public static int climbTabulation(int n) {
        int table[] = new int[n + 1];
        // Intitilized the known value
        table[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                table[i] = table[i - 1];
            } else {
                table[i] = table[i - 1] + table[i - 2];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(climbTabulation(5));
    }
}
