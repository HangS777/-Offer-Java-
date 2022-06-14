import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q32_TreeLevelTraversal {

    private static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
        }
    }

    // 题目一：不分行从上到下打印二叉树（层序遍历）

    public void treeLevelTraversal(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode curr = queue.poll();
            System.out.print(curr.val + "\s");
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    // 题目二：分行从上到下打印二叉树
    // 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印
    // 每一层打印到一行。
    // 例如：上题输出变成如下
    // 8
    // 6 10
    // 5 7 9 11

    public void treeLevelTraversalInLine(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrint = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode curr = queue.peek();
            System.out.print(curr.val + "\s");
            if (curr.left != null) {
                queue.offer(curr.left);
                nextLevel++;
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                nextLevel++;
            }
            queue.poll();
            toBePrint--;
            if (toBePrint == 0) {
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

    // 题目二：之字形打印二叉树
    // 第一层在第一行从左到右打印，
    // 第二层在第二行从右到左打印，
    // 第三层在第三行再次从左到右打印...

    public void treeLevelTraversalInZ(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Stack<BinaryTreeNode> stack_help = new Stack<>();
        stack.push(root);
        int current = 0; // means odd or even level

        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.peek();
            System.out.print(curr.val + "\s");
            stack.pop();

            if (current == 0) {
                if (curr.left != null) {
                    stack_help.push(curr.left);
                }
                if (curr.right != null) {
                    stack_help.push(curr.right);
                }
            } else {
                if (curr.right != null) {
                    stack_help.push(curr.right);
                }
                if (curr.left != null) {
                    stack_help.push(curr.left);
                }
            }

            if(stack.isEmpty()){
                System.out.println();
                current = 1 - current;
                Stack<BinaryTreeNode> temp = stack_help;
                stack_help = stack;
                stack = temp;
            }
        }
    }


    public static void main(String[] args) {
        Q32_TreeLevelTraversal obj = new Q32_TreeLevelTraversal();
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);

        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);

        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        //题目一
        obj.treeLevelTraversal(root);

        System.out.println("\n=====================");

        //题目二
        obj.treeLevelTraversalInLine(root);

        System.out.println("\n=====================");

        //题目三
        BinaryTreeNode root2 = new BinaryTreeNode(1);
        root2.left = new BinaryTreeNode(2);
        root2.right = new BinaryTreeNode(3);

        root2.left.left = new BinaryTreeNode(4);
        root2.left.right = new BinaryTreeNode(5);

        root2.right.left = new BinaryTreeNode(6);
        root2.right.right = new BinaryTreeNode(7);

        root2.left.left.left = new BinaryTreeNode(8);
        root2.left.left.right = new BinaryTreeNode(9);

        root2.left.right.left = new BinaryTreeNode(10);
        root2.left.right.right = new BinaryTreeNode(11);

        root2.right.left.left = new BinaryTreeNode(12);
        root2.right.left.right = new BinaryTreeNode(13);


        root2.right.right.left = new BinaryTreeNode(14);
        root2.right.right.right = new BinaryTreeNode(15);

        obj.treeLevelTraversalInZ(root2);
    }
}
