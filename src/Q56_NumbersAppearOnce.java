public class Q56_NumbersAppearOnce {

    // 题目一：数组中只出现一次的两个数字
    // 一个整型数组里除两个数字之外，其他数字都出现了两次。请写程序找
    // 出这两个只出现一次的函数。要求时间复杂度O（n），空间复杂度O（1）。
    // 例如：输入数组{2，4，3，6，3，2，5，5}，因为只有4和6这两个数字只
    // 出现了一次，所以输出4和6.

    public void twoNumsAppearingOnce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int XOR = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR ^= arr[i];
        }
        int last_1 = XOR & (-XOR);

        int XOR_2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & last_1) == 0) {
                XOR_2 ^= arr[i];
            }
        }
        System.out.println(XOR_2 + " " + (XOR ^ XOR_2));
    }

    // 题目二：数组中唯一只出现一次的数字
    // 在一个数组中除一个数字只出现一(k)次以外，其它数字都出现了三(m)次。请找出出现一次的数字
    // k < m, m > 1
    private static boolean numAppearingNotKOrMTimes = false;

    public int findNumAppearingOnce(int[] arr, int k, int m) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int[] count = new int[32];
        for (int num : arr) {
            for (int i = 0; i < 32; i++) {
                count[i] += (num >> i) & 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % m != 0) {
                if (count[i] % m == k) {
                    result |= 1 << i;
                } else {
                    numAppearingNotKOrMTimes = true;
                    return -1;
                }
            }
        }
        if (result == 0) {
            int zero = 0;
            for (int num : arr) {
                if (num == 0) {
                    zero++;
                }
            }
            if (zero != k) {
                numAppearingNotKOrMTimes = true;
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q56_NumbersAppearOnce obj = new Q56_NumbersAppearOnce();
        int[] arr = new int[]{2, 4, 3, 6, 3, 2, 5, 5};
        obj.twoNumsAppearingOnce(arr);
        int[] arr2 = new int[]{0, 1, 1, 1, 2, 2, 2};
        int[] arr3 = new int[]{-1, 1, 1, 1, -2, -2, -2};
        int[] arr4 = new int[]{-1, -1, 1, 1, -2, -2, -2};

        System.out.println(obj.findNumAppearingOnce(arr2, 1, 3) + " " + numAppearingNotKOrMTimes);
        System.out.println(obj.findNumAppearingOnce(arr3, 1, 3) + " " + numAppearingNotKOrMTimes);
        System.out.println(obj.findNumAppearingOnce(arr4, 1, 3) + " " + numAppearingNotKOrMTimes);
    }

}
