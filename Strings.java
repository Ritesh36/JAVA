import java.util.Arrays;

public class Strings {

    public static boolean isPalindrome(String str){
        // int first = 0;
        // int last = str.length() - 1;

        // while(first <= last){
        //     if(str.charAt(first) != str.charAt(last)){
        //         System.out.println("Not a palindrome!");
        //         return;
        //     } else {
        //         first++;
        //         last--;
        //     }
        // } 
        // System.out.println("Palindrome");

        int n = str.length();
        for(int i = 0; i < n/2; i++){
            if(str.charAt(i) != str.charAt(n-i-1)){
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String path){
        int x=0, y=0;
        for(int i=0; i<path.length(); i++){
            char dir = path.charAt(i);

            //NORTH
            if(dir == 'N'){
                y++;
            } 

            //SOUTH
            else if(dir == 'S'){
                y--;
            }

            //EAST
            else if(dir == 'E'){
                x++;
            }

            //WEST
            else {
                x--;
            }
        }

        float X2 = x*x;
        float Y2 = y*y;

        return (float)Math.sqrt(X2 + Y2);
    }

    public static String toUpperCase(String str) {

        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length() - 1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static String stringCompress(String str) {
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static int lengthOfLongestString(String str) {
        int lastIndex[] = new int[128];
        for(int i=0; i<lastIndex.length; i++) {
            lastIndex[i] = -1;
        }

        int maxLength = 0;
        int start = 0;

        for(int end=0; end<str.length(); end++){
            char currentChar = str.charAt(end);

            if(lastIndex[currentChar] >= start) {
                start = lastIndex[currentChar] + 1;
            }
            lastIndex[currentChar] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static int countOfLowercase(String str) {
        int count = 0;

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'A' || ch == 'a' || ch == 'E' || ch == 'e' || ch == 'I' || ch == 'i' || ch == 'O' || ch == 'o' || ch == 'U' || ch == 'u'){
                count ++;
            }
        }
        return count;
    }

    public static boolean isAnagram(String s, String t) {
        int count[] = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int i=0; i<count.length; i++){
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "smart";
        String str2 = "heart";

        if(str1.length() == str2.length()){
            str1.toLowerCase();
            str2.toLowerCase();

            char str1CharArray[] = str1.toCharArray();
            char str2CharArray[] = str2.toCharArray();

            Arrays.sort(str1CharArray);
            Arrays.sort(str2CharArray);

            boolean result = Arrays.equals(str1CharArray, str2CharArray);

            if(result){
                System.out.println(str1 + " and " + str2 + " are anagrams of each other");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
            }
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
        }
    }
}