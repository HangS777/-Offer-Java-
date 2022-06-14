public class Q26_SubStructureInTree {

    // 输入两棵二叉树A和B，判断B是不是A的子结构。

    private static class BinaryTreeNode {
        double val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(double val) {
            this.val = val;
        }
    }

    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;
        if (equal(root1.val, root2.val)) {
            result = doseTree1HaveTree2(root1, root2);
        }
        if (!result) {
            result = hasSubtree(root1.left, root2);
        }
        if (!result) {
            result = hasSubtree(root1.right, root2);
        }
        return result;
    }

    private boolean doseTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        boolean result = false;
        if (equal(root1.val, root2.val)) {
            result = doseTree1HaveTree2(root1.left, root2.left) && doseTree1HaveTree2(root1.right, root2.right);
        }
        return result;
    }

    private boolean equal(double val1, double val2) {
        return Math.abs(val1 - val2) < 0.000001;
    }

    public static void main(String[] args) {
        Q26_SubStructureInTree obj = new Q26_SubStructureInTree();
        BinaryTreeNode root1 = new BinaryTreeNode(8.0);
        root1.left = new BinaryTreeNode(8.0);
        root1.right = new BinaryTreeNode(7.0);

        root1.left.left = new BinaryTreeNode(9.0);
        root1.left.right = new BinaryTreeNode(2.0);

        root1.left.right.left = new BinaryTreeNode(4.0);
        root1.left.right.right = new BinaryTreeNode(7.0);

        BinaryTreeNode root2 = new BinaryTreeNode(8.0);
        root2.left = new BinaryTreeNode(9.0);
        root2.right = new BinaryTreeNode(2.0);

        System.out.println(obj.hasSubtree(root1, root2));

    }
}
