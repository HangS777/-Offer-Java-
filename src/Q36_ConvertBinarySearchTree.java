public class Q36_ConvertBinarySearchTree {

    // 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
    // 要求不能创建任何新的节点，只能调整树中节点指针的指向。

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    private BinaryTreeNode lastNodeInList = null;

    public BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        convertProcess(root);
        BinaryTreeNode head = lastNodeInList;
        while (lastNodeInList != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    private void convertProcess(BinaryTreeNode current) {
        if (current == null) {
            return;
        }

        if (current.left != null) {
            convertProcess(current.left);
        }

        current.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = current;
        }

        lastNodeInList = current;

        if (current.right != null) {
            convertProcess(current.right);
        }
    }

    public static void main(String[] args) {
        Q36_ConvertBinarySearchTree obj = new Q36_ConvertBinarySearchTree();
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);

        BinaryTreeNode head = obj.convert(root);
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}
