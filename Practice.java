import java.lang.reflect.Array;
import java.util.Arrays;
class Practice {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mergeArr[] = new int[m+n];

        for(int i=0; i<m; i++){
            mergeArr[i] = nums1[i];
        }

        for(int i=0; i<n; i++){
            mergeArr[m++] = nums2[i];
        }

        Arrays.sort(mergeArr);

        for(int i=0;  i<mergeArr.length; i++){
            System.out.println(mergeArr[i]);
        }

        if(mergeArr.length % 2 == 1){
            return mergeArr[mergeArr.length / 2];
        }else {
            int middle1 = mergeArr[mergeArr.length / 2 - 1];
            int middle2 = mergeArr[mergeArr.length / 2];
            return (double)(middle1 + middle2) / 2;
        }
    }

    public static boolean Question1(int nums[]){
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int Question3(int prices[]){
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i=1; i<prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            int currentProfit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        return maxProfit;
    }

    public static int trapRainWater(int[] height) {
            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            
            // Left max array
            leftMax[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            }
            
            // Right max array
            rightMax[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(height[i], rightMax[i + 1]);
            }
            
            // Calculate trapped water
            int water = 0;
            for (int i = 0; i < n; i++) {
                water += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return water;
    }

    public static int maxArea(int[] height) {
            int n = height.length;
            int leftMax[] = new int[n];
            int rightMax[] = new int[n];
            leftMax[0] = height[0];
            for(int i=0; i<n; i++){
                leftMax[i] = Math.max(leftMax[i], height[i]);
            }
            System.out.println("LeftMAx : ");
            for(int i=0;i<leftMax.length;i++){
                System.out.print(leftMax[i] + " ");
            }
            rightMax[n-1] = height[n-1];
            for(int i=n-2; i<n; i++){
                rightMax[i] = Math.max(rightMax[i], height[i]);
            }
            System.out.println("RightMax : ");
            for(int i=0;i<rightMax.length;i++){
                System.out.print(rightMax[i] + " ");
            }
            int tappedWater = 0;
            for(int i=0; i<n; i++){
                int waterLevel = Math.min(leftMax[i], rightMax[i]);
                tappedWater = tappedWater + waterLevel;
            }
            return tappedWater;
        }

    public static void mergeSort(String arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); //left part
        mergeSort(arr, mid+1, ei); //right part
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei -si + 1];
        int i = si; //iterator for left part
        int j = mid + 1; //iterator for right part
        int k = 0; //iterator for temp arr
        
        while (i <= mid && j <= ei) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= ei) {
            temp[k++] = arr[j++];
        }
        
        for (i = 0; i < temp.length; i++) {
            arr[si + i] = temp[i];
        }
    }

    public static void printArr(String arr[]) {
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static int majorityElement(int arr[]) {

        int majorityCount = arr.length / 2;

        for(int i=0; i<arr.length; i++) {
            int count = 0;
            for(int j=0; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count += 1;
                }

                if(count > majorityCount) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static int getInvCount(int arr[], int n) {
        int inv_count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    public static int removeDuplicates(int nums[]) {
        if(nums.length == 0) {
            return 0;
        }

        int i = 0;

        for(int j=1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static int missingNumber(int nums[]) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i;

        for(i=0; i<nums.length-1; i++) {
            if((nums[i] + 1) == nums[i+1]) {
                continue;
            } else {
                break;
            }
        }
        return i+1;
    }
        
    public static void main(String args[]) {
        // int height[] = {1,8,6,2,5,4,8,3,7};
        // System.out.println(maxArea(height));
        // String arr[] = {"sun", "earth", "mars", "mercury"};
        // mergeSort(arr, 0, arr.length-1);
        // printArr(arr);
        // int arr[] = {2, 2, 1, 1, 1, 1, 2, 2};
        // System.out.println(majorityElement(arr));
        // int arr[] = {1, 20, 6, 4, 5};
        // System.out.println("Inversion Count is " + getInvCount(arr, arr.length));
        // int nums[] = {0, 1, 1, 1, 2, 2, 3};
        // System.out.println(removeDuplicates(nums));
        int nums[] = {3, 0, 1};
        System.out.println(missingNumber(nums));

    }
}