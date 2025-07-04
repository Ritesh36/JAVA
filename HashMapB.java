import java.util.*;

public class HashMapB {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            if(map.get(ch) != null) {
                if(map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
            } else {
                return false;
            }
        }

        return map.isEmpty();
    }

    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();

        for(String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }

        for(String key : tickets.keySet()) {
            if(!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }
    
    public static void main(String args[]) {
    //    int nums[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};

    //    HashMap<Integer, Integer> map = new HashMap<>();
    //    for(int i=0; i<nums.length; i++) {

    //     if(map.containsKey(nums[i])) {
    //         map.put(nums[i], map.get(nums[i]) + 1);
    //     } else {
    //         map.put(nums[i], 1);
    //     }

    //     OR

    //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

    //    }

    //    for (int i : map.keySet()) {
    //     if(map.get(i) > nums.length/3) {
    //         System.out.println(i);
    //     }
    //    }

    // String s = "liquid";
    // String t = "tulip";

    // System.out.println(isAnagram(s, t));
    // HashMap<String, String> tickets = new HashMap<>();
    // tickets.put("Chennai", "Bengaluru");
    // tickets.put("Mumbai", "Delhi");
    // tickets.put("Goa", "Chennai");
    // tickets.put("Delhi", "Goa");

    // String start = getStart(tickets);
    // System.out.print(start);

    // for(String key : tickets.keySet()) {
    //     System.out.print("-> "+ tickets.get(start));
    //     start = tickets.get(start);
    // }
    // System.out.println();

    // int arr[] = {15, 2, -2, -8, 1, 7, 10, 23}; //O(n)

    // HashMap<Integer, Integer> map = new HashMap<>();

    // int sum = 0;
    // int len = 0;

    // for(int j=0; j<arr.length; j++) {
    //     sum += arr[j];
    //     if(map.containsKey(sum)) {
    //         len = Math.max(len, j - map.get(sum));
    //     } else {
    //         map.put(sum, j);
    //     }
    // }

    // System.out.println("Largest subarray of sum zero is : "+ len);

    int arr[] = {1, 2, 3};
    int k = 3;

    HashMap<Integer, Integer> map = new HashMap<>();

    map.put(0, 1);

    int sum = 0;
    int ans = 0;

    for(int i=0; i<arr.length; i++) {
        sum += arr[i];
        if(map.containsKey(sum - k)) {
            ans += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum, 0) + 1);
    }
    System.out.println(ans);
    }
}