public class Q11_MinNumInRorateArray {

    //把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    //输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
    //例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    //NOTE：给出的所有元素都大于0，若数组大小为0，请返回0

    public int MinNumInRorateArray(int[] arr) {
        if (arr == null) {
            throw new RuntimeException("Array is empty");
        }
        if (arr.length <= 0) {
            return 0;
        }
        int p1 = 0;
        int p2 = arr.length - 1;
        int mid = p1;
        while (arr[p1] >= arr[p2]) {
            if (p2 - p1 == 1) {
                mid = p2;
                break;
            } else {
                mid = p1 + (p2 - p1) >> 1;
                if (arr[p1] == arr[p2] && arr[mid] == arr[p1]) {
                    return searchInorder(arr, p1, p2);
                }
                if (arr[mid] >= arr[p1]) {
                    p1 = mid;
                } else if (arr[mid] <= arr[p2]) {
                    p2 = mid;
                }

            }
        }
        return arr[mid];
    }

    private int searchInorder(int[] arr, int p1, int p2) {
        int ans = arr[p1];
        for (int i = p1 + 1; i <= p2; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q11_MinNumInRorateArray obj = new Q11_MinNumInRorateArray();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(obj.MinNumInRorateArray(arr));

        int[] arr2 = new int[]{4, 5, 1, 2, 3};
        System.out.println(obj.MinNumInRorateArray(arr2));

        int[] arr3 = new int[]{2, 3, 1, 1, 2};
        System.out.println(obj.MinNumInRorateArray(arr3));

        int[] arr4 = new int[]{1, 0, 1, 1, 1};
        System.out.println(obj.MinNumInRorateArray(arr4));

        int[] arr5 = new int[]{1, 1, 1, 0, 1};
        System.out.println(obj.MinNumInRorateArray(arr5));
    }

}
