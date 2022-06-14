public class Q33_SquenceOfBST {

    // 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
    // 如果是则返回true，否则返回false。
    // 假设数组中任意两个数字都不相同。

    public boolean verifySquenceOfBST(int[] sequence, int length) {
        if (sequence == null || length <= 0) {
            return false;
        }
        // 拿出根节点
        int root = sequence[length - 1];

        // 找到根节点的左子树
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        // 找到根节点的右子树
        int j = i;
        for (; j < length - 1; j++) {
            if(sequence[j] < root) {
                return false;
            }
        }
        // i > 0 说明有左子树, 默认空树为true
        boolean left = true;
        if(i > 0){
            left = verifySquenceOfBST(sequence, i);
        }
        // i < length - 1 说明有右子树, 默认空树为true
        boolean right = true;
        if(i < length - 1){
            //右子树的长度为总长减去左子树再减去root
            int[] newSequence = new int[length - i  -1];
            int index = 0;
            for(int k = i; k < length - 1; k++){
                newSequence[index++] = sequence[k];
            }
            right = verifySquenceOfBST(newSequence, length - i  -1);
        }
        return left && right;
    }

    public static void main(String[] args) {
        Q33_SquenceOfBST obj = new Q33_SquenceOfBST();
        int[] sequence = new int[]{5, 7, 6, 9, 11, 10, 8};
        int[] sequence2 = new int[]{7, 4, 6, 5};
        System.out.println(obj.verifySquenceOfBST(sequence, 7));
        System.out.println(obj.verifySquenceOfBST(sequence2, 4));
    }
}
