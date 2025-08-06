import java.util.*;

class Practice {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int mergeArr[] = new int[m + n];

        for (int i = 0; i < m; i++) {
            mergeArr[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            mergeArr[m++] = nums2[i];
        }

        Arrays.sort(mergeArr);

        for (int i = 0; i < mergeArr.length; i++) {
            System.out.println(mergeArr[i]);
        }

        if (mergeArr.length % 2 == 1) {
            return mergeArr[mergeArr.length / 2];
        } else {
            int middle1 = mergeArr[mergeArr.length / 2 - 1];
            int middle2 = mergeArr[mergeArr.length / 2];
            return (double) (middle1 + middle2) / 2;
        }
    }

    public static boolean Question1(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int Question3(int prices[]) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
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
        for (int i = 0; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i], height[i]);
        }
        System.out.println("LeftMax : ");
        for (int i = 0; i < leftMax.length; i++) {
            System.out.print(leftMax[i] + " ");
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i < n; i++) {
            rightMax[i] = Math.max(rightMax[i], height[i]);
        }
        System.out.println("RightMax : ");
        for (int i = 0; i < rightMax.length; i++) {
            System.out.print(rightMax[i] + " ");
        }
        int tappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            tappedWater = tappedWater + waterLevel;
        }
        return tappedWater;
    }

    public static void mergeSort(String arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei);
    }

    public static void merge(String arr[], int si, int mid, int ei) {
        String temp[] = new String[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp arr

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
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int majorityElement(int arr[]) {
        int majorityCount = arr.length / 2;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count += 1;
                }

                if (count > majorityCount) {
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
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static int missingNumber(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int i;

        for (i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + 1) == nums[i + 1]) {
                continue;
            } else {
                break;
            }
        }
        return i + 1;
    }

    public static int maxSumSubArray(int arr[]) {
        int cs = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            cs = Math.max(arr[i], cs + arr[i]);
            maxSum = Math.max(maxSum, cs);
        }
        return maxSum;
    }

    public boolean isSorted(ArrayList<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) <= nums.get(i + 1)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static int fruitsInBasket(ArrayList<Integer> fruits) {
        int maxFruits = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < fruits.size()) {
            map.put(fruits.get(right), map.getOrDefault(fruits.get(right), 0) + 1);
            while (map.size() > 2) {
                map.put(fruits.get(left), map.get(fruits.get(left)) - 1);
                if (map.get(fruits.get(left)) == 0) {
                    map.remove(fruits.get(left));
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }
        return maxFruits;
    }

    public static int largest(int arr[]) {
        int max = Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int secondLargest(int arr[]) {
        int firstLargest = largest(arr);

        for(int i=0; i<arr.length; i++) {
            if(arr[i] == firstLargest) {
                arr[i] = Integer.MIN_VALUE;
            }
        }

        int secondLargest = largest(arr);

        return secondLargest;
    }

    public static void swap(int a, int b) {
        System.out.println("Brfore Swapping :");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        a = a + b; //9 + 3 = 12
        b = a - b; //12 - 3 = 9
        a = a - b; //12 - 9 = 3
        System.out.println("After Swapping :");
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

   /**
    * The `rotateArray` function rotates an input array by a specified number of positions to the
    * right.
    * 
    * @param arr The `arr` parameter is an integer array that represents the array you want to rotate.
    * @param k The parameter `k` in the `rotateArray` method represents the number of positions by
    * which you want to rotate the array elements. If `k` is positive, the array elements will be
    * rotated to the right by `k` positions. If `k` is negative, the array elements will
    * @return The `rotateArray` method returns an integer array that is the result of rotating the
    * input array `arr` by `k` positions to the right.
    */
    public static int[] rotateArray(int arr[], int k) {
        int ans[] = new int[arr.length];
        int j = 0;
        int n = arr.length;
        k = k % n;

        for(int i=n-k; i<n; i++) {
            ans[j++] = arr[i];
        }

        for(int i=0; i<n-k; i++) {
            ans[j++] = arr[i];
        }

        return ans;
    }

    public static int searchInArray(int arr[], int i, int target) {
        if(i >= arr.length) {
            return -1;
        }
        if(arr[i] == target) {
            return i;
        }
        return searchInArray(arr, i + 1, target);
    }

    public static ArrayList<Integer> findAllIndices(int arr[], int i, int target) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(i >= arr.length) return ans;

        if(arr[i] == target) {
            ans.add(i);
        }

        ArrayList<Integer> smallAns = findAllIndices(arr, i + 1, target);
        ans.addAll(smallAns);

        return ans;
    }

    public static boolean isSorted(int arr[], int i) {
        if(i >= arr.length - 1) {
            return true;
        }

        if(arr[i] > arr[i + 1]) return false;

        return isSorted(arr, i + 1);
    }

    /**
     * The function recursively prints all possible subsequences of a given string.
     * 
     * @param str The `str` parameter in the `printSubsequences` method represents the input string for
     * which we want to find all possible subsequences. This method recursively generates all
     * subsequences of the input string and prints them out.
     * @param ans The `ans` parameter in the `printSubsequences` method is used to store the current
     * subsequence being generated during the recursive calls. It starts as an empty string and gets
     * updated as characters are added to form subsequences.
     */
    public static void printSubsequences(String str, String ans) {
        if(str.length() == 0) {
            System.out.println(ans);
            return;
        }

        printSubsequences(str.substring(1), ans + str.charAt(0));
        printSubsequences(str.substring(1), ans);
    }

    /**
     * The function `moveZerosToEnd` iterates through an array and moves all zeros to the end while
     * maintaining the relative order of non-zero elements.
     * 
     * @param arr The `arr` parameter is an integer array that contains elements to be sorted with
     * zeros moved to the end of the array. The `moveZerosToEnd` method iterates through the array and
     * swaps elements to move zeros to the end while maintaining the relative order of non-zero
     * elements.
     */
    public static void moveZerosToEnd(int arr[]) {
        for(int i=0; i<arr.length - 1; i++) {
            for(int j=0; j<arr.length - i - 1; j++) {
                if(arr[j] == 0 && arr[j+1] != 0) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void printArr(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * The function `sortFruits` implements selection sort to sort an array of strings in ascending
     * order.
     * 
     * @param fruits The `sortFruits` method you provided is a simple implementation of selection sort
     * for sorting an array of strings in ascending order. It iterates through the array and finds the
     * minimum element in the unsorted portion of the array, then swaps it with the element at the
     * current position.
     */
    public static void sortFruits(String fruits[]) {
        int n = fruits.length;
        for(int i=0; i<n-1; i++) {
            int min_Idx = i;
            for(int j=i+1; j<n; j++) {
                if(fruits[j].compareTo(fruits[min_Idx]) < 0) {
                    min_Idx = j;
                }
            }
            String temp = fruits[i];
            fruits[i] = fruits[min_Idx];
            fruits[min_Idx] = temp;
        }
    }

    public static void main(String args[]) {
        // int arr[] = {0, 1, 0, 3, 12};
        // moveZerosToEnd(arr);
        String fruits[] = {"banana", "apple", "orange", "kiwi", "grape"};
        sortFruits(fruits);
        printArr(fruits);

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
        // int nums[] = {3, 0, 1};
        // System.out.println(missingNumber(nums));
        // int arr[] = {-5, -4, -3};
        // System.out.println(maxSumSubArray(arr));
        // ArrayList<Integer> fruits = new ArrayList<>();
        // fruits.add(3);
        // fruits.add(3);
        // fruits.add(3);
        // fruits.add(1);
        // fruits.add(2);
        // fruits.add(1);
        // fruits.add(0);
        // System.out.println(fruitsInBasket(fruits));
        // int arr[] = { 9, 8, 9, 6, 9, 5, 8 };
        // System.out.println(secondLargest(arr));

        // int a = 9;
        // int b = 3;
        // swap(a, b);

        // int arr[] = {1, 2, 3, 4, 0};
        // System.out.println(findAllIndices(arr, 0, 4));
        // System.out.println(isSorted(arr, 0));
    }
}