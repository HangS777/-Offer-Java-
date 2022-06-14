public class Test {
    public int findLoss(int[] array) {
        if (array == null) return -1;
        int low = 0;
        int len = array.length;
        int high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid != array[mid]) {
                if (mid == 0 || mid - 1 == array[mid - 1]) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low == len) return len;
        //  无效的输入数组，如不是递增排序，或者有的数字超出了0~n-1的范围
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 3, 4, 5, 6, 7, 8, 9};
        Test findTheLossNumber = new Test();
        System.out.println(findTheLossNumber.findLoss(a));
    }
}
