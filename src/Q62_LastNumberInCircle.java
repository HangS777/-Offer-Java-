import java.util.LinkedList;
import java.util.List;

public class Q62_LastNumberInCircle {

    // 0,1,...,n-1这n个数字排成一个圆圈，从数字0开始，每次从
    // 这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
    // 约瑟夫（Josephuse）环问题

    // 解法一：用环形链表模拟圆圈
    public int lastInCircle(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int p = 0;
        while (list.size() > 1) {
            for (int i = 0; i < m - 1; i++) {
                p++;
                if (p == list.size()) {
                    p = 0;
                }
            }
            list.remove(p);
            //删除的刚好是位于尾部的元素
            if (p == list.size()) {
                p = 0;
            }
        }
        return list.get(p);
    }

    // 解法二：找到规律,数学推导见原书
    public int lastInCircle2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }


    public static void main(String[] args) {
        Q62_LastNumberInCircle obj = new Q62_LastNumberInCircle();
        System.out.println(obj.lastInCircle(5, 3));
        System.out.println(obj.lastInCircle2(5, 3));
    }
}
