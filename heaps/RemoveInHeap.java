package heaps;

import java.util.ArrayList;

public class RemoveInHeap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int val){
            arr.add(val);
            int x = arr.size()-1;
            int parent = (x-1)/2;
            while (arr.get(x)<arr.get(parent)) {
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
        private void hipify(int idx){
            int leftChild = (2*idx)+1;
            int rightChild = (2*idx)+2;
            int minmumIdx = idx;

            if(leftChild<arr.size() && arr.get(leftChild)<arr.get(minmumIdx)) minmumIdx = leftChild;
            if(rightChild < arr.size() && arr.get(rightChild)<arr.get(minmumIdx)) minmumIdx = rightChild;
            if(minmumIdx != idx){
                int temp = arr.get(idx);
                arr.set(idx, arr.get(minmumIdx));
                arr.set(minmumIdx, temp);
                hipify(minmumIdx);
            }
        }
        public int remove(){
            // step1: swap the last index with the first index
            if(arr.size()>0){
                int temp = arr.get(0);
                arr.set(0, arr.get(arr.size()-1));
                arr.set(arr.size()-1, temp);
            }else{
                System.out.println("Empty Heap!");
            }

            // step2: Remove the last index
            int data = arr.remove(arr.size()-1);

            // step3: hipify
            hipify(0);

            return data;
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }
    public static void main(String[] args) {
        Heap hp = new Heap();
        hp.add(3);
        hp.add(4);
        hp.add(1);
        hp.add(5);
        while (!hp.isEmpty()) {
            System.out.print(hp.remove()+" ");
        }
        System.out.println();
    }
}
