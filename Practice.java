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

        
        public static void main(String args[]){
            int height[] = {1,8,6,2,5,4,8,3,7};
            System.out.println(maxArea(height));
    }
}