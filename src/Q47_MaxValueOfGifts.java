public class Q47_MaxValueOfGifts {

    // 在一个m * n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）.
    // 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达
    // 棋盘的右下角。给定一个棋盘极其上面的礼物，请计算你最多能拿到多少价值的礼物。

    public int getMaxValue1(int[] values, int rows, int cols) {
        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 因为要看当前的最大值，需要知道当前上面和左面的最大值
                // f(i, j) = Max(f(i - 1,j),f(i, j - 1)) + value[i,j]
                int up = 0;
                int left = 0;

                if (i > 0) {
                    up = dp[i - 1][j];
                }

                if (j > 0) {
                    left = dp[i][j - 1];
                }
                dp[i][j] = Math.max(up, left) + values[i * cols + j];
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public int getMaxValue2(int[] values, int rows, int cols) {
        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;

                if(i > 0){
                    up = dp[j];
                }

                if(j > 0){
                    left = dp[j - 1];
                }

                dp[j] = Math.max(up, left) + values[i * cols + j];
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        Q47_MaxValueOfGifts obj = new Q47_MaxValueOfGifts();
        int[] values = new int[]{1, 10, 3, 8, 12, 2, 9, 6, 5, 7, 4, 11, 3, 7, 16, 5};
        System.out.println(obj.getMaxValue1(values, 4, 4));
        System.out.println(obj.getMaxValue2(values, 4, 4));
    }
}
