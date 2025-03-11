package dp;

public class fibonacci {
    public static int fibo(int n, int f[]) {
        if (n == 0 || n == 1)
            return n;

        if (f[n] != 0)
            return f[n];
        return f[n] = fibo(n - 1, f) + fibo(n - 2, f);
    }

    public static void main(String[] args) {
        int n = 6;
        int f[] = new int[n + 1];
        System.out.println("Fibbonacci of " + n + " is: " + fibo(n, f));
    }
}
