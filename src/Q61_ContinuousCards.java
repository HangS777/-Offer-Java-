import java.util.Arrays;

public class Q61_ContinuousCards {

    // 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
    // 2-10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。

    public boolean isContinuous(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        Arrays.sort(arr);
        int zero_count = 0;
        int gap_count = 0;

        for (int i = 0; i < arr.length && arr[i] == 0; i++) {
            zero_count++;
        }

        int small = zero_count;//忽略前面的0
        int big = small + 1;
        while (big < arr.length) {
            if (arr[small] == arr[big]) {
                return false;
            }
            gap_count += arr[big] - arr[small] - 1;
            small = big;
            big++;
        }
        return gap_count <= zero_count;
    }

    public static void main(String[] args) {
        Q61_ContinuousCards obj = new Q61_ContinuousCards();
        int[] arr = new int[]{0,0,1,2,3};
        int[] arr2 = new int[]{1,2,3,4,5};
        int[] arr3 = new int[]{0,0,1,2,4};
        int[] arr4 = new int[]{0,1,1,2,3};
        int[] arr5 = new int[]{0,1,2,3,6};
        int[] arr6 = new int[]{1,2,3,4,6};
        System.out.println(obj.isContinuous(arr));
        System.out.println(obj.isContinuous(arr2));
        System.out.println(obj.isContinuous(arr3));
        System.out.println(obj.isContinuous(arr4));
        System.out.println(obj.isContinuous(arr5));
        System.out.println(obj.isContinuous(arr6));
    }
}
