public class Q52_CommonNodeInLists {

    // 输入两个链表，找出他们的第一个公共节点。

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode temp1 = head1;
        ListNode temp2 = head2;
        int n = 0;

        while (temp1 != null) {
            n++;
            temp1 = temp1.next;
        }
        while (temp2 != null) {
            n--;
            temp2 = temp2.next;
        }
        // 如果两个链表最后一个节点不一样那么就说明这两个链表不相交
        if (temp1 != temp2) {
            return null;
        }
        // 看看哪个链表长
        temp1 = n > 0 ? head1 : head2;
        temp2 = temp1 == head1 ? head2 : head1;
        n = Math.abs(n);
        // 长链表先走差值步
        while (n > 0) {
            temp1 = temp1.next;
            n--;
        }
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    public static void main(String[] args) {
        Q52_CommonNodeInLists obj = new Q52_CommonNodeInLists();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(6);
        head1.next.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = head1.next.next.next;

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(6);
        head3.next.next.next.next = new ListNode(7);

        System.out.println(obj.findFirstCommonNode(head1, head2).val);
        System.out.println(obj.findFirstCommonNode(head2, head3));
        System.out.println(obj.findFirstCommonNode(head1, head3));
    }
}
