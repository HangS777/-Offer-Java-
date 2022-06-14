public class Q21_ReorderArray {

    // 题目一
    // 输入一个整数数组，实现要给函数来调整该数组中数字的顺序，
    // 使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分
    // Note: 0x1是1的hex值，如果一个数是偶数 它 & 1 == 0，否则 != 0

    public void reorderOddEven(int[] arr, int length) {
        if (arr == null || length == 0) {
            return;
        }
        int p1 = 0;
        int p2 = length - 1;
        while (p1 < p2) {
            //移动p1直到它指向偶数
            while (p1 < p2 && (arr[p1] & 0x1) != 0) {
                p1++;
            }
            //移动p2直到它指向奇数
            while (p1 < p2 && (arr[p2] & 0x1) == 0) {
                p2--;
            }
            if (p1 < p2) {
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;

            }
        }
    }

    // 题目二
    // 代码的可扩展性，理解解耦的好处
    public interface Recorder {
        boolean reorderConditions(int[] arr, int index);
    }

    public static class ReorderOddEven implements Recorder {
        @Override
        public boolean reorderConditions(int[] arr, int index) {
            return (arr[index] & 0x1) == 0;
        }
    }

    public static class ReorderSolution {
        private Recorder recorder;

        public ReorderSolution(Recorder recorder) {
            this.recorder = recorder;
        }

        public void reorderArray(int[] arr) {
            if (arr == null || arr.length == 0) {
                return;
            }
            int p1 = 0;
            int p2 = arr.length - 1;
            while (p1 < p2) {
                //移动p1直到它指向偶数
                while (p1 < p2 && !(recorder.reorderConditions(arr, p1))) {
                    p1++;
                }
                //移动p2直到它指向奇数
                while (p1 < p2 && recorder.reorderConditions(arr, p2)) {
                    p2--;
                }
                if (p1 < p2) {
                    swap(arr, p1, p2);

                }
            }
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public static void main(String[] args) {
        Q21_ReorderArray obj = new Q21_ReorderArray();
        int[] arr = new int[]{2, 4, 4, 6, 8, 10, 1, 3, 5};
        obj.reorderOddEven(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\n=========================");
        ReorderOddEven reorderOddEven = new ReorderOddEven();
        ReorderSolution reorderSolution = new ReorderSolution(reorderOddEven);
        reorderSolution.reorderArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
