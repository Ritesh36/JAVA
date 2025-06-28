import java.util.Deque;
import java.util.LinkedList;

public class DequeB {

    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            if (dq.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return dq.removeLast();
        }

        public int peek() {
            if (dq.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return dq.getLast();
        }

        public boolean isEmpty() {
            return dq.isEmpty();
        }
    }

    static class Queue {
        Deque<Integer> dq = new LinkedList<>();

        public void add(int data) {
            dq.addLast(data);
        }

        public int remove() {
            if(dq.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return dq.removeFirst();
        }

        public int peek() {
            if(dq.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            return dq.getFirst();
        }
    }
    public static void main(String args[]) {
        // Deque<Integer> dq = new LinkedList<>();
        // dq.addFirst(1);
        // dq.addFirst(2);
        // dq.addFirst(3);
        // dq.addLast(4);
        // dq.addLast(5);
        // dq.addLast(6);

        // dq.removeFirst();
        // dq.removeLast();

        // System.out.println("First Element: " + dq.getFirst());
        // System.out.println("Last Element: " + dq.getLast());

        // System.out.println("Initial Deque: " + dq);

        // Stack s = new Stack();
        // s.push(10);
        // s.push(11);
        // s.push(12);
        // System.out.println("Top Element: " + s.peek());
        // System.out.println("Popped Element: " + s.pop());

        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Peek : " + q.peek());
    }
}
