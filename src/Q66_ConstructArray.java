public class Q66_ConstructArray {

    // 给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1],其中
    // B中的元素B[i] = A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1].
    // 不能使用除法。

    public int[] constructArray(int[] A) {
        if (A == null || A.length < 2) {
            return null;
        }
        int[] B = new int[A.length];
        // 这是保存左部分A[0]*A[1]*...*A[i-1]的结果到B中
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 这是将已有的左部分结果乘以右部分A[i+1]*...*A[n-1]的结果到B中
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args) {
        Q66_ConstructArray obj = new Q66_ConstructArray();
        int[] A = new int[]{1, 2, 3, 4, 5};
        int B[] = obj.constructArray(A);
        for(int num: B){
            System.out.println(num);
        }
    }

}
