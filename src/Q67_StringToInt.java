public class Q67_StringToInt {

    // 写一个函数实现把字符串转换成整数这个功能。不能使用已有的函数库。

    public static boolean validInput = false;

    public int strToInt(String str) {
        validInput = false;
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = false;
        long number = 0;
        for (int i = 0; i < str.length(); i++) {
            //看符号
            if (i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                // 说明只有一个正负号
                if (str.length() == 1) {
                    return 0;
                }
                if (str.charAt(i) == '-') {
                    isNegative = true;
                }
                continue;
            }
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return 0;
            }
            int flag = isNegative ? -1 : 1;
            number = number * 10 + flag * (str.charAt(i) - '0');
            if ((!isNegative && number > Integer.MAX_VALUE) || (isNegative && number < Integer.MIN_VALUE)) {
                return 0;
            }
        }
        validInput = true;
        return (int)number;
    }

    public static void main(String[] args) {
        Q67_StringToInt obj = new Q67_StringToInt();
        System.out.println(obj.strToInt("123") + " " + validInput);
        System.out.println(obj.strToInt("-123") + " " + validInput);
        System.out.println(obj.strToInt("+123") + " " + validInput);
        System.out.println(obj.strToInt("012") + " " + validInput);

        System.out.println(obj.strToInt("+123-123") + " " + validInput);
        System.out.println(obj.strToInt("0") + " " + validInput);
        System.out.println(obj.strToInt("92233720368547758071")+ " " + validInput);
    }
}
