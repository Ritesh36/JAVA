import java.util.Deque;
import java.util.LinkedList;

public class DequeB {
    public static void main(String args[]) {
        Deque<Integer> dq = new LinkedList<>();
        dq.addFirst(1);
        dq.addFirst(2);
        dq.addFirst(3);
        dq.addLast(4);
        dq.addLast(5);
        dq.addLast(6);

        dq.removeFirst();
        dq.removeLast();

        System.out.println("First Element: " + dq.getFirst());
        System.out.println("Last Element: " + dq.getLast());

        System.out.println("Initial Deque: " + dq);
    }
}
