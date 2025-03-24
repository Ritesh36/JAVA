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
    public static void main(String[] args) {
        // String str = "madam";
        String path = "NNNWESWE";

    //    System.out.println(isPalindrome(str));
    System.out.println(getShortestPath(path));
    }
}