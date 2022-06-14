public class Q8_InOrderNextNode {

    // 给定一个二叉树和其中的一个结点，如何找出中序遍历顺序的
    // 下一个结点并且返回。 树种的结点除了有两个分别指向左，右
    // 子结点的指针， 还有一个指向父节点的指针。

    public static class TreeNode {
        char val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;

        TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode getInorderNextNode(TreeNode givenNode) {
        if (givenNode == null) {
            return null;
        }
        TreeNode ans = null;
        // if given node has right sub-tree
        if (givenNode.right != null) {
            TreeNode curr = givenNode.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            ans = curr;
        } else if (givenNode.parent != null) {
            TreeNode curr = givenNode;
            TreeNode parent = givenNode.parent;
            while (parent != null && curr == parent.right) {
                curr = parent;
                parent = parent.parent;
            }
            ans = parent;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q8_InOrderNextNode obj = new Q8_InOrderNextNode();
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.left.parent = root;

        root.left.left = new TreeNode('d');
        root.left.left.parent = root.left;

        root.left.right = new TreeNode('e');
        root.left.right.parent = root.left;

        root.left.right.left = new TreeNode('h');
        root.left.right.left.parent = root.left.right;

        root.left.right.right = new TreeNode('i');
        root.left.right.right.parent = root.left.right;

        root.right = new TreeNode('c');
        root.right.parent = root;

        root.right.left = new TreeNode('f');
        root.right.left.parent = root.right;

        root.right.right = new TreeNode('g');
        root.right.right.parent = root.right;

        System.out.println("'a' - > " + obj.getInorderNextNode(root).val);
        System.out.println("'b' - > " + obj.getInorderNextNode(root.left).val);
        System.out.println("'d' - > " + obj.getInorderNextNode(root.left.left).val);
        System.out.println("'f' - > " + obj.getInorderNextNode(root.right.left).val);
        System.out.println("'i' - > " + obj.getInorderNextNode(root.left.right.right).val);
        System.out.println("'g' - > " + (obj.getInorderNextNode(root.right.right) == null ? "null" : obj.getInorderNextNode(root.right.right).val));
    }
}
