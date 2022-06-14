public class Q16_PowerOfNumber {

    // 实现函数 double power(double base, int exponent),
    // 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

    // 指数为正时，得到的整数次方
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }


        double result = power(base, exponent >> 1);
        result *= result;
        // value & 1 is true when value is odd {1, 3, 5, 7, 9, 11, 13, 15}.
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;

    }

    public static void main(String[] args) {
        Q16_PowerOfNumber obj = new Q16_PowerOfNumber();
        System.out.println(obj.power(2, 0));
        System.out.println(obj.power(2, 1));
        System.out.println(obj.power(2, 2));
        System.out.println(obj.power(2, 15));
        System.out.println(obj.power(2, 16));
    }

}
