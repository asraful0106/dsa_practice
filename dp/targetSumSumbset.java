package dp;

public class targetSumSumbset {
    public static void print(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean targetSum(int numbers[], int targetSum) {
        boolean table[][] = new boolean[numbers.length + 1][targetSum + 1];
        // initilized column [i][0] to true
        for (int i = 0; i < table.length; i++) {
            table[i][0] = true;
        }
        // By deafult java initilized array with false so we do not need to initilized
        // row ([0][j]) with false

        for (int i = 1; i < table.length; i++) { // i represent the total numbers
            for (int j = 1; j < table[0].length; j++) { // j represent the targeted sum
                int v = numbers[i - 1];
                if (v <= j && table[i - 1][j - v] == true) {
                    table[i][j] = true;
                } else if (table[i - 1][j] == true) {
                    table[i][j] = true;
                }
            }
        }
        print(table);
        return table[numbers.length][targetSum];
    }

    public static void main(String[] args) {
        int numbers[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        System.out.println(targetSum(numbers, targetSum));
    }
}
