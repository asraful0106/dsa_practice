package heaps;

import java.util.PriorityQueue;

public class NearestCars {
    static class Cars implements Comparable<Cars>{
        int x, y, idx, disSqr;
        public Cars(int x, int y, int idx, int disSqr){
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.disSqr = disSqr;
        }
        @Override
        public int compareTo(Cars c2){
            return this.disSqr-c2.disSqr;
        }
    }
    public static void main(String[] args) {
        int pts[][] = {{3,3}, {5, -1}, {-2, 4}};
        int k = 2;
        PriorityQueue<Cars> pq = new PriorityQueue<>();
        for(int i = 0; i<pts.length; i++){
            int disSqr = pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
            pq.add(new Cars(pts[i][0], pts[i][1], i, disSqr));
        }
        for(int i = 0; i<k; i++){
            System.out.println("C"+pq.remove().idx);
        }
    }
}
