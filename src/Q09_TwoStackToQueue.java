import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q09_TwoStackToQueue {

    public static class TwoStackImplementQueue<T> {
        Stack<T> pushStack;
        Stack<T> popStack;

        public TwoStackImplementQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        public boolean isEmpty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }

        public void enqueue(T t) {
            pushStack.push(t);
            pushToPop();
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new RuntimeException("Queue is empty!");
            } else {
                pushToPop();
                return popStack.pop();
            }
        }

        private void pushToPop() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }

        }
    }

    public static class TwoQueueImplementStack<T> {
        public Queue<T> queue;
        public Queue<T> help;

        public TwoQueueImplementStack() {
            queue = new LinkedList<>();
            help = new LinkedList<>();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void push(T t) {
            queue.offer(t);
        }

        public T pop() {
            while (queue.size() > 1) {
                help.offer(queue.poll());
            }
            T ans = queue.poll();
            Queue<T> temp = help;
            help = queue;
            queue = temp;
            return ans;
        }
    }

    public static void main(String[] args) {
        TwoStackImplementQueue<Integer> queue = new TwoStackImplementQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.print(queue.isEmpty() + "\s");
        System.out.print(queue.dequeue() + "\s");
        System.out.print(queue.dequeue() + "\s");
        System.out.print(queue.dequeue() + "\s");
        System.out.print(queue.dequeue() + "\s");
        System.out.print(queue.dequeue() + "\s");
        System.out.println(queue.isEmpty());


        TwoQueueImplementStack<Integer> stack = new TwoQueueImplementStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.print(stack.isEmpty() + "\s");
        System.out.print(stack.pop() + "\s");
        System.out.print(stack.pop() + "\s");
        System.out.print(stack.pop() + "\s");
        System.out.print(stack.pop() + "\s");
        System.out.print(stack.pop() + "\s");
        System.out.println(stack.isEmpty());
    }

}
