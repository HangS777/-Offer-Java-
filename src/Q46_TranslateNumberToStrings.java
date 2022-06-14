public class Q46_TranslateNumberToStrings {

    // 给定一个数字，我们按照如下的规则把它翻译为字符串：0翻译成"a",1翻译成"b"，...,
    // 11翻译成"l"，...，25翻译成"z"。一个数字可能有多个翻译，例如，12258有5种不同
    // 的翻译，分别是"bccfi"，"bwfi","bczi","mcfi","mzi".

    //解法一：递归
    public int translateNumberToString(int number) {
        if (number < 0) {
            return 0;
        }
        String str = String.valueOf(number);
        return translateProcess(str.toCharArray(), 0);
    }

    private int translateProcess(char[] arr, int i) {
        if (i == arr.length) {
            return 1;
        }
        // i没到最后，说明有字符
        // 可能性1：当前位置单转
        int method = translateProcess(arr, i + 1);
        // 可能性2：当前位置和下一个位置的字符一起转
        if (i + 1 < arr.length && (arr[i] - '0') * 10 + (arr[i] - '0') <= 25
                && (arr[i] - '0') * 10 + (arr[i] - '0') >= 0) {
            method += translateProcess(arr, i + 2);
        }
        return method;
    }

    // 解法二：动态规划,从右往左
    public int translateNumberToString2(int number) {
        if (number < 0) {
            return 0;
        }
        String str = String.valueOf(number);
        char[] arr = str.toCharArray();
        int[] dp = new int[arr.length + 1];
        dp[arr.length] = 1;
        for(int i = arr.length - 1; i >=0; i--){
            // 可能性1：当前位置单转
            int method = dp[i + 1];
            // 可能性2：当前位置和下一个位置的字符一起转
            if (i + 1 < arr.length && (arr[i] - '0') * 10 + (arr[i] - '0') <= 25
                    && (arr[i] - '0') * 10 + (arr[i] - '0') >= 0) {
                method += dp[i + 2];
            }
            dp[i] = method;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Q46_TranslateNumberToStrings obj = new Q46_TranslateNumberToStrings();
        System.out.println(obj.translateNumberToString(12258));
        System.out.println(obj.translateNumberToString2(12258));

        System.out.println(obj.translateNumberToString(2));
        System.out.println(obj.translateNumberToString2(2));

        System.out.println(obj.translateNumberToString(0));
        System.out.println(obj.translateNumberToString2(0));

        System.out.println(obj.translateNumberToString(-1));
        System.out.println(obj.translateNumberToString2(-1));

        System.out.println(obj.translateNumberToString(2526));
        System.out.println(obj.translateNumberToString2(2526));
    }
}