package hash;

import java.util.HashSet;

public class CountDistintElement {
    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 2, 5, 2, 4, 6, 3, 6, 7, 8, 9, 0, 1 };
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        System.out.println("Total Distint Element: " + set.size());
    }
}
