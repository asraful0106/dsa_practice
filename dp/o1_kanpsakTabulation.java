package dp;

public class o1_kanpsakTabulation {
    public static void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int knapsakTabu(int val[], int wt[], int capacity) {
        int table[][] = new int[wt.length + 1][capacity + 1];
        for (int i = 0; i < table.length; i++) { // intilized (i, 0) calumn with 0
            table[i][0] = 0;
        }
        for (int j = 0; j < table[0].length; j++) { // intilized (0, j) row with 0
            table[0][j] = 0;
        }

        // here i = given weight and j = given capacity (knapsak)
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[0].length; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + table[i - 1][j - w];
                    int excProfit = table[i - 1][j];
                    table[i][j] = Math.max(incProfit, excProfit);
                } else {
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        print(table);
        return table[wt.length][capacity];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int capacity = 7;
        System.out.println(knapsakTabu(val, wt, capacity));
    }
}
