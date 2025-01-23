package heaps;

import java.util.ArrayList;

public class PeekInHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int val){
            arr.add(val);
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while(arr.get(x)>arr.get(parent)){
                int temp = arr.get(x);
                arr.set(x, arr.get(parent));
                arr.set(parent, temp);
                x = parent;
                parent = (x-1)/2;
            }
        }
        public int peek(){
            return arr.get(0);
        }
    }
}
