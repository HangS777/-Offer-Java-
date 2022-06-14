public class Q65_AddTwoNumbers {

    // 写一个函数，求两个正数之和，要求再函数体内不得使用“+”，“-”，“*”，“/”四则运算符号。

    public int add(int num1, int num2) {
        int sum, carry;
        do {
            //不考虑进位直接相加，结果和异或运算一样
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (carry != 0);
        return num1;
    }

    public static void main(String[] args) {
        Q65_AddTwoNumbers obj = new Q65_AddTwoNumbers();
        System.out.println(obj.add(5,17));
    }
}
