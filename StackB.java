import java.util.*;

public class StackB {

    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for(char i=0; i<str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder result = new StringBuilder("");

        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        
        return result.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stocks[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice >= stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i]  = i - prevHigh;
            }
            s.push(i);
        }
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if( ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                if( (s.peek() == '(' && ch == ')') || (s.peek() == '{' && ch == '}') || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);

        // reverseStack(s);
        // printStack(s);

        // pushAtBottom(s, 4);

        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);
        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i=0; i<span.length; i++) {
        //     System.out.print(span[i]+" ");
        // }

        String str = "({[]})()";
        System.out.println(isValid(str));
    }
}
