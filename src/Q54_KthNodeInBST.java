public class Q54_KthNodeInBST {

    // 给定一棵二叉搜索树，请找出其中第K大的节点。

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    // 注意指针问题，Java中不能通过指针传递基本类型，所以要把k单独提出来
    private int k;

    public BinaryTreeNode KthNode(BinaryTreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }
        this.k = k;
        return kthNodeProcess(root);
    }


    private BinaryTreeNode kthNodeProcess(BinaryTreeNode root) {
        BinaryTreeNode target = null;

        // 因为中序遍历先从左子节点开始，所以刚开始不用看target是不是null
        if (root.left != null) {
            target = kthNodeProcess(root.left);
        }

        if (target == null) {
            if (k == 1) {
                target = root;
            }
            k--;
        }

        if (target == null && root.right != null) {
            target = kthNodeProcess(root.right);
        }
        return target;
    }

    public static void main(String[] args) {
        Q54_KthNodeInBST obj = new Q54_KthNodeInBST();
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);

        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);

        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(8);
        System.out.println(obj.KthNode(root, 3).val);
    }
}
