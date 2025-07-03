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

    String s = "liquid";
    String t = "tulip";

    System.out.println(isAnagram(s, t));
    }
}