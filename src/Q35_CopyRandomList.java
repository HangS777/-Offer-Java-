public class Q35_CopyRandomList {

    // 请实现函数ComplexListNodeClone(ComplexListNode head),
    // 复制一个复杂链表。再复杂链表中，每个节点除了有一个next指针指向下一个节点，
    // 还有一个random随机指针指向链表中任意节点或者null。

    private static class ComplexListNode {
        int val;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int val) {
            this.val = val;
        }
    }

    public ComplexListNode complexListNodeClone(ComplexListNode head) {
        if (head == null) {
            return null;
        }

        ComplexListNode newHead = null;
        ComplexListNode curr = head;
        // 先将所有的复制节点加到每个节点的后面1 -> 1'
        while (curr != null) {
            ComplexListNode next = curr.next;
            curr.next = new ComplexListNode(curr.val);
            curr.next.next = next;
            curr = next;
        }
        // 再把所有复制节点的随机指针调整为复制后的节点
        curr = head;
        while (curr != null) {
            ComplexListNode random = curr.random;
            ComplexListNode next = curr.next.next;
            curr.next.random = random == null ? null : random.next;
            curr = next;
        }
        // 再将复制链表从整个链表中提取出来
        curr = head;
        newHead = curr.next;
        ComplexListNode copyCurr = null;
        while (curr != null) {
            ComplexListNode next = curr.next.next;
            copyCurr = curr.next;
            curr.next = next;
            copyCurr.next = next != null ? next.next : null;
            curr = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Q35_CopyRandomList obj = new Q35_CopyRandomList();
        ComplexListNode head = new ComplexListNode(1);
        head.next = new ComplexListNode(2);
        head.next.next = new ComplexListNode(3);
        head.next.next.next = new ComplexListNode(4);

        head.random = head.next.next;// 1 -> 3
        head.next.random = head.next.next.next; // 2 -> 4
        // 3 -> null
        head.next.next.next.random = head; // 4 -> 1
        ComplexListNode newHead = obj.complexListNodeClone(head);
        while (newHead != null) {
            System.out.println(newHead.val + " " + (newHead.random == null ? "null":newHead.random.val));
            newHead = newHead.next;
        }
    }
}
