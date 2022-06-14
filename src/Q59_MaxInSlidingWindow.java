import java.util.*;

public class Q59_MaxInSlidingWindow {

    // 题目一：滑动窗口的最大值
    // 给定一个数组和滑动窗口的大小，请找出所有活动窗口里的最大值。
    // 例如，输入数组{2，3，4，2，6，2，5，1}及滑动窗口的大小3，
    // 那么一共存6个滑动窗口，它们的最大值分别是{4，4，6，6，6，5}.

    // 题目一：解法一：优先队列，最大堆
    public ArrayList<Integer> maxInWindows(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < n || n <= 0) {
            return list;
        }
        // 优先队列默认最小堆实现，所以我们要加入反转比较器使它成为最大堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() == n) {
                list.add(maxHeap.peek());
                maxHeap.remove(arr[index++]);
            }
        }
        return list;
    }

    // 题目一：解法二：双端队列存放下标
    public ArrayList<Integer> maxInWindows2(int[] arr, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        if (arr == null || arr.length < n || n < 1) {
            return list;
        }
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            // 查看新的数是不是大于已有的数，如果大于，则说明之前的数不可能成为最大值，全部删除
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.pollLast();
            }
            // 如果当前第一个最大值已经不在窗口内，则组需要把第一个数的位置删除
            if (!deque.isEmpty() && deque.peekFirst() <= (i - n)) {
                deque.pollFirst();
            }

            deque.offerLast(i);
            // 加入的数量等于窗口大小后，每次都会产生一个最大值
            if (!deque.isEmpty() && i + 1 >= n) {
                list.add(arr[deque.peekFirst()]);
            }

        }
        return list;
    }

    // 题目二：队列的最大值
    // 请定义一个队列并实现函数max得到队列里的最大值，要求函数max，入列
    // 出列的方法时间复杂度都是O(1).
    public static class MaxQueue {
        private Queue<Integer> queue;
        private Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList();
            maxQueue = new LinkedList();
        }

        public void offer(int val) {
            queue.offer(val);
            while (!maxQueue.isEmpty() && val >= maxQueue.peekLast()) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(val);
        }

        public int poll() {
            if (queue.isEmpty()) {
                throw new RuntimeException("Empty Queue!");
            }
            int temp = queue.poll();
            if (temp == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return temp;
        }

        public int getMaxValue(){
            if (queue.isEmpty()) {
                throw new RuntimeException("Empty Queue!");
            }
            return maxQueue.peekFirst();
        }
    }

    public static void main(String[] args) {
        Q59_MaxInSlidingWindow obj = new Q59_MaxInSlidingWindow();
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] arr3 = new int[]{9, 8, 7, 6, 5, 4, 3, 2};
        System.out.println("题目一，方法一：");
        System.out.println(obj.maxInWindows(arr, 3).toString());
        System.out.println(obj.maxInWindows(arr2, 3).toString());
        System.out.println(obj.maxInWindows(arr3, 3).toString());
        System.out.println("题目一，方法二：");
        System.out.println(obj.maxInWindows2(arr, 3).toString());
        System.out.println(obj.maxInWindows2(arr2, 3).toString());
        System.out.println(obj.maxInWindows2(arr3, 3).toString());
        System.out.println("==============================");
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.offer(2);
        System.out.println(maxQueue.getMaxValue());
        maxQueue.offer(3);
        maxQueue.offer(4);
        System.out.println(maxQueue.getMaxValue());
        maxQueue.offer(2);
        maxQueue.offer(6);
        System.out.println(maxQueue.getMaxValue());
        maxQueue.offer(2);
        maxQueue.offer(5);
        maxQueue.offer(1);
        System.out.println(maxQueue.getMaxValue());
        maxQueue.poll();
        maxQueue.poll();
        maxQueue.poll();
        maxQueue.poll();
        maxQueue.poll();
        System.out.println(maxQueue.getMaxValue());

    }
}
