import com.sun.source.tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Q37_SerializeBinaryTrees {

    // 请实现两个函数，分别用来序列化和反序列化二叉树

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    public Queue<String> serialize(BinaryTreeNode root) {
        Queue<String> queue = new LinkedList<>();
        serializeProcess(root, queue);
        return queue;
    }

    public void serializeProcess(BinaryTreeNode root, Queue<String> queue) {
        if(root == null){
            queue.add(null);
        }else{
            queue.add(String.valueOf(root.val));
            serializeProcess(root.left, queue);
            serializeProcess(root.right, queue);
        }
    }

    public BinaryTreeNode deserialize(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        return deserializeProcess(queue);
    }

    private BinaryTreeNode deserializeProcess(Queue<String> queue) {
        String val = queue.poll();
        if (val == null){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(val));
        root.left = deserializeProcess(queue);
        root.right = deserializeProcess(queue);
        return root;
    }

    // For Test
    public void printPreorder(BinaryTreeNode root) {
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }


    public static void main(String[] args) {
        Q37_SerializeBinaryTrees obj = new Q37_SerializeBinaryTrees();
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);

        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);

        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);

        Queue<String> queue = obj.serialize(root);

        BinaryTreeNode rootAns = obj.deserialize(queue);
        obj.printPreorder(rootAns);
    }

}
