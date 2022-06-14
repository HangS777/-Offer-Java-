import java.util.Comparator;
import java.util.PriorityQueue;

public class Q41_StreamMedian {

    // 如何得到一个数据流中的中位数？
    // 如果从数据流中读出奇数个值，那么中位数就是所有数值排序之后位于中间的数值。
    // 如果从数据流中读出偶数个值，那么中位数就是所有数值排序之后中间两个数的平均值。

    private final PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // PriorityQueue默认时小根堆实现
    private final PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

    private int minSize() {
        return minQueue.size();
    }

    private int maxSize() {
        return maxQueue.size();
    }

    private int sizeSum() {
        return minQueue.size() + maxQueue.size();
    }

    public void insert(int num) {
        if (minSize() + maxSize() == 0) { //第0个的时候
            maxQueue.add(num);
        } else if (((sizeSum() & 1) == 1)) { //奇数个的时候加入小根堆,第1，3，5...个的时候
            // 因为我们要确保小根堆中的最小值 > 大根堆中的最大值
            // 所以当加入的数据 < 大根堆中的最大值的时候，我们先把它加入大根堆中，再从大根堆把最大值拿出来加入小根堆中。
            if (!maxQueue.isEmpty() && num < maxQueue.peek()) {
                maxQueue.add(num);
                minQueue.add(maxQueue.poll());
            } else {
                minQueue.add(num);
            }
        } else if (((sizeSum() & 1) == 0)) { //偶数个的时候加入大根堆,第2，4，6...个的时候
            // 与上个条件的情况相反
            if (!minQueue.isEmpty() && num > minQueue.peek()) {
                minQueue.add(num);
                maxQueue.add(minQueue.poll());
            } else {
                maxQueue.add(num);
            }
        }
    }

    public double getMedian() {
        if (sizeSum() == 0) {
            throw new RuntimeException("No numbers are available!");
        }
        double median = 0;
        if ((sizeSum() & 1) == 1) {
            // 因为第一个是先往                大根堆加入的，所以当总数是奇数时，大根堆始终比小根堆多一个数值。
            median = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        } else {
            median = !minQueue.isEmpty() && !maxQueue.isEmpty() ? ((minQueue.peek() + maxQueue.peek()) / 2.0) : 0;
        }
        return median;
    }

    public static void main(String[] args) {
        Q41_StreamMedian obj = new Q41_StreamMedian();
        int i = 1;
        while(i <= 10){
            obj.insert(i);
            i++;
        }
        System.out.println(obj.getMedian());
    }
}
