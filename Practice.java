class Practice{
    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void quickSort(int arr[], int si, int ei){
        if(si>=ei)
            return;
        int pidx = pertition(arr, si, ei);
        quickSort(arr, si, pidx-1);
        quickSort(arr, pidx+1, ei);
    }
    public static int pertition(int arr[], int si, int ei){
        int pivot = arr[ei];
        int i = si-1;
        for(int j=si; j<ei; j++){
            if(arr[j]>pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = pivot;
        return i;
    }
    public static void main(String [] args){
        int arr[] = { 5, 1, 0, 6, 4, 9, 2, 10, 3, 8, 7 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}