import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q68_LowestCommonParentInTree {

    //最低公共祖先：在二叉树中，两个结点向上走，第一次汇聚的时候的结点
    // 就是其最低公共祖先，且这个祖先结点可以是两个结点的其中一个结点本身

    private static class Node {
        private Node left, right;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    // 题目一：输入一棵二叉查找树，返回它们的最低公共祖先,默认两个节点都在树中
    public Node findCommonParentInBST(Node root, Node a, Node b) {
        if (root == null || a == null || b == null) {
            return null;
        }
        Node curr = root;
        while (curr != null) {
            if (curr.val > a.val && curr.val > b.val) {
                curr = curr.left;
            } else if (curr.val < a.val && curr.val < b.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

    //题目二：输入一棵普通树（拥有指向父结点的指针）的两个结点，返回它们的最低公共祖先。
    private static class Node_2 {
        Node_2 parent;
        int val;
        List<Node_2> children;

        public Node_2(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public Node_2 findCommonParentInTreeWithParentPointer(Node_2 root, Node_2 node1, Node_2 node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        Node_2 curr1 = node1;
        Node_2 curr2 = node2;
        int n = 0;

        while (curr1 != null) {
            curr1 = curr1.parent;
            n++;
        }
        while (curr2 != null) {
            curr2 = curr2.parent;
            n--;
        }
        // 如果两个链表最后一个节点不一样那么就说明这两个链表不相交
        if (curr1 != curr2) {
            return null;
        }
        curr1 = n > 0 ? node1 : node2;
        curr2 = curr1 == node1 ? node2 : node1;
        n = Math.abs(n);
        while (n > 0) {
            curr1 = curr1.parent;
            n--;
        }
        while (curr1 != curr2) {
            curr1 = curr1.parent;
            curr2 = curr2.parent;
        }
        return curr1;
    }

    //题目三：输入一棵普通树的两个结点，返回它们的最低公共祖先。
    private static class Node_3 {
        int val;
        List<Node_3> children;

        public Node_3(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    public Node_3 findCommonParentInTree(Node_3 root, Node_3 node1, Node_3 node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }
        LinkedList<Node_3> path1 = new LinkedList<>();
        LinkedList<Node_3> path2 = new LinkedList<>();


        getNodePath(root, node1, path1);
        getNodePath(root, node2, path2);
        return getLastCommonNode(path1, path2);
    }

    private boolean getNodePath(Node_3 root, Node_3 node1, LinkedList<Node_3> path1) {
        if (root == node1) {
            return true;
        }
        path1.add(root);
        boolean found = false;

        for (int i = 0; !found && i < root.children.size(); ) {
            found = getNodePath(root.children.get(i), node1, path1);
            i++;
        }

        if (!found) {
            path1.remove(path1.size() - 1);
        }
        return found;
    }

    private Node_3 getLastCommonNode(LinkedList<Node_3> path1, LinkedList<Node_3> path2) {
        Node_3 lastCommonNode = null;
        while (!path1.isEmpty() && !path2.isEmpty()) {
            if (path1.peekFirst() == path2.peekFirst()) {
                lastCommonNode = path1.peekFirst();
            }
            path1.pollFirst();
            path2.pollFirst();
        }
        return lastCommonNode;
    }

    public static void main(String[] args) {
        Q68_LowestCommonParentInTree obj = new Q68_LowestCommonParentInTree();
        System.out.print("题目一：");
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        root.right.left = new Node(6);
        root.right.right = new Node(8);
        System.out.println(obj.findCommonParentInBST(root, root.left.left, root.right.left).val);

        System.out.println("==============================");

        System.out.print("题目二：");
        Node_2 root2 = new Node_2(1);
        Node_2 b2 = new Node_2(2);
        Node_2 c2 = new Node_2(3);
        Node_2 d2 = new Node_2(4);
        Node_2 e2 = new Node_2(5);
        Node_2 f2 = new Node_2(6);
        Node_2 g2 = new Node_2(7);
        Node_2 h2 = new Node_2(8);
        Node_2 i2 = new Node_2(9);
        Node_2 j2 = new Node_2(10);

        root2.children.add(b2);
        root2.children.add(c2);

        b2.children.add(d2);
        b2.children.add(e2);

        d2.children.add(f2);
        d2.children.add(g2);

        e2.children.add(h2);
        e2.children.add(i2);
        e2.children.add(j2);

        b2.parent = root2;
        c2.parent = root2;

        d2.parent = b2;
        e2.parent = b2;

        f2.parent = d2;
        g2.parent = d2;

        h2.parent = e2;
        i2.parent = e2;
        j2.parent = e2;
        System.out.println(obj.findCommonParentInTreeWithParentPointer(root2, f2, h2).val);

        System.out.println("==============================");

        System.out.print("题目三：");
        Node_3 root3 = new Node_3(1);
        Node_3 b3 = new Node_3(2);
        Node_3 c3 = new Node_3(3);
        Node_3 d3 = new Node_3(4);
        Node_3 e3 = new Node_3(5);
        Node_3 f3 = new Node_3(6);
        Node_3 g3 = new Node_3(7);
        Node_3 h3 = new Node_3(8);
        Node_3 i3 = new Node_3(9);
        Node_3 j3 = new Node_3(10);

        root3.children.add(b3);
        root3.children.add(c3);

        b3.children.add(d3);
        b3.children.add(e3);

        d3.children.add(f3);
        d3.children.add(g3);

        e3.children.add(h3);
        e3.children.add(i3);
        e3.children.add(j3);

        System.out.println(obj.findCommonParentInTree(root3, f3, h3).val);
    }
}
