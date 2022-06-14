public class Q58_ReverseWordsInSentence {

    // 题目一：反转单词顺序
    // 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
    // 为了简单起见，标点符号和普通字母一样处理。例如：输入字符串"I am a student."
    // 输出："student. a am I".

    // 题目一，解法一：整体反转再单词反转
    public String reverseSentence(String str) {
        if (str == null) {
            return null;
        }
        char[] arr = str.toCharArray();
        // 反转整体
        reverse(arr, 0, arr.length - 1);

        int start = 0;
        int end = 0;

        // 反转单词
        while (start < arr.length) {
            if (arr[start] == ' ') {
                // 避免空格,因为start和end应该分别指向一个单词的首尾字母
                start++;
                end++;
            } else if (end == arr.length || arr[end] == ' ') { // 两个条件不能换顺序，要先判断是不是到结尾了
                // end为空格，说明end位置之前为一个单词，反转
                reverse(arr, start, --end);
                // 让start指向end当前的空格
                start = ++end;
            } else {
                end++;
            }
        }
        return String.valueOf(arr);
    }

    // 反转整个字符串，包括每个单词的内部顺序
    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start++, end--);
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 题目一，解法二：利用split函数
    public String reverseSentence2(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String[] arr = str.split(" ");
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // 题目二：左旋转字符串
    // 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
    // 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串“abcdefg”
    // 和数字2，该函数将返回左旋转两位得到结果“cdefgab”。

    public String leftRotateString(String str, int n) {
        if (str != null) {
            char[] arr = str.toCharArray();
            int length = arr.length;
            if (n > 0 && length > 0 && n < length) {
                int first_start = 0;
                int first_end = n - 1;

                int second_start = n;
                int second_end = length - 1;

                // 反转前部分ab -> ba, 整体-> bacdefg
                reverse(arr, first_start, first_end);
                // 反转后部分cdefg -> gfedc, 整体 -> bagfedc
                reverse(arr, second_start, second_end);
                // 反转整体, bagfedc -> cdefgab
                reverse(arr, first_start, second_end);

                return String.valueOf(arr);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Q58_ReverseWordsInSentence obj = new Q58_ReverseWordsInSentence();
        String s = "I am a student.";
        System.out.println(obj.reverseSentence(s));
        System.out.println(obj.reverseSentence2(s));
        System.out.println("==================");
        String s2 = "abcdefg";
        System.out.println(obj.leftRotateString(s2, 0));
        System.out.println(obj.leftRotateString(s2, 1));
        System.out.println(obj.leftRotateString(s2, 2));
        System.out.println(obj.leftRotateString(s2, 3));

    }
}
