import java.util.Stack;

public class Q30_MinInStack {

    // 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素
    // 的min函数。在该栈中，调用min，push，pop的时间复杂度都是O(1)

    public static class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<Integer>();
            minStack = new Stack<Integer>();
        }

        public void push(int value) {
            if (minStack.isEmpty()) {
                minStack.push(value);
            } else if (value > minStack.peek()) {
                minStack.push(minStack.peek());
            } else if (value <= minStack.peek()) {
                minStack.push(value);
            }
            stack.push(value);
        }

        public int pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Empty Stack.");
            }
            minStack.pop();
            return stack.pop();
        }

        public int getMin (){
            if (minStack.isEmpty()) {
                throw new RuntimeException("Empty Stack.");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.push(4);
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.push(2);
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.push(1);
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.pop();
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.pop();
        System.out.println("Current minimum: " + minStack.getMin());

        minStack.push(0);
        System.out.println("Current minimum: " + minStack.getMin());

    }
}
