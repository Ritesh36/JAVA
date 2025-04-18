public class ArrayCC {

    public static int linearSearch(int numbers[], int key){
        for(int i=0; i<=numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int getLargest(int numbers[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(largest < numbers[i]){
                largest = numbers[i];
            }
        }
        return largest;
    }

    public static int getSmallest(int numbers[]){
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++){
            if(smallest > numbers[i]){
                smallest = numbers[i];
            }
        }
        return smallest;
    }

    public static int binarySearch(int numbers[], int key){//needs sorted array
        int start = 0;
        int end = numbers.length;
        int mid;

        mid = (start+end)/2;

        while(start <= end){

           if(numbers[mid] == key){
                return mid;
           } else if(numbers[mid] < key){
                start = mid + 1;
           } else {
                end = mid - 1;
           }
        }
        return -1;
    }

    public static void reverseArr(int numbers[]){
        // int reverseArr[] = new int[numbers.length];
        // int j=0;
        // for(int i=numbers.length-1; i>=0; i--){
        //     reverseArr[j++] = numbers[i];
        // }
        // for(int i=0; i<reverseArr.length; i++){
        //     System.out.println(reverseArr[i]);
        // }
        int first = 0;
        int last = numbers.length - 1;

        while (first < last){

            int temp = numbers[last];
            numbers[last] = numbers[first];
            numbers[first] = temp;

            first++;
            last--;
        }
    }

    public static void pairArr(int numbers[]){
        int tp = 0;
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                System.out.print("("+numbers[i]+", "+numbers[j]+") ");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Nos of pairs = " + tp);
    }

    public static void subArray(int numbers[]){
       
        for(int i=0; i<numbers.length; i++){
            int start = i;
            for(int k=i;k<numbers.length;k++){
                int end = k;
                for(int j=start; j<=end; j++){
                    System.out.print(numbers[j]+" ");
                }
                System.out.println();
            } 
            System.out.println();   
        }
    }

    public static void maxSubArraySum(int numbers[]){
        //Most Optimal Solution(kadanes algorithm)
        int maxSum = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0; i<numbers.length; i++){
            cs = cs + numbers[i];
            if(cs < 0){
                cs = 0;
            }
            maxSum = Math.max(maxSum, cs);
        }
        System.out.println("Max Sum : " + maxSum);
    }

    public static int trappedRainWater(int height[]){
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int[height.length];
        rightMax[height.length-1] = height[height.length-1];
        for(int i=height.length - 2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i=0; i<height.length; i++){
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            // trappedWater += waterLevel - height[i];
            trappedWater = trappedWater + (waterLevel - height[i]);
        }

        return trappedWater;
    }


    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0; // No profit can be made with 0 or 1 day
        }

        int minPrice = prices[0]; // Initialize the minimum price to the first day's price
        int maxProfit = 0; // Initialize the maximum profit to 0

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price if a lower price is found
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate the profit if selling on the current day
            int currentProfit = prices[i] - minPrice;

            // Update the maximum profit if the current profit is higher
            maxProfit = Math.max(maxProfit, currentProfit);
        }

        return maxProfit;
    }

    public static int twoSumPair(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;
        int currSum = 0;
        int count = 0;
    
        while(start < end){
            currSum = nums[start] + nums[end];
            if(currSum == target){
                count++;
                start++;
                end --;
            } else if(currSum < target){
                start++;
            } else {
                end--;
            }
        }
        return count;
    }
    

    public static void main(String args[]){
    
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        // System.out.println(binarySearch(nums, 3));
        // System.out.println(twoSumPair(nums, target));
        int height[] = {4, 2, 6, 3, 2, 5};
        System.out.println(trappedRainWater(height));
        // subArray(nums);
    }
}
