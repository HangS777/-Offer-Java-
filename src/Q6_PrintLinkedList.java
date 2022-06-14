
import java.util.*;

public class Q6_PrintLinkedList {

    //输入一个链表的头结点，从尾到头返过来
    //打印出每个结点的值。链表结点定义如下：
    public static class Node {
        int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public void PrintLinkedListFromTailToHead1(Node node) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            stack.push(node.val);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.printf("%d\s", stack.pop());
        }

    }


    public void PrintLinkedListFromTailToHead2(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        if (node != null) {
            if (node.next != null) {
                PrintLinkedListFromTailToHead2(node.next);
            }
            System.out.printf("%d\s", node.val);
        }
    }

    public static void main(String[] args) {
        Q6_PrintLinkedList obj = new Q6_PrintLinkedList();
        Node node = new Node(0);
        node.next = new Node(1);
        node.next.next = new Node(2);
        node.next.next.next = new Node(3);
        node.next.next.next.next = new Node(4);
        node.next.next.next.next.next = new Node(5);
        obj.PrintLinkedListFromTailToHead1(node);
        System.out.println();
        obj.PrintLinkedListFromTailToHead2(node);

    }
}
