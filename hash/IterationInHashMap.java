package hash;

import java.util.HashMap;
import java.util.Set;

public class IterationInHashMap {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Bangladesh", 100);
        hm.put("India", 5);
        hm.put("Pakistan", 67);
        hm.put("China", 80);

        Set<String> allKey = hm.keySet();
        for (String key : allKey) {
            System.out.println("Key: "+key);
            System.out.println("Value: "+hm.get(key));
            System.out.println();
        }
    }
}
