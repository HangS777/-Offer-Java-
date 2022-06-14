public class Q20_NumericStrings {

    // 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    // 例如：字符串“+100”，“5e2”，“-123”，“3.1416”及“-1E-16”
    // 都表示数值，但“12e”，“1a3.14”，“1.2.3”，“+-5”，“12e+5.4”都不是

    //非正则表达式解法
    //数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，其中A和C都是
    //整数(可以有正负号，也可没有)，而B是一个无符号整数
    private int index = 0;

    public boolean isNumeric(char[] str) {
        if (str == null || str.length <= 0) {
            return false;
        }
        //记得重置index
        index = 0;
        //扫描A
        boolean numeric = scanInteger(str);
        //扫描B
        if (index < str.length && str[index] == '.') {
            index++;
            //这里||的意思时小数部分可以为空，也可以不空
            numeric = scanUnsignedInteger(str) || numeric;
        }
        //扫描C
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            //这里用&&的意思时E|e后面的数字不能为空
            numeric = scanInteger(str) && numeric;
        }
        return numeric && index == str.length;
    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str);
    }

    private boolean scanUnsignedInteger(char[] str) {
        int temp = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        //index增加说明有数字
        return index > temp;
    }


    //正则表达式解法
    // []  ： 字符集合
    // ()  ： 分组
    // ?   ： 重复 0 ~ 1 次
    // +   ： 重复 1 ~ n 次
    // *   ： 重复 0 ~ n 次
    // .   ： 任意字符
    // \\. ： 转义后的 .
    // \\d ： 任意数字
    public boolean isNumeric2(char[] str) {
        if (str == null || str.length <= 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        Q20_NumericStrings obj = new Q20_NumericStrings();

        char[] str = "+100".toCharArray();
        char[] str2 = "5e2".toCharArray();
        char[] str3 = "-123".toCharArray();
        char[] str4 = "3.1416".toCharArray();
        char[] str5 = "-1E-16".toCharArray();
        char[] str6 = "12e".toCharArray();
        char[] str7 = "1a3.14".toCharArray();
        char[] str8 = "1.2.3".toCharArray();
        char[] str9 = "+-5".toCharArray();
        char[] str10 = "12e+5.4".toCharArray();
        System.out.print(obj.isNumeric(str) + " ");
        System.out.print(obj.isNumeric(str2)+ " ");
        System.out.print(obj.isNumeric(str3)+ " ");
        System.out.print(obj.isNumeric(str4)+ " ");
        System.out.print(obj.isNumeric(str5)+ " ");

        System.out.print(obj.isNumeric(str6)+ " ");
        System.out.print(obj.isNumeric(str7)+ " ");
        System.out.print(obj.isNumeric(str8)+ " ");
        System.out.print(obj.isNumeric(str9)+ " ");
        System.out.println(obj.isNumeric(str10));


        System.out.print(obj.isNumeric2(str) + " ");
        System.out.print(obj.isNumeric2(str2) + " ");
        System.out.print(obj.isNumeric2(str3) + " ");
        System.out.print(obj.isNumeric2(str4) + " ");
        System.out.print(obj.isNumeric2(str5) + " ");

        System.out.print(obj.isNumeric2(str6) + " ");
        System.out.print(obj.isNumeric2(str7) + " ");
        System.out.print(obj.isNumeric2(str8) + " ");
        System.out.print(obj.isNumeric2(str9) + " ");
        System.out.println(obj.isNumeric2(str10));

    }
}
