package hash;

import java.util.HashMap;

// Find the largest sub array with sum of 0
public class FindLargestSubArr1 {
    public static void main(String[] args) {
        int arr[] = {15, 2, -2, -1, -7, 8, 23, 25};
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, len = 0;
        for(int i = 0; i<arr.length; i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                len = Math.max(len, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        System.out.println("The largest sub array with sum 0 is: "+len);
    }
}
