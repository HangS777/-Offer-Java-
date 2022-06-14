public class Q25_MergeSortedLists {

    //输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
    //例如： 链表一： 1 -> 3 -> 5 -> 7
    //      链表二： 2 -> 4 -> 6 -> 8
    //输出： 链表三： 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode mergeSortedLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        ListNode newHead = null;
        if(head1.val <= head2.val) {
            newHead = head1;
            newHead.next = mergeSortedLists(head1.next, head2);
        }else{
            newHead = head2;
            newHead.next = mergeSortedLists(head2.next, head1);
        }
        return newHead;
    }

    public static void main(String[] args) {
        Q25_MergeSortedLists obj = new Q25_MergeSortedLists();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(8);

        ListNode newHead = obj.mergeSortedLists(head, head2);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

        System.out.println("\n=================");

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(1);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(3);

        ListNode head4 = new ListNode(2);
        head4.next = new ListNode(3);
        head4.next.next = new ListNode(4);
        head4.next.next.next = new ListNode(4);

        ListNode newHead2 = obj.mergeSortedLists(head3, head4);
        while (newHead2 != null) {
            System.out.print(newHead2.val + " ");
            newHead2 = newHead2.next;
        }
    }
}
