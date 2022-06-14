public class Q57_TwoNumbersWithSum {

    // 题目一：和为s的两个数字
    // 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得
    // 它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

    public void findNumberWithSum(int[] arr, int sum) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int p1 = 0;
        int p2 = arr.length - 1;
        int currentSum = 0;
        boolean found = false;
        while (p1 < p2) {
            currentSum = arr[p1] + arr[p2];
            if (currentSum == sum) {
                found = true;
                System.out.println("Found: " + found + " " + arr[p1] + " " + arr[p2]);
                return;
            } else if (currentSum > sum) {
                p2--;
            } else {
                p1++;
            }
        }
        System.out.println("Found: " + found);
    }

    // 题目二：和为s的连续整数序列
    // 输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
    // 例如，输入15，由于1+2+3+4+5 = 4+5+6 = 7+8 = 15，所以
    // 打印出3个连续序列1~5，4~6和7~8.

    public void continuousSquenceWithSum(int sum) {
        if (sum < 3) {
            return;
        }
        int small = 1;
        int big = 2;
        int middle = (sum + 1) >> 1;
        int currentSum = small + big;
        boolean found = false;

        System.out.println("Continuous sequence for  " + sum + ": ");
        while (small < middle) {

            if (currentSum == sum) {
                found = true;
                printSequence(small, big);
            }

            //如果和大于sum，删除small
            while (currentSum > sum && small < middle) {
                currentSum -= small;
                small++;
                //删除后再次判断是否等于sum
                if (currentSum == sum) {
                    found = true;
                    printSequence(small, big);
                }
            }
            //如果和小于sum，增加big
            big++;
            currentSum += big;
        }
        if(!found){
            System.out.println("Null");
        }

    }

    private void printSequence(int small, int big) {
        if (small < big) {
            for (int i = small; i <= big; i++) {
                if (i == big) {
                    System.out.print(i);
                } else {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Q57_TwoNumbersWithSum obj = new Q57_TwoNumbersWithSum();
        int[] arr = new int[]{1, 2, 4, 7, 12, 15};
        obj.findNumberWithSum(arr, 15);

        System.out.println("===========================");

        obj.continuousSquenceWithSum(15);
        obj.continuousSquenceWithSum(9);
        obj.continuousSquenceWithSum(100);
        obj.continuousSquenceWithSum(4);
        obj.continuousSquenceWithSum(0);
    }
}
