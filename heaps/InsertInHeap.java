package heaps;

import java.util.ArrayList;

public class InsertInHeap {
    public static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while (arr.get(x)>arr.get(parent)) {
                int temp = arr.get(parent);
                arr.set(parent, arr.get(x));
                arr.set(x, temp);

                x = parent;
                parent = (x-1)/2;
            }
        }
    }
    public static void main(String[] args) {
        // Heap hp = new Heap();
        // hp.add(2);
        // hp.add(3);
        // hp.add(4);
        // hp.add(5);
        // hp.add(10);
        // hp.add(1);
        // for(int i=0; i<hp.arr.size(); i++){
        //     System.out.print(hp.arr.get(i)+" ");
        // }
    }
}
