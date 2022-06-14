public class Q63_MaximalProfit {

    // 假设把某股票的价格按照时间先后顺序存储再数组中，请问买卖
    // 该股票一次可能获得的最大利润是多少？例如，一只股票再某些
    // 时间节点的价格为{9，11，8，5，7，12，16，14}.如果我们
    // 能再价格为5的时候买入并再价格为16时卖出，则能收获最大的利润是11.

    public int maxProfit(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int min = arr[0];
        int maxDiff = arr[1] - min;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 1] < min) {
                min = arr[i - 1];
            }
            int currDiff = arr[i] - min;
            if (currDiff > maxDiff) {
                maxDiff = currDiff;
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        Q63_MaximalProfit obj = new Q63_MaximalProfit();
        int[] arr = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
        System.out.println(obj.maxProfit(arr));
    }
}
