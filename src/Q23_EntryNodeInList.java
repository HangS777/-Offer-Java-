public class Q23_EntryNodeInList {

    // 如果一个链表中包含环，如何找出环的入口节点？
    // 例如， 在如下链表中，环的入口节点是3
    // 1 -> 2 -> 3-> 4-> 5-> 6 -> 3

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeInList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        //如果有环，找到环内快慢指针的相遇节点
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //重置fast的为头，然后双指针都调整为每次走一步
        //再次相遇的点就是入环节点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Q23_EntryNodeInList obj = new Q23_EntryNodeInList();
        ListNode head= new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next =  head.next.next;
        System.out.println(obj.entryNodeInList(head).val);

        ListNode head2= new ListNode(1);
        System.out.println(obj.entryNodeInList(head2));

        ListNode head3= new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = head3;
        System.out.println(obj.entryNodeInList(head3).val);

        ListNode head4= null;
        System.out.println(obj.entryNodeInList(head4));
    }
}
