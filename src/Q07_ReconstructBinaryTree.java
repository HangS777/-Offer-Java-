public class Q07_ReconstructBinaryTree {

    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    //假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    //例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
    //中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reconstructBinaryTree(int[] preOrder, int[] inOrder, int length) {
        if (preOrder == null || inOrder == null || length <= 0) {
            return null;
        }
        return process(preOrder, 0, length - 1, inOrder, 0, length - 1);
    }

    public TreeNode process(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == rootVal) {
                root.left = process(pre, preStart + 1, i - inStart + preStart, in, inStart, i - 1);
                root.right = process(pre, i - inStart + preStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Q07_ReconstructBinaryTree obj = new Q07_ReconstructBinaryTree();
        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = obj.reconstructBinaryTree(preOrder, inOrder, 8);
        printPreOrder(node);
        System.out.println();
        printInOrder(node);
        System.out.println();
        printPostOrder(node);
    }

    private static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\s");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + "\s");
        printInOrder(node.right);
    }

    private static void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.val + "\s");
    }
}
