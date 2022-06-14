public class Q28_SymmetricalBinaryTree {

    //请实现一个函数，用来判断一棵二叉树是不是对称的。
    //如果一棵二叉树和它的镜像一样，那么它是对称的。
    //例如： 8                  8
    //    /   \              /   \
    //   6     6            6     9
    //  / \   / \          / \   / \
    // 5   7 7   5        5   7  7  5
    // 第一棵数是对称的，第二棵树不是

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSymmetric(BinaryTreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public static void main(String[] args) {
        Q28_SymmetricalBinaryTree obj = new Q28_SymmetricalBinaryTree();
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);

        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        System.out.println(obj.isSymmetric(root));

        BinaryTreeNode root2 = new BinaryTreeNode(8);
        root2.left = new BinaryTreeNode(6);
        root2.right = new BinaryTreeNode(6);

        root2.left.left = new BinaryTreeNode(5);
        root2.left.right = new BinaryTreeNode(7);

        root2.right.left = new BinaryTreeNode(7);
        root2.right.right = new BinaryTreeNode(5);

        System.out.println(obj.isSymmetric(root2));
    }
}
