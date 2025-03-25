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
    public static void main(String[] args) {
    //    String fruits[] = {"apple", "banana", "mango"};

    //    String largest = fruits[0];

    //    for(int i=1; i<fruits.length; i++){
    //     if(largest.compareTo(fruits[i]) < 0){
    //         largest = fruits[i];
    //     }
    //    }
    //    System.out.println(largest);

    String str = "aaabbbcd";
    System.out.println(stringCompress(str));
    }
}