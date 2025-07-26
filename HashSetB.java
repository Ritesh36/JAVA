import java.util.HashSet;
// import java.util.LinkedHashSet;
// import java.util.TreeSet;

public class HashSetB {
    public static void main(String args[]) {
        // HashSet<Integer> set = new HashSet<>();

        // set.add(1);
        // set.add(2);
        // set.add(3);
        // set.add(4);

        // System.out.println(set);

        // set.remove(2);
        // if(set.contains(2)) {
        //     System.out.println("Set contains 2");
        // }
        // set.clear();
        // System.out.println(set.size());
        // System.out.println(set.isEmpty());

        // HashSet<String> cities = new HashSet<>();
        // cities.add("Delhi");
        // cities.add("Mumbai");
        // cities.add("Noida");
        // cities.add("Benguluru");
        // System.out.println(cities);

        // LinkedHashSet<String> citiesLHS = new LinkedHashSet<>();
        // citiesLHS.add("Delhi");
        // citiesLHS.add("Mumbai");
        // citiesLHS.add("Noida");
        // citiesLHS.add("Benguluru");
        // System.out.println(citiesLHS);

        // TreeSet<String> citiesTS = new TreeSet<>();
        // citiesTS.add("Delhi");
        // citiesTS.add("Mumbai");
        // citiesTS.add("Noida");
        // citiesTS.add("Benguluru");
        // System.out.println(citiesTS);

        // int nums[] = {1,3,6,2,5,7,4,5};
        // HashSet<Integer> set = new HashSet<>();

        // for(int i=0; i<nums.length; i++) {
        //     set.add(nums[i]);
        // }

        // System.out.println("Ans : " +set.size());

        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        for(int i=0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union size : "+set.size());

        //Intersection
        set.clear();
        for(int i=0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for(int i=0; i<arr2.length; i++) {
            if(set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }

        System.out.println("Intersection el : "+count);
    }
}
