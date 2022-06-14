public class Q53_NumberOfK {

    // 题目一：数字在排序数组中出现的次数
    // 统计要给数字在排序数组中出现的次数。例如，输入排序数组{1，2，3，3，3，3，4，5}
    // 和数字3，由于3在这个数组中出现了4次，因此输出4。

    // 题目一 解法一：
    private int getFirstk(int[] arr, int k, int l, int r) {
        if (l > r) {
            return -1;
        }
        int midIndex = l + ((r - l) >> 1);
        int midValue = arr[midIndex];
        if (midValue == k) {
            // 看midvalue是不是第一个K
            if ((midIndex > 0 && arr[midIndex - 1] != k) || midIndex == 0) {
                return midIndex;
            } else {
                r = midIndex - 1;
            }
        } else if (midValue > k) {
            r = midIndex - 1;
        } else {
            l = midIndex + 1;
        }
        return getFirstk(arr, k, l, r);
    }

    private int getLastk(int[] arr, int k, int l, int r) {
        if (l > r) {
            return -1;
        }
        int midIndex = l + ((r - l) >> 1);
        int midValue = arr[midIndex];
        if (midValue == k) {
            // 看midvalue是不是第一个K
            if ((midIndex < arr.length - 1 && arr[midIndex + 1] != k) || midIndex == arr.length - 1) {
                return midIndex;
            } else {
                l = midIndex + 1;
            }
        } else if (midValue > k) {
            r = midIndex - 1;
        } else {
            l = midIndex + 1;
        }
        return getLastk(arr, k, l, r);
    }

    public int numberOfK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int first = getFirstk(arr, k, 0, arr.length - 1);
        int last = getLastk(arr, k, 0, arr.length - 1);

        //都等于-1说明不包含k
        if (first == -1 && last == -1) {
            return 0;
        } else {
            return last - first + 1;
        }
    }

    // 题目一 解法二：
    public int numberOfK_2(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        // getIndex(arr, k + 0.5)会得到arr中大于K的第一个位置
        // getIndex(arr, k - 0.5)会得到arr中等于k的第一个位置
        return getIndex(arr, k + 0.5) - getIndex(arr, k - 0.5);
    }

    private int getIndex(int[] arr, double k) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 2);
            if (arr[m] > k) {
                r = m - 1;
            } else if (arr[m] < k) {
                l = m + 1;
            }
        }
        return l;
    }

    // 题目二：0~n-1中缺失的数字
    // 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围
    // 0~n-1之内。在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出。
    public int findLoss(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] != m) {
                // 如果m = 0，说明是第一个值和下标不一样的数
                // 如果m != 0, 但是它左边的数的值和下标一样，说明它也是第一个值与下标不一样的数
                if (m == 0 || m - 1 == arr[m - 1]) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else {
                l = m + 1;
            }
        }
        // 0~n-1的最后一个数不在数组中
        if (l == arr.length) {
            return arr.length;
        }
        //无效输入
        return -1;
    }

    // 题目三：数组中数值和下标相等的元素
    // 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请实现一个函数，找出
    // 数组中任意一个数值等于其下标的元素。例如，在数组{-3，-1，1，3，5}中，数数字
    // 3和它的下标相等。
    public int findValueEqualToIndex(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (arr[m] == m) {
                return m;
            } else if (arr[m] > m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q53_NumberOfK obj = new Q53_NumberOfK();
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 3, 4, 5};
        System.out.print(obj.numberOfK(arr, 1) + " ");
        System.out.print(obj.numberOfK(arr, 2) + " ");
        System.out.print(obj.numberOfK(arr, 3) + " ");
        System.out.print(obj.numberOfK(arr, 4) + " ");
        System.out.print(obj.numberOfK(arr, 6) + " ");
        System.out.println();
        System.out.print(obj.numberOfK_2(arr, 1) + " ");
        System.out.print(obj.numberOfK_2(arr, 2) + " ");
        System.out.print(obj.numberOfK_2(arr, 3) + " ");
        System.out.print(obj.numberOfK_2(arr, 4) + " ");
        System.out.print(obj.numberOfK_2(arr, 6) + " ");
        System.out.println();
        System.out.println("==============");
        int[] arr2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr4 = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        System.out.print(obj.findLoss(arr2) + " ");
        System.out.print(obj.findLoss(arr3) + " ");
        System.out.print(obj.findLoss(arr4) + " ");
        System.out.println();
        System.out.println("==============");
        int[] arr5 = new int[]{-3, -1, 1, 3, 5};
        int[] arr6 = new int[]{0, 1, 2, 3, 4};
        int[] arr7 = new int[]{1, 2, 3, 4, 5};
        System.out.print(obj.findValueEqualToIndex(arr5) + " ");
        System.out.print(obj.findValueEqualToIndex(arr6) + " ");
        System.out.print(obj.findValueEqualToIndex(arr7) + " ");
        System.out.println();
    }
}
