public class Q03_RepeatNumInArray {

    //题目一
    // 找出数组中重复的数字。
    // 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
    // 数组中某些数字是重复的，但不知道有几个数字是重复了，也不
    // 知道每个数字重复了几次。请找出数组中任意一个重复的数字。
    // 例如，如果输入长度为 7的数组 {2, 3, 1, 0, 2, 5, 3}，
    // 那么对应的输出是第一个重复的数字 2 或 3 。


    public boolean duplicate1(int[] arr, int length, int[] duplication) {
        if (arr == null || arr.length <= 0) {
            return false;
        }
        for (int a : arr) {
            if (a < 0 || a > length - 1) {
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (arr[i] != i) {
                if (arr[i] == arr[arr[i]]) {
                    duplication[0] = arr[i];
                    return true;
                } else {
                    swap(arr, i, arr[i]);
                }
            }
        }
        return false;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    //题目二
    // 找出数组中重复的数字,且不能修改输入数组。
    // 在一个长度为 n + 1 的数组里的所有数字都在 1 到 n 的范围内。
    // 数组中至少一个数字是重复的，但不知道有几个数字是重复了，也不
    // 知道每个数字重复了几次。请找出数组中任意一个重复的数字， 但不
    // 能修改输入的数组。
    // 例如，如果输入长度为 8 的数组 {2, 3, 5, 4, 3, 2, 6, 7}，
    // 那么对应的输出是第一个重复的数字 2 或 3 。

    public int duplicate2(int[] arr, int length) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 1;
        int right = length - 1;

        while (right >= left) {
            int middle = left + ((right - left) >> 1);
            int count = countRange(arr, length, left, middle);
            if (left == right) {
                if (count > 1) {
                    return left;
                } else {
                    break;
                }
            }
            if (count > (middle - left + 1)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] arr, int length, int left, int right) {
        if (arr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] >= left && arr[i] <= right) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Q03_RepeatNumInArray obj = new Q03_RepeatNumInArray();
        int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println(obj.duplicate1(arr, 7, duplication));
        System.out.println(duplication[0]);
        System.out.println("==================");
        int[] arr2 = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(obj.duplicate2(arr2, 8));
    }

}
