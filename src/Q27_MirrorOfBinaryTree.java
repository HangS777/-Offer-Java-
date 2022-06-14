import java.util.LinkedList;
import java.util.Queue;

public class Q27_MirrorOfBinaryTree {

    // 请完成一个函数，输入一棵二叉树，该函数输出它的镜像。

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public void mirrorBinaryTreeRecursion(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorBinaryTreeRecursion(root.left);
        }
        if (root.right != null) {
            mirrorBinaryTreeRecursion(root.right);
        }
    }

    //For test
    public void levelTraversalOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode curr = queue.poll();
            System.out.print(curr.val + "\s");
            if(curr.left != null){
                queue.add(curr.left);
            }
            if(curr.right != null){
                queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Q27_MirrorOfBinaryTree obj = new Q27_MirrorOfBinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);

        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        obj.levelTraversalOrder(root);

        obj.mirrorBinaryTreeRecursion(root);
        System.out.println("\n===================");
        obj.levelTraversalOrder(root);
    }
}
