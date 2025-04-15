public class RecursionBasics {

    //Print Decreasing Order
    public static void printDec(int n) {
        if(n == 1) {
            return;
        }
        System.out.print(n+ " ");
        printDec(n - 1);
        //Output: 10 9 8 7 6 5 4 3 2 1
    }

    //Print Increasing Order
    public static void printInc(int n) {
        if(n == 1) {
            System.out.print(1+ " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
        //Output: 1 2 3 4 5 6 7 8 9 10
    }

    //Print Factorial
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        int fn = n * factorial(n-1);
        return fn;
        //Output: 120
    }

    //Print sum of N natural nos.
    public static int sumOfNatural(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sumOfNatural(n-1);
    }

    //calculate nth number of fibonacci
    public static int fibn(int n) {
        if(n==0 || n==1) {
            return n;
        }

        return fibn(n - 1) + fibn(n - 2);
    }

    //check array is sorted or not
    public static boolean isSorted(int arr[], int i) {
        if(i == arr.length-1) {
            return true;
        }

        if(arr[i] > arr[i+1]) {
            return false;
        }

        return isSorted(arr, i+1);
    }

    //find first occurence of no.
    public static int firstOccurence(int arr[], int key, int i) {
        if(i == arr.length - 1) {
            return -1;
        }

        if(arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i+1);
    }
   
    public static void main(String[] args) {
        // printDec(10);
        // printInc(10);
        // System.out.println(factorial(5));
        // System.out.println(sumOfNatural(5));
        // System.out.println(fibn(10));
        int arr[] = {8, 6, -2, 4, 7, 10, 1, 3};
        // System.out.println(isSorted(arr, 0));
        System.out.println(firstOccurence(arr, 4, 0));
    }
}
