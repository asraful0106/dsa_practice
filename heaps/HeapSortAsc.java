package heaps;

public class HeapSortAsc {
    public static void heapify(int arr[], int idx, int size){
        int leftChild = (2*idx)+1;
        int rightChild = (2*idx)+2;
        int maxIdx = idx;
        if(leftChild < size && arr[leftChild]> arr[maxIdx]) maxIdx = leftChild;
        if(rightChild <size && arr[rightChild]>arr[maxIdx]) maxIdx = rightChild;
        if(idx != maxIdx){
            int temp = arr[maxIdx];
            arr[maxIdx] = arr[idx];
            arr[idx] = temp;
            heapify(arr, maxIdx, size);
        }
    }
    public static void heapSort(int arr[]){
        // step1: build max heap from min heap
        for(int i = arr.length/2; i>=0; i--){
            heapify(arr, i, arr.length);
        }
        // Step2: Swap and Heapify
        for(int i=arr.length-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,0, i);
        }
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
