package heaps;

public class HeapSortDec {
    public static void heapify(int arr[], int idx, int size) {
        int leftChild = 2 * idx + 1;
        int rightChild = 2 * idx + 2;
        int minIdx = idx;
        if (leftChild < size && arr[leftChild] < arr[minIdx])
            minIdx = leftChild;
        if (rightChild < size && arr[rightChild] < arr[minIdx])
            minIdx = rightChild;
        if (minIdx != idx) {
            int temp = arr[minIdx];
            arr[minIdx] = arr[idx];
            arr[idx] = temp;
            heapify(arr, minIdx, size);
        }
    }

    public static void heapSort(int arr[]) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 3, 1, 2 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
