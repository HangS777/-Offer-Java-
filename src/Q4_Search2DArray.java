public class Q4_Search2DArray {

    //在一个二维数组中，每一行都按照从左到右
    //递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    //完成一个函数，输入这样的一个二维数组和一个整数，
    //判断数组中是否含有该整数。

    public boolean searchIn2DArray(int[][] arr, int rows, int cols, int target) {
        boolean found = false;
        if (arr != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >= 0) {
                if (arr[row][col] == target) {
                    found = true;
                    break;
                }else if (arr[row][col] > target) {
                    col--;
                }else{
                    row++;
                }
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Q4_Search2DArray obj = new Q4_Search2DArray();
        int[][] arr = new int[][]{{1, 2, 8, 9},
                                    {2, 4, 9, 12},
                                    {4, 7, 10, 13},
                                    {6, 8, 11, 15}};
        System.out.println(obj.searchIn2DArray(arr, 4, 4, 7));
        System.out.println(obj.searchIn2DArray(arr, 4, 4, 5));
    }
}
