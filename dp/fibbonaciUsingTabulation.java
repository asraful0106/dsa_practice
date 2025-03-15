package dp;

public class fibbonaciUsingTabulation {
    public static int fiboTabulation(int n) {
        int tab[] = new int[n + 1];
        // Initialization
        // tab[0] = 0; we do not need to initilize this because in java it's
        // autometically assigned that
        tab[1] = 1;

        for (int i = 2; i < tab.length; i++) {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }

    public static void main(String[] args) {
        System.out.println("Fibbo: " + fiboTabulation(5));
    }
}
