public class Q44_DigitsInSequence {

    // 数字以0123456789101112131415...的格式序列化到一个字符序列中。
    // 在这个序列中，第5位（从0开始）是5，第十三位是1，第十九位是4，等等。
    // 请写一个函数，求任意第n位对应的数字。

    public int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }

        int digits = 1;
        while (true) {
            int numbers = countOfNumbers(digits);

            if (index < numbers * digits) {
                return digitAtIndex(index, digits);
            }
            //如果确定要查询位置不在这个位数区间就跳过
            index -= numbers * digits;
            digits++;
        }
    }

    // 返回digits位数时总的数字有多少个，比如一位数有0~9十个数
    // 两位数有10~99九十个数...
    private int countOfNumbers(int digits) {
        if (digits == 1) {
            return 10;
        }
        return (9 * (int) (Math.pow(10, digits - 1)));
    }

    // 当确定要查询位置在某位数区间时，用个函数确定具体的数
    // 比如确定要查询位置在3位数的区间，即在100~999之间
    private int digitAtIndex(int index, int digits) {
        int number = beginningNum(digits) + index / digits;
        
//        // 因为index % digits就是从左到右第n位
//        // 所以我们可以将数字转换成字符从左到右遍历
//        String numberStr = String.valueOf(number);
//        return Integer.parseInt(String.valueOf(numberStr.charAt(index % digits)));
//        // 上面代码也可以得出正确结果

        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    // 这个函数返回每个位数区间的第一个数，比如3位数第一个数是100
    private int beginningNum(int digits) {
        if (digits == 1) {
            return 0;
        }
        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        Q44_DigitsInSequence obj = new Q44_DigitsInSequence();
        System.out.println(obj.digitAtIndex(1000));
        System.out.println(obj.digitAtIndex(1001));
        System.out.println(obj.digitAtIndex(1002));
        System.out.println(obj.digitAtIndex(10));
        System.out.println(obj.digitAtIndex(190));
        System.out.println(obj.digitAtIndex(0));
        System.out.println(obj.digitAtIndex(1));
    }
}
