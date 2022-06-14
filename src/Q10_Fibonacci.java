public class Q10_Fibonacci {
    /**
     * 题目一
     * 现在要求输入一个整数n，请你输出斐波那契(Fibonacci)数列的第n项。
     */

    // n : 0 ~ n
    public long fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        } else {
            long first = 0;
            long second = 1;
            long next = 0;
            for (int i = 2; i <= n; i++) {
                next = first + second;
                first = second;
                second = next;
            }
            return next;
        }
    }

    /**
     * 题目二:青蛙跳台阶的问题
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     * 求该青蛙跳上一个n级台阶总共有多少种跳法
     */

    public long frogJump(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return n;
        } else {
            long first = 1;
            long second = 2;
            long next = 0;
            for (int i = 3; i <= n; i++){
                next = first + second;
                first = second;
                second = next;
            }
            return next;
        }
    }

    public static void main(String[] args) {
        Q10_Fibonacci obj = new Q10_Fibonacci();
        System.out.print(obj.fibonacci(0) + "\s");
        System.out.print(obj.fibonacci(1)+ "\s");
        System.out.print(obj.fibonacci(2)+ "\s");
        System.out.print(obj.fibonacci(3)+ "\s");
        System.out.print(obj.fibonacci(4)+ "\s");
        System.out.print(obj.fibonacci(5)+ "\s");
        System.out.print(obj.fibonacci(6)+ "\s");
        System.out.print(obj.fibonacci(7)+ "\s");
        System.out.print(obj.fibonacci(8)+ "\s");
        System.out.println(obj.fibonacci(9));
        System.out.println("=================");
        System.out.print(obj.frogJump(0)+ "\s");
        System.out.print(obj.frogJump(1)+ "\s");
        System.out.print(obj.frogJump(2)+ "\s");
        System.out.print(obj.frogJump(3)+ "\s");
        System.out.print(obj.frogJump(4)+ "\s");
        System.out.print(obj.frogJump(5)+ "\s");
        System.out.print(obj.frogJump(6)+ "\s");
        System.out.print(obj.frogJump(7)+ "\s");
        System.out.print(obj.frogJump(8)+ "\s");
        System.out.println(obj.frogJump(9)+ "\s");
    }
}
