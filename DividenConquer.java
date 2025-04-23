public class DividenConquer {

    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei);  //right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; //iterator for left part
        int j = mid + 1; //iterator for right part
        int k = 0; //iterator for temp arr

        while(i <= mid && j <= ei) {
           if(arr[i] < arr[j])  {
            temp[k] = arr[i];
            i++;
           } else {
            temp[k] = arr[j];
            j++;
           }
           k++;
        }

        //left part
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

        //right part
        while(j <= ei) {
            temp[k++] = arr[j++];
        }

        //copy temp to original arr
        for(k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); //left part
        quickSort(arr, pIdx + 1, ei); //right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; //to make place els smaller than pivot

        for(int j=si; j<ei; j++) {
            if(arr[j] <= pivot) { 
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static int search(int arr[], int tar, int si, int ei) {
        //base case
        if(si > ei) {
            return -1;
        }

        //calculate mid
        int mid = si + (ei - si) / 2;

        // IF FOUND
        if(arr[mid] == tar) {
            return mid;
        }

        //MID ON L1
        if(arr[si] <= arr[mid]) {
            // case a : left
            if(arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                //case b : right
                return search(arr, tar, mid + 1, ei);
            }
        }

        //MID ON L2
        else {
            //case c : right
            if(arr[mid] <= tar && tar <= arr[ei]) {  
                return search(arr, tar, mid + 1, ei);  
            } else {
                //case d : left
                return search(arr, tar, si, mid - 1); 
            }
        }
    }
    public static void main(String args[]) {
        // int arr[] = {6, 3, 9, 5, 2, 8};
        // mergeSort(arr, 0, arr.length-1);
        // quickSort(arr, 0, arr.length - 1);
        // printArr(arr);
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int tarIdx = search(arr, 5, 0, arr.length-1);
        System.out.println(tarIdx);
    }
}
