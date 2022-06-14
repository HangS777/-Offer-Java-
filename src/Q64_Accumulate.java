public class Q64_Accumulate {

    // 求1+2+...+n，要求不能使用乘除法，for，while，if，else，switch，
    // case等关键字及条件判断语句（A？B:C.）

    // 递归加逻辑运算符的短路特征
    public int solution(int n){
        int sum = n;
        boolean b = n > 0 && (sum += solution(n -1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        Q64_Accumulate obj = new Q64_Accumulate();
        System.out.println(obj.solution(10));
    }

}
