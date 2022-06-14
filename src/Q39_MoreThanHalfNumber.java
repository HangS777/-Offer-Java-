public class Q39_MoreThanHalfNumber {

    // 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
    // 例如：输入一个长度为9的数组{1，2，3，2，2，2，5，4，2}。
    // 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
    // 假设输入数组的元素都不等于0

    // 解法一：基于partition函数的时间复杂度为O(n)的算法(会修改数组)
    public int moreThanHalfNum(int[] arr) {
        if (checkInvalidInput(arr)) {
            System.out.println("无效输入!");
            return 0;
        }
        int middle = arr.length >> 1;
        int start = 0;
        int end = arr.length - 1;
        int index = partition(arr, start, end);

        while (index != middle) {
            if (index > middle) {
                end = index - 1;
            } else {
                start = index + 1;
            }
            index = partition(arr, start, end);
        }

        int result = arr[middle];
        if (checkMoreThanHalf(arr, result)) {
            System.out.println("没有一个数出现超过数组长度的一半:");
            return 0;
        }
        System.out.println("这个数出现超过数组长度的一半:");
        return result;
    }

    /**
     * 请注意这个方法看似无用且可在调用的时候简化，
     * 但是其真正的意义是为了区分
     * 方法返回的是无效输入时返回的0，还是数组中出现超过长度一半的0.
     * 所以我们用一个全局变量inputInvalid去做区分
     */
    private boolean inputInvalid = false;
    private boolean checkInvalidInput(int[] arr){
        inputInvalid = false;
        if(arr == null || arr.length == 0){
            inputInvalid = true;
        }
        return inputInvalid;
    }

    private boolean checkMoreThanHalf(int[] arr, int result) {
        int count = 0;
        for (int i : arr) {
            if (i == result) {
                count++;
            }
        }
        return (count * 2 <= arr.length);
    }

    /**
     * 此partition函数将返回arr数组中一个基准数字的位置，并将此arr数组中所有小于
     * 基准数字的数放在其左边，将大于等于基准数字的数放在其右边。
     * （Note:无论是小于区域还是大于区域内都不能保证是有序的）。
     *
     * @param arr   要排序的数组
     * @param start 数组开始位置
     * @param end   数组结束位置
     * @return 基准数字的位置
     */
    private int partition(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start < 0 || end >= arr.length || start > end) {
            throw new IllegalArgumentException("Invalid Input!");
        }
        int index = start + (int) (Math.random() * (end - start + 1));
        swap(arr, index, end);

        int smallZone = start - 1; // this is the small zone right boundary(included)
        for (index = start; index < end; index++) {
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

    // 解法二：根据数组特点找出时间复杂度为O(n)的算法(不会修改数组)
    public int moreThanHalfNum2(int[] arr) {
        if (checkInvalidInput(arr)) {
            System.out.println("无效输入!");
            return 0;
        }
        int result = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
                count = 1;
            } else if (arr[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        if (checkMoreThanHalf(arr, result)) {
            System.out.println("没有一个数出现超过数组长度的一半!");
            return 0;
        }
        System.out.println("这个数出现超过数组长度的一半:");
        return result;
    }


    public static void main(String[] args) {
        Q39_MoreThanHalfNumber obj = new Q39_MoreThanHalfNumber();
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr2 = new int[]{1, 2, 3, 2, 4, 2, 5, 4, 2};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{1, 4, 3, 5, 2, 2, 2, 2, 2};
        System.out.println(obj.moreThanHalfNum(arr));
        System.out.println(obj.moreThanHalfNum(arr2));
        System.out.println(obj.moreThanHalfNum(arr3));
        System.out.println(obj.moreThanHalfNum(null));
        System.out.println(obj.moreThanHalfNum(arr4));
        System.out.println("=======================");
        System.out.println(obj.moreThanHalfNum2(arr));
        System.out.println(obj.moreThanHalfNum2(arr2));
        System.out.println(obj.moreThanHalfNum2(arr3));
        System.out.println(obj.moreThanHalfNum2(null));
        System.out.println(obj.moreThanHalfNum2(arr4));
    }
}
