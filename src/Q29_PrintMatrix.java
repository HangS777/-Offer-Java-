public class Q29_PrintMatrix {

    // 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每个数字。
    // 例如:  1  2  3  4
    //        5  6  7  8
    //        9 10 11 12
    //       13 14 15 16
    // 输出：1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

    public void printMatrixClockWisely(int[][] matrix, int rows, int cols) {
        if (matrix == null || rows == 0 || cols == 0) {
            return;
        }
        int start = 0;
        while (start * 2 < cols && start * 2 < rows) {
            printClockWiseCircle(matrix, rows, cols, start);
            start++;
        }
        System.out.println();
    }

    private void printClockWiseCircle(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右, 第一步总是需要
        for (int i = start; i <= endX; i++) {
            int num = matrix[start][i];
            System.out.print(num + "\s");
        }
        // 从上到下， 第二步至少要有两行
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                int num = matrix[i][endX];
                System.out.print(num + "\s");
            }
        }
        // 从右到左， 第三步至少要有两行两列
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                int num = matrix[endY][i];
                System.out.print(num + "\s");
            }
        }
        // 从下到上， 第四步至少要有三行两列
        if (start < endY - 1 && start < endX) {
            for (int i = endY - 1; i >= start + 1; i--) {
                int num = matrix[i][start];
                System.out.print(num + "\s");
            }
        }
    }

    public static void main(String[] args) {
        Q29_PrintMatrix obj = new Q29_PrintMatrix();
        int[][] matrix = new int[][]{{1, 2, 3, 4},
                                    {5, 6, 7, 8},
                                    {9, 10, 11, 12},
                                    {13, 14, 15, 16}};
        obj.printMatrixClockWisely(matrix, 4, 4);
    }
}
