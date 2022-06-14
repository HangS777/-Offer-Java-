public class Q18_DeleteNodeFromList {

    // 题目一：在O(1)时间内删除链表节点
    // 给定单向链表的头指针和一个节点指针，
    // 定义一个函数在O(1)时间内删除该节点。

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //并不是完美的方法，这个方法基于的假设是：此删除的节点一定在链表中
    public void deleteNode(ListNode head, ListNode deleteNode) {
        if (head == null || deleteNode == null) {
            return;
        }
        //要删除的节点不是尾节点
        if (deleteNode.next != null) {
            ListNode next = deleteNode.next.next;
            deleteNode.val = deleteNode.next.val;
            deleteNode.next.next = null;
            deleteNode.next = next;
        }
        //链表中，只有一个节点且是删除节点
        else if (head == deleteNode) {
            head = null;
        }
        //链表有多个节点，删除的是尾节点
        else {
            ListNode curr = head;
            while (curr.next != deleteNode) {
                curr = curr.next;
            }
            curr.next = null;
        }
    }

    // 题目二：删除链表中的重复节点
    // 在一个排序的链表中，如何删除重复的节点？
    // 例如，1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
    // 删除后： 1 -> 2 -> 5

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            boolean needToDelete = false;
            if (next != null && node.val == next.val) {
                needToDelete = true;
            }
            if (!needToDelete) {
                preNode = node;
                node = node.next;
            } else {
                int deleteValue = node.val;
                ListNode toBeDeleted = node;
                while (toBeDeleted != null && toBeDeleted.val == deleteValue) {
                    next = toBeDeleted.next;
                    toBeDeleted = next;
                    //检查头是否存在
                    if (preNode == null) {
                        head = next;
                    } else {
                        preNode.next = next;
                    }
                    node = next;
                }
            }

        }

        return head;
    }

    public static void main(String[] args) {
        Q18_DeleteNodeFromList obj = new Q18_DeleteNodeFromList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.deleteNode(head, head.next.next);

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        obj.deleteNode(head2, head2.next.next.next.next);

        ListNode curr2 = head2;
        while (curr2 != null) {
            System.out.print(curr2.val + " ");
            curr2 = curr2.next;
        }

        System.out.println();
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(3);
        head3.next.next.next.next = new ListNode(4);
        head3.next.next.next.next.next = new ListNode(4);
        head3.next.next.next.next.next.next = new ListNode(5);

        ListNode curr3 = obj.deleteDuplicates(head3);
        while (curr3 != null) {
            System.out.print(curr3.val + " ");
            curr3 = curr3.next;
        }
    }
}
