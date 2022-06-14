public class Q51_InversePairs {

    // 数组中的两个数字，如果前面一个数字大于后面的数字，
    // 则这两个数字组成一个逆序对。求一个数组的逆序对总数。
    // 例如：在数组{7，5，6，4}中，一共存在5个逆序对，分别是
    // (7,5),(7,6),(7,4),(5,4)和(6,4).

    public int inversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSortProcess(arr, 0, arr.length - 1);
    }

    private int mergeSortProcess(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return mergeSortProcess(arr, L, M) + mergeSortProcess(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = help.length - 1;
        int p1 = M;
        int p2 = R;
        int result = 0;
        while (p1 >= L && p2 >= (M + 1)) {
            result += arr[p1] > arr[p2] ? (p2 - M) : 0;
            help[i--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= L) {
            help[i--] = arr[p1--];
        }
        while (p2 >= M + 1) {
            help[i--] = arr[p2--];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return result;

    }

    public static void main(String[] args) {
        Q51_InversePairs obj = new Q51_InversePairs();
        int[] arr = new int[]{7, 5, 6, 4};
        int[] arr2 = new int[]{1, 2, 3, 4};
        int[] arr3 = new int[]{5, 4, 3, 2};
        int[] arr4 = new int[]{2, 5, 5, 2};
        System.out.println(obj.inversePair(arr));
        System.out.println(obj.inversePair(arr2));
        System.out.println(obj.inversePair(arr3));
        System.out.println(obj.inversePair(arr4));
    }
}
