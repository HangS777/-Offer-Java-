public class Q42_GreatestSumOfSubArrays {

    // 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数
    // 组成的一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n).

    // 为了区分子数组最大和是0，和无效输入这两种不同的情况，
    // 我们定义了一个全局变量invalidInput来标记无效输入。
    private boolean invalidInput = false;

    // 还是动态规划的思想
    public int findGreatestSumOfSubArrays(int[] arr) {
        if (arr == null || arr.length == 0) {
            invalidInput = true;
            return 0;
        }
        invalidInput = false;

        int currentSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (currentSum <= 0) {
                //抛弃掉负数累加和
                currentSum = arr[i];
            } else {
                currentSum += arr[i];
            }
            //更新最大和
            if (currentSum > greatestSum) {
                greatestSum = currentSum;
            }
        }
        return greatestSum;
    }

    public static void main(String[] args) {
        Q42_GreatestSumOfSubArrays obj = new Q42_GreatestSumOfSubArrays();
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        System.out.println(obj.findGreatestSumOfSubArrays(arr));
    }
}

