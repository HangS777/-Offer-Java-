
public class Q13_RobotMoveRange {
    //地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
    //每一次只能向左，右，上，下四个方向移动一格，
    //但是不能进入行坐标和列坐标的数位之和大于k的格子。
    //例如，当k为18时，机器人能够进入方格（35,37），
    // 因为 3+5+3+7 = 18。但是，它不能进入方格（35,38），
    // 因为 3+5+3+8 = 19。请问该机器人能够达到多少个格子？

    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0) {
            return 0;
        }
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            visited[i] = false;
        }
        int count = move(threshold, rows, cols, 0, 0, visited);
        ;
        return count;
    }

    private int move(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (row < rows && row >= 0 && col < cols && col >= 0 && digitalSum(row + "" + col) <= threshold && !visited[row * cols + col]) {
            visited[row * cols + col] = true;
            count = 1 + move(threshold, rows, cols, row + 1, col, visited)
                    + move(threshold, rows, cols, row - 1, col, visited)
                    + move(threshold, rows, cols, row, col + 1, visited)
                    + move(threshold, rows, cols, row, col - 1, visited);
        }
        return count;
    }

    private int digitalSum(String s) {
        int num = Integer.parseInt(s);
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Q13_RobotMoveRange robotMove = new Q13_RobotMoveRange();
        System.out.println(robotMove.movingCount(18,4,4));
        System.out.println(robotMove.movingCount(18,40,40));
        System.out.println(robotMove.movingCount(0,1,1));
        System.out.println(robotMove.movingCount(-1,4,4));
    }

}
