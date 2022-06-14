import java.util.Arrays;

public class Q17_Print1ToMaxOfNDigits {

    // 输入数字n，按顺序打印出从1到最大的n位十进制数。
    // 比如输入3，打印出1，2，3...999, 到最大的三位数。

    public void print1toMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        Arrays.fill(numbers, '0');
        while (!increment(numbers)) {
            printNumber(numbers);
        }
    }

    private boolean increment(char[] numbers) {
        boolean isOverFlow = false;
        int nCarry = 0;
        int nLength = numbers.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = numbers[i] - '0' + nCarry;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    nSum -= 10;
                    nCarry = 1;
                    numbers[i] = (char) ('0' + nSum);
                }
            } else {
                numbers[i] = (char) ('0' + nSum);
                break;
            }
        }
        return isOverFlow;
    }

    private void printNumber(char[] numbers) {
        boolean isBeginning = true;
        int nLength = numbers.length;

        for (int i = 0; i < nLength; i++) {
            if (isBeginning && numbers[i] != '0') {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.printf("%c", numbers[i]);
            }
        }
        System.out.println();
    }

    public void print1toMaxOfNDigits2(int n) {
        if (n <= 0) {
            return;
        }
        char[] numbers = new char[n];
        process(numbers, n, 0);
    }

    private void process(char[] numbers, int n, int index) {
        if (index >= numbers.length) {
            printNumber(numbers);
            return;
        }
        for (int i = 0; i < 10; i++) {
            numbers[index] = (char) (i + '0');
            process(numbers, n, index + 1);
        }
    }

    public static void main(String[] args) {
        Q17_Print1ToMaxOfNDigits obj = new Q17_Print1ToMaxOfNDigits();
        obj.print1toMaxOfNDigits(3);
        obj.print1toMaxOfNDigits2(3);
    }
}
