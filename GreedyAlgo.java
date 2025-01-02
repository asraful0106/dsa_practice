import java.util.Arrays;
import java.util.Collections;

public class GreedyAlgo {
    public static void main(String[] args) {
        Integer costVer[] = { 2, 1, 3, 1, 4 }; // m-1
        Integer costHor[] = { 4, 1, 2 }; // n-1

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int v = 0, h = 0;
        int vCount = 1, hCount = 1;
        int cost = 0;

        while (v < costVer.length && h < costHor.length) {
            if (costVer[v] >= costHor[h]) {
                cost += (costVer[v] * hCount);
                v++;
                vCount++;
            } else {
                cost += (costHor[h] * vCount);
                h++;
                hCount++;
            }
        }
        while (v < costVer.length) {
            cost += (costVer[v] * hCount);
            v++;
            vCount++;
        }
        while (h < costHor.length) {
            cost += (costHor[h] * vCount);
            h++;
            hCount++;
        }
        System.out.println("Minmum cost to cut the cochlate: " + cost);
    }
}
