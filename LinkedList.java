public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        //Step 1 - Create new node
        Node newNode = new Node(data);
        size++;
        //Step 2 - Check if the list is empty
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addLast(int data) {
        //Step 1 - Create new node
        Node newNode = new Node(data);
        size++;
        //Step 2 - Check if the list is empty
        if(head == null) {
            head = tail = newNode;
            return;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void print() {
        Node temp = head;
        if(temp == null) {
            System.out.println("List is empty");
            return;
        }
        while(temp != null) {
            System.out.print(temp.data+ " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx-1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int removeFirst() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        if(size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        Node prev = head;
        for(int i=0; i<size-2; i++) {
            prev = prev.next;
        }
        int val = tail.data;
        tail = prev;
        prev.next = null;
        size--;
        return val;
    }

    public int itrSearch(int key) {
        Node temp = head;
        if(size == 0) {
            System.out.println("LL is empty");
        }
        int i=0;
        while(i != size) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int helper(Node head, int key) {
        if(head == null) {
            return -1;
        }
        if(head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);

        if(idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public void deleteNthFromEnd(int n) {
        int sz = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            sz++;
        }

        if(n == sz) {
            head = head.next;
            return;
        }

        int i = 1;
        Node prev = head;
        int ithFromEnd = sz - n;
        while(i < ithFromEnd) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    //slow-fast Approach
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if(head == null || head.next == null) {
            return true;
        }

        // Step 1 - find Mid Node
        Node midNode = findMid(head);

        // Step 2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        // Step 3 - check 1st half and 2nd half
        Node leftNode = head;
        Node rightNode = prev;

        while(rightNode != null) {
            if(leftNode.data != rightNode.data) {
                return false;
            }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        return true;
    }

    public static boolean isCycle() { // Floyd's CFA
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        // Step - 1 Detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }
        }
        if(cycle = false) {
            return;
        }

        // Step - 2 find meeting point
        slow = head;
        Node prev = null; //last node
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
            prev = fast;
        }

        // Step - 3 remove cycle
        prev.next = null;
    }

    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node leftHalf, Node rightHalf) {
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(leftHalf != null && rightHalf != null) {
            if(leftHalf.data <= rightHalf.data) {
                temp.next = leftHalf;
                leftHalf = leftHalf.next;
                temp = temp.next;
            } else {
                temp.next = rightHalf;
                rightHalf = rightHalf.next;
                temp = temp.next;
            }
        }

        while(leftHalf != null) {
            temp.next = leftHalf;
            leftHalf = leftHalf.next;
            temp = temp.next;
        }

        while(rightHalf != null) {
            temp.next = rightHalf;
            rightHalf = rightHalf.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        //Step1 - Mid
        Node mid = getMid(head);

        //Step2 - leftHalf and rightHalf
        Node rightHead = mid.next;
        mid.next = null;
        Node leftHalf = mergeSort(head);
        Node rightHalf = mergeSort(rightHead);

        //Step3 - merge
        return merge(leftHalf, rightHalf);
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(2);
        // ll.addLast(1);

        // ll.print(); 
        // System.out.println(ll.checkPalindrome());
        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);

        ll.print();
        ll.head = ll.mergeSort(ll.head);
        ll.print();
    }
}
