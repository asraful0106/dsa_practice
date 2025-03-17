package dp;

public class o1_knapsak {
    public static int knapsak(int val[], int wt[], int capacity, int n) {
        if (capacity == 0 || n == 0)
            return 0;
        if (wt[n - 1] <= capacity) {
            // Insert in bag
            int ans1 = val[n - 1] + knapsak(val, wt, capacity - wt[n - 1], n - 1);
            // Discard from bag
            int ans2 = knapsak(val, wt, capacity, n - 1);
            return Math.max(ans1, ans2);
        } else {
            return knapsak(val, wt, capacity, n - 1);
        }
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int capacity = 7;
        System.out.println(knapsak(val, wt, capacity, val.length));
    }
}
