public class Q24_ReverseList {

    // 定义一个函数，输入一个链表的头节点，
    // 反转该链表并输出反转后链表的头几点。

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Q24_ReverseList obj = new Q24_ReverseList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode newHead = obj.reverseList(head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

        System.out.println("\n=================");

        ListNode head2 = new ListNode(1);
        ListNode newHead2 = obj.reverseList(head2);
        while (newHead2 != null) {
            System.out.print(newHead2.val);
            newHead2 = newHead2.next;
        }
        System.out.println("\n=================");

        ListNode newHead3 = obj.reverseList(null);
        System.out.println(newHead3);
    }
}
