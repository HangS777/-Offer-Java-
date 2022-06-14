public class Q12_PathInMatrix {

    //请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
    //路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
    //如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
    //例如下面矩阵
    // a b t g
    // c f c s
    // j d e h
    //包含一条字符串"bfce"的路径，但是矩阵中不包含"abfb"路径，
    //因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null || str.length <= 0) {
            return false;
        }
        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }
        boolean hasPath = false;
        if (col >= 0 && col < cols && row >= 0 && row < rows && matrix[row * cols + col] == str[pathLength] && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        Q12_PathInMatrix obj = new Q12_PathInMatrix();
        char[] matrix = new char[] {'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};
        char[]  str = new char[] {'b', 'f', 'c', 'e'};
        char[]  strFalse = new char[] {'a', 'b', 'f', 'b'};

        System.out.println(obj.hasPath(matrix,3,4,str));
        System.out.println(obj.hasPath(matrix,3,4,strFalse));
    }
}
