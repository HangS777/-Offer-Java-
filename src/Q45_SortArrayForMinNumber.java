import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Q45_SortArrayForMinNumber {

    // 输入一个正整数数组，把数组里所有的数字拼接起来
    // 排成一个数，打印能拼接出的所有数字中最小的一个。
    // 例如，输入数组{3，32，321}，则打印出这3个数能排成的最小的数字321323

    // 解法一：全排列找出最小值，时间复杂度为O(n!)
    public int findMinNumber(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        ArrayList<Integer> allNums = new ArrayList<>();
        String path = "";
        findProcess(arr, 0, path, allNums);
        int min = Integer.MAX_VALUE;
        for(int i : allNums){
            min = Math.min(i, min);
        }
        return min;
    }

    private void findProcess(int[] arr, int index, String path, ArrayList<Integer> allNums) {
        if(index == arr.length){
            allNums.add(Integer.parseInt(path));
        }
        for(int i = index; i < arr.length; i++){
            swap(arr, i, index);
            findProcess(arr, index + 1, path + arr[index], allNums);
            swap(arr, i, index);
        }
    }

    private void swap(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    // 解法二：基于解法一的问题-两个数拼接后可能会超出int的范围，所以我们需要将数字转换
    // 字符串，并找到正确的字符串比较规则，时间复杂度为O(nlogn)
    public int findMinNumber2(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        String[] strs = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            strs[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(strs, new MyComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(strs[i]);
        }
        return Integer.parseInt(sb.toString());
    }

    public class MyComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }

    public static void main(String[] args) {
        Q45_SortArrayForMinNumber obj = new Q45_SortArrayForMinNumber();
        int[] arr = new int[]{3, 32, 321};
        int[] arr2 = new int[]{321};
        int[] arr3 = new int[]{123,213,321};

        System.out.println("Minimum Number 1: " + obj.findMinNumber(arr));
        System.out.println("Minimum Number 1: " + obj.findMinNumber(arr2));
        System.out.println("Minimum Number 1: " + obj.findMinNumber(arr3));

        System.out.println("Minimum Number 2: " + obj.findMinNumber2(arr));
        System.out.println("Minimum Number 2: " + obj.findMinNumber2(arr2));
        System.out.println("Minimum Number 2: " + obj.findMinNumber2(arr3));
    }
}
