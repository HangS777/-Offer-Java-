public class Q49_UglyNumber {

    // 我们把只包含因子2，3和5的数称为丑数。求按从小到大的顺序的
    // 第1500个丑数。例如，6和8都是丑数，但14不是，因为它包含因子7.
    // 习惯上我们把1当作第一个丑数。
    // 根据丑数定义，丑数只能被2，3，和5整除。也就是说，如果一个数能被2整除，
    // 就连续除以2；如果能被3整除，就连续除以3；如果能被5整除，就连续除以5.
    // 如果最后得到1，这个数就是丑数，否则不是。

    // 解法一：暴力查看所有数
    public int getUglyNumber(int index) {
        if (index <= 0) {
            return 0;
        }
        int number = 0;
        int count = 0;
        while (count < index) {
            number++;
            if (isUglyNumber(number)) {
                count++;
            }
        }
        return number;
    }

    private boolean isUglyNumber(int number) {
        if (number <= 0) {
            return false;
        }
        while (number % 2 == 0) {
            number /= 2;
        }
        while (number % 3 == 0) {
            number /= 3;
        }
        while (number % 5 == 0) {
            number /= 5;
        }
        return number == 1 ? true : false;
    }

    // 解法二：数组保存已找到的丑数，空间换时间
    public int getUglyNumber2(int index) {
        if (index <= 0) {
            return 0;
        }
        int[] dp = new int[index];
        dp[0] = 1;
        int uglyNextIndex = 1;

        // 存储已有丑数将要乘以2、3、5的下标（当一个数乘完，下标加1）
        int multiply2 = 0;
        int multiply3 = 0;
        int multiply5 = 0;

        while (uglyNextIndex < index) {
            int nextUglyNum = Math.min(Math.min(dp[multiply2] * 2, dp[multiply3] * 3), dp[multiply5] * 5);
            dp[uglyNextIndex] = nextUglyNum;

            while (dp[multiply2] * 2 <= nextUglyNum) {
                multiply2++;
            }
            while (dp[multiply3] * 3 <= nextUglyNum) {
                multiply3++;
            }
            while (dp[multiply5] * 5 <= nextUglyNum) {
                multiply5++;
            }
            uglyNextIndex++;
        }
        return dp[index - 1];
    }

    public static void main(String[] args) {
        Q49_UglyNumber obj = new Q49_UglyNumber();
        long start = System.currentTimeMillis();

        System.out.print(obj.getUglyNumber(1500) + " ");
        System.out.print(obj.getUglyNumber(0) + " ");
        System.out.print(obj.getUglyNumber(1) + " ");
        System.out.print(obj.getUglyNumber(2) + " ");
        System.out.print(obj.getUglyNumber(3) + " ");
        System.out.print(obj.getUglyNumber(4) + " ");
        System.out.print(obj.getUglyNumber(5) + " ");
        System.out.print(obj.getUglyNumber(6) + " ");
        System.out.print(obj.getUglyNumber(7) + " ");
        System.out.print(obj.getUglyNumber(8) + " ");
        System.out.print(obj.getUglyNumber(9) + " ");
        System.out.print(obj.getUglyNumber(10) + " ");
        System.out.println(obj.getUglyNumber(11) + " ");

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

        System.out.println("===================");

        long start2 = System.currentTimeMillis();

        System.out.print(obj.getUglyNumber2(1500) + " ");
        System.out.print(obj.getUglyNumber2(0) + " ");
        System.out.print(obj.getUglyNumber2(1) + " ");
        System.out.print(obj.getUglyNumber2(2) + " ");
        System.out.print(obj.getUglyNumber2(3) + " ");
        System.out.print(obj.getUglyNumber2(4) + " ");
        System.out.print(obj.getUglyNumber2(5) + " ");
        System.out.print(obj.getUglyNumber2(6) + " ");
        System.out.print(obj.getUglyNumber2(7) + " ");
        System.out.print(obj.getUglyNumber2(8) + " ");
        System.out.print(obj.getUglyNumber2(9) + " ");
        System.out.print(obj.getUglyNumber2(10) + " ");
        System.out.println(obj.getUglyNumber2(11) + " ");

        long end2 = System.currentTimeMillis();
        System.out.println((end2 - start2) + "ms");
    }
}
