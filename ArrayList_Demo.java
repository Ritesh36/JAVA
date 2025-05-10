import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_Demo {

    //Swapping two elements in the ArrayList
    public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }

    //Maximum water in container
    //Brute Force Approach - O(n^2)
    // public static int storeWater(ArrayList<Integer>height) {
    //     int maxWater = 0;
    //     for(int i=0; i<height.size(); i++) {
    //         for(int j=i+1; j<height.size(); j++) {
    //             int ht = Math.min(height.get(i), height.get(j));
    //             int width = j - i;
    //             int currWater = ht * width;
    //             maxWater = Math.max(maxWater, currWater);
    //         }
    //     }

    //     return maxWater;
    // }

    //2 Pointer Approach - O(n)
    public static int storeWater(ArrayList<Integer> height) {
        int maxWater = 0;
        int lp = 0, rp = height.size() - 1;

        while(lp < rp) {
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            if(height.get(lp) < height.get(rp)) {
                lp ++;
            } else {
                rp --;
            }
        }
        return maxWater;
    }

    //Brute Force
    // public static void pairSum(ArrayList<Integer>arr, int target) {
    //     for(int i=0; i<arr.size(); i++) {
    //         for(int j=i+1; j<arr.size(); j++) {
    //             if(arr.get(i) + arr.get(j) == target) {
    //                 System.out.println("[" + arr.get(i)+","+ arr.get(j)+ "]");
    //             }
    //         }
    //     }
    // }

    //2 Pointer Approach
    public static void pairSum(ArrayList<Integer> arr, int target) {
        int lp = 0; 
        int rp = arr.size() - 1;
    
        while (lp < rp) { // Use lp < rp to avoid infinite loop
            int sum = arr.get(lp) + arr.get(rp);
            if (sum == target) {
                System.out.println("[" + arr.get(lp) + "," + arr.get(rp) + "]");
                lp++; // Move both pointers to avoid duplicate pairs
                rp--;
            } else if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
    }
    public static void main(String args[]) {
        // ArrayList<Integer> list = new ArrayList<>();

        // Adding elements to the ArrayList
        // for(int i=1; i<=5; i++) {
        //     list.add(i);
        // }

        // list.add(2);
        // list.add(5);
        // list.add(9);
        // list.add(3);
        // list.add(1);

        // System.out.println("ArrayList: " + list);

        // Accessing elements
        // System.out.println("Element at index 2: " + list.get(2));

        // Removing elements
        // list.remove(2); // removes the element at index 2
        // System.out.println("ArrayList after removal: " + list);

        // Setting elements
        // list.set(2, 10); // sets the element at index 2 to 10
        // System.out.println("ArrayList after setting: " + list);

        // Contains method
        // System.out.println(list.contains(5));
        // System.out.println(list.contains(10)); // false

        // Size of the ArrayList
        // System.out.println("Size of ArrayList: " + list.size());

        //Reverse Print
        // for(int i=list.size() - 1; i>=0; i--) {
        //     System.out.print(list.get(i) + " ");
        // }

        //Find maximum in the ArrayList
        // int max = Integer.MIN_VALUE; 
        // for(int i=0; i<list.size(); i++) {
            // if(max < list.get(i)) {
            //     max = list.get(i);
            // }

        //     max = Math.max(max, list.get(i));
        // }
        // System.out.println("Maximum value in the ArrayList: " + max);
        
        // swap(list, 2, 4);
        // System.out.println(list);

        // Collections.sort(list);  //ascending order
        // System.out.println(list);

        // Collections.sort(list, Collections.reverseOrder());  //descending order
        // System.err.println(list);

        //2D Arraylist
        // ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        
        // ArrayList<Integer> list1 = new ArrayList<>();
        // ArrayList<Integer> list2 = new ArrayList<>();
        // ArrayList<Integer> list3 = new ArrayList<>();

        // for(int i=1; i<=5; i++) {
        //     list1.add(i*1);
        //     list2.add(i*2);
        //     list3.add(i*3);
        // }

        // list2.remove(2);
        // list2.remove(3);
        
        // mainList.add(list1);
        // mainList.add(list2);
        // mainList.add(list3);

        // System.out.println(mainList);

        // for(int i=0; i<mainList.size(); i++) {
        //     ArrayList<Integer> currList = mainList.get(i);
        //     for(int j=0; j<currList.size(); j++) {
        //         System.out.print(currList.get(j)+ " ");
        //     }
        //     System.out.println();
        // }

        // ArrayList<Integer> height = new ArrayList<>();
        // height.add(1);
        // height.add(8);
        // height.add(6);
        // height.add(2);
        // height.add(5);
        // height.add(4);
        // height.add(8);
        // height.add(3);
        // height.add(7);

        // System.out.println(storeWater(height));

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        pairSum(arr, 5);
    }
}
