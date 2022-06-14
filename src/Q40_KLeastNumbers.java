import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class Q40_KLeastNumbers {

    // 输入n个整数,找出其中最小的k个数.
    // 例如: 输入4,5,1,6,2,7,3,8这8个数,
    // 则最小的4字数是1,2,3,4.

    // 解法一:时间复杂度为O(n)的算法,只有当我们可以修改输入的数组时可用
    public void getKLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || arr.length < k) {
            return;
        }
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);

        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private int partition(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        int middle = arr.length >> 1;
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(arr, index, end);

        int smallZone = start - 1;
        for (index = start; index <= end; index++) {
            if (arr[index] < arr[end]) {
                smallZone++;
                if (index != smallZone) {
                    swap(arr, index, smallZone);
                }
            }
        }
        smallZone++;
        swap(arr, smallZone, end);
        return smallZone;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 解法二: 时间复杂度为O(nlogk)的算法,特别适合处理海量数据
    // 且不修改数组本身

    // 解法二的第一种方式,用手动写最大堆去实现
    public static class CustomMinHeap {
        private int[] heap;
        private final int capacity;
        private int heapSize;

        public CustomMinHeap(int capacity) {
            heap = new int[capacity];
            this.capacity = capacity;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == capacity;
        }

        public void push(int val) {
            if (isFull()) {
                throw new RuntimeException("Heap is Full.");
            }
            heap[heapSize] = val;
            heapifyUp(heap, heapSize++);
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("Heap is Empty.");
            }
            int result = heap[0];
            swap(heap, 0, --heapSize);
            heapifyDown(heap, 0);
            return result;
        }

        // 这个方法不能将除以2改成位运算，会出现负数
        private void heapifyUp(int[] heap, int index) {
            while (heap[index] < heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void heapifyDown(int[] heap, int index) {
            int leftChildIndex = index * 2 + 1;
            while (leftChildIndex < heapSize) {
                int smallest = leftChildIndex + 1 < heapSize &&
                        heap[leftChildIndex] > heap[leftChildIndex + 1] ? leftChildIndex + 1 : leftChildIndex;
                smallest = heap[smallest] > heap[index] ? index : smallest;
                if (smallest == index) {
                    break;
                }
                swap(heap, smallest, index);
                index = smallest;
                leftChildIndex = index * 2 + 1;
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void getKLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || arr.length < k) {
            return;
        }
        CustomMinHeap minHeap = new CustomMinHeap(arr.length);
        int[] result = new int[k];
        for (int i : arr) {
            minHeap.push(i);
        }
        for (int i = 0; i < k; i++) {
            System.out.print(minHeap.pop() + " ");
        }
        System.out.println();
    }

    // 解法二的第二种方式,用基于红黑树实现的TreeSet去实现
    // 注意：这个方法的问题是，TreeSet不允许有重复的值存在，所有当要求有重复输出的话不能用此方法
    public void getKLeastNumbers3(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 0 || arr.length < k) {
            return;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            treeSet.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            int max = treeSet.last();
            if (arr[i] < max) {
                treeSet.remove(max);
                treeSet.add(arr[i]);
            }
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q40_KLeastNumbers obj = new Q40_KLeastNumbers();
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        int[] arr2 = new int[]{4, 5, 1, 2, 2, 2, 3, 2};
        obj.getKLeastNumbers(arr, 4);
        obj.getKLeastNumbers(arr2, 4);
        obj.getKLeastNumbers(arr, 1);
        obj.getKLeastNumbers(arr2, 8);
//      obj.getKLeastNumbers(arr, 0);
//      obj.getKLeastNumbers(null, 1);
//      obj.getKLeastNumbers(arr2, 9);
        System.out.println("==================");

        obj.getKLeastNumbers2(arr, 4);
        obj.getKLeastNumbers2(arr2, 4);
        obj.getKLeastNumbers2(arr, 1);
        obj.getKLeastNumbers2(arr2, 8);
        System.out.println("==================");

        obj.getKLeastNumbers3(arr, 4);
        obj.getKLeastNumbers3(arr2, 4);
        obj.getKLeastNumbers3(arr, 1);
        obj.getKLeastNumbers3(arr2, 8);

    }

}
