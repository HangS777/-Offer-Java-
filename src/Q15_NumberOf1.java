class Q15_NumberOf1 {

    //请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
    //例如，把9表示成二进制是1001，有两位是1.因为，输出2。

    //把一个整数减去1，再和原有整数做与运算，会把该整数最右边的1变成0，
    //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的运算。
    public int numberOf1(int num) {
        int count = 0;
        while (num != 0) {
            num = (num - 1) & num;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Q15_NumberOf1 obj = new Q15_NumberOf1();
        System.out.println(obj.numberOf1(0));
        System.out.println(obj.numberOf1(-5));
        System.out.println(obj.numberOf1(-9));
        System.out.println(obj.numberOf1(5));
        System.out.println(obj.numberOf1(9));
    }
}
