public class Q22_KthNodeFromEnd {

    // 输入一个链表，输出该链表的倒数第K个节点。
    // 为符合大多数人的习惯，本题从1开始计数，记链表的尾节点是倒数第一个节点。
    // 例如：一个链表有6个节点，从头结点开始的话，他们的值依次是1，2，3，4，5，6.
    // 这个链表的倒数第三个节点是值为4的节点。

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pAhead = head;
        ListNode pBehind = null;

        // pAhead 先走k-1步，pBehind - pAhead + 1 == k
        for (int i = 0; i < k - 1; i++) {
            if (pAhead.next != null) {
                pAhead = pAhead.next;
            } else {
                return null;
            }
        }
        pBehind = head;
        while (pAhead.next != null) {
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
    }

    public static void main(String[] args) {
        Q22_KthNodeFromEnd obj = new Q22_KthNodeFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println(obj.findKthNodeFromEnd(head, 0) == null ? "null" : obj.findKthNodeFromEnd(head, 0).val);
        System.out.println(obj.findKthNodeFromEnd(head, 1).val);
        System.out.println(obj.findKthNodeFromEnd(head, 2).val);
        System.out.println(obj.findKthNodeFromEnd(head, 3).val);
        System.out.println(obj.findKthNodeFromEnd(head, 4).val);
        System.out.println(obj.findKthNodeFromEnd(head, 5).val);
        System.out.println(obj.findKthNodeFromEnd(head, 6).val);
        System.out.println(obj.findKthNodeFromEnd(null, 6) == null ? "null" : obj.findKthNodeFromEnd(null, 6).val);
    }
}
