package dp;

// Matrix Cain Multiplication (MCM)
public class McmRecursion {
    public static int mcm(int[] matrix, int i, int j) {
        if (i == j)
            return 0;

        int minimumCost = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int finalCost = mcm(matrix, i, k) + mcm(matrix, k + 1, j) + (matrix[i - 1] * matrix[k] * matrix[j]);
            minimumCost = Math.min(minimumCost, finalCost);
        }
        return minimumCost;
    }

    public static void main(String[] agrs) {
        int[] matrix = { 1, 2, 3, 4, 3 };
        System.out.println(mcm(matrix, 1, matrix.length-1));
    }
}
