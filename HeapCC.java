import java.util.*;

public class HeapCC {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1; //child idx
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)) { //O(log n)
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
            }
        }

        public int peek() {
            return arr.get(0);
        }
    }
    public static void main(String args[]) {

    }
}
