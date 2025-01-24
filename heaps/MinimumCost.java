package heaps;

import java.util.PriorityQueue;

public class MinimumCost {
    public static void main(String[] args) {
        int rop[] = { 2, 3, 3, 4, 6 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < rop.length; i++) {
            pq.add(rop[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += (min1 + min2);
            pq.add(min1 + min2);
        }
        System.out.println("Minimum Cost: " + cost);
    }
}
