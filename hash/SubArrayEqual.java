package hash;

import java.util.HashMap;

public class SubArrayEqual {
    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, subArr = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                subArr += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        System.out.println("Total sub array where summition of all item is " + k + " are-> " + subArr);
    }
}
