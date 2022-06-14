public class Q60_DicesProbability {

    // 题目：把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。
    // 输入n，打印出s的所有可能的值出现的概率。

    private final int dice_maxValue = 6;

    // 解法一：递归，时间效率不够高
    public void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * dice_maxValue;
        int[] probabilities = new int[maxSum - number + 1];
        probability(number, number, 0, probabilities);

        int total = (int) Math.pow(dice_maxValue, number);
        for (int i = number; i <= maxSum; i++) {
            // 用每个和出现的次数除以总的次数就是每个和出现的概率
            double ratio = (double) probabilities[i - number] / total;
            System.out.printf("%d: %e | ", i, ratio);
        }
        System.out.println();
    }

    // 其余n-1个骰子可能出现的值求和
    private void probability(int original, int current, int sum, int[] probabilities) {
        if (current == 0) {
            probabilities[sum - original]++;
        } else {
            for (int i = 1; i <= dice_maxValue; i++) {
                probability(original, current - 1, i + sum, probabilities);
            }
        }
    }

    //解法二：动态规划，直接从递归改
    public void printProbability2(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * dice_maxValue;
        int[][] dp = new int[number + 1][maxSum + 1];
        //当只有一个骰子的时候
        for (int i = 1; i <= dice_maxValue; i++) {
            dp[1][i] = 1;
        }
        for (int row = 2; row <= number; row++) {
            for (int col = row; col <= row * dice_maxValue; col++) {
                //总和n为n-1，n-2，n-3，n-4，n-5和n-6的总和
                for (int i = 1; i <= col && i <= dice_maxValue; i++) {
                    dp[row][col] += dp[row - 1][col - i];
                }
            }
        }
        int total = (int) Math.pow(dice_maxValue, number);
        for (int i = number; i <= maxSum; i++) {
            // 用每个和出现的次数除以总的次数就是每个和出现的概率
            double ratio = (double) dp[number][i] / total;
            System.out.printf("%d: %e | ", i, ratio);
        }
        System.out.println();
    }

    // 解法三：动态规划。更省空间
    public void printProbability3(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * dice_maxValue;
        int[][] dp = new int[2][maxSum + 1];
        int flag = 0;
        // 只有一个骰子的时候所有出现的次数都是1
        for (int i = 1; i <= dice_maxValue; i++) {
            dp[flag][i] = 1;
        }
        //增加骰子的数量，每个出现的和等于前面循环n-1，n-2，n-3，n-4，n-5和n-6的次数的总和
        for (int k = 2; k <= number; k++) {
            //注意这一步是必须的，是在两行之间转化时的必要重置
            //因为每加一个骰子，和的最小值会变大，需要把之前的最小和重置为0
            for (int i = 0; i < k; i++) {
                dp[1 - flag][i] = 0;
            }
            // sum代表总和，因为和的最小值为n，所以从k开始
            for (int sum = k; sum <= k * dice_maxValue; sum++) {
                // 从0开始加次数
                dp[1 - flag][sum] = 0;
                // i从1开始，代表1~6，为了计算n-1，n-2，n-3，n-4，n-5和n-6的总和
                for (int i = 1; i <= sum && i <= dice_maxValue; i++) {
                    dp[1 - flag][sum] += dp[flag][sum - i];
                }
            }
            flag = 1 - flag;
        }
        int total = (int) Math.pow(dice_maxValue, number);
        for (int sum = number; sum <= maxSum; sum++) {
            // 用每个和出现的次数除以总的次数就是每个和出现的概率
            double ratio = (double) dp[flag][sum] / total;
            System.out.printf("%d: %e | ", sum, ratio);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Q60_DicesProbability obj = new Q60_DicesProbability();
        obj.printProbability(6);
        obj.printProbability2(6);
        obj.printProbability3(6);
    }
}
