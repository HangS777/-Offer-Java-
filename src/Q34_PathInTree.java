import java.util.ArrayList;

public class Q34_PathInTree {

    // 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
    // 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> singlePath = new ArrayList<>();
        int currentSum = 0;
        findPath(root, singlePath, expectedSum, currentSum);
    }

    private void findPath(BinaryTreeNode root, ArrayList<Integer> singlePath, int expectedSum, int currentSum) {
        currentSum += root.val;
        singlePath.add(root.val);
        if (currentSum == expectedSum && root.left == null && root.right == null) {
            for(int i : singlePath){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        if (root.left != null){
            findPath(root.left, singlePath, expectedSum, currentSum);
        }
        if(root.right != null){
            findPath(root.right, singlePath, expectedSum, currentSum);
        }
        singlePath.remove(singlePath.size() - 1);
    }

    public static void main(String[] args) {
        Q34_PathInTree obj = new Q34_PathInTree();
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);

        obj.findPath(root, 22);
    }
}
