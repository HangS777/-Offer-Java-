public class Q55_TreeDepth {

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    // 题目一：二叉树的深度
    // 输入一棵二叉树的根节点，求概树的深度。从根节点到叶节点依次
    // 经过的节点（含根，叶节点）形成树的一条路径，最长路径长度为
    // 树的深度。

    public int treeMaxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeMaxDepth(root.left);
        int right = treeMaxDepth(root.right);
        return left >= right ? (left + 1) : (right + 1);
    }

    // 题目二：平衡二叉树
    // 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左，右
    // 子树的深度相差不超过1，那么他就是一棵平衡二叉树。

    public boolean isBalanced(BinaryTreeNode root) {
        return isBalancedProcess(root).isBalanced;
    }

    private Info isBalancedProcess(BinaryTreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = isBalancedProcess(root.left);
        Info right = isBalancedProcess(root.right);

        boolean isBalanced = true;
        int height = Math.max(left.height, right.height) + 1;

        if(!left.isBalanced){
            isBalanced = false;
        }
        if(!right.isBalanced){
            isBalanced = false;
        }
        if(Math.abs(left.height - right.height) > 1){
            isBalanced = false;
        }
        return new Info(isBalanced, height);

    }

    private static class Info {
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int h) {
            this.isBalanced = isBalanced;
            height = h;
        }
    }

    public static void main(String[] args) {
        Q55_TreeDepth obj = new Q55_TreeDepth();
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(8);
        System.out.println(obj.treeMaxDepth(root));
        System.out.println(obj.isBalanced(root));
    }

}
