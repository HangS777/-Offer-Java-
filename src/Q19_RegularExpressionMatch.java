public class Q19_RegularExpressionMatch {

    // 题目：请实现一个函数用来匹配包含'.'和'*'的正则表达式。
    // 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次），
    // 在本题中，匹配是指字符串的所有字符匹配整个模式。
    // 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
    // 但与"aa.a"和"ab*a"均不匹配

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }
        return matchCore(str, pattern, 0, 0);

    }

    private boolean matchCore(char[] str, char[] pattern, int i, int j) {
        if (i == str.length && j == pattern.length) {
            return true;
        }
        if (i < str.length && j == pattern.length) {
            return false;
        }
        //如果第二个字符是'*'
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            if ((i != str.length && str[i] == pattern[j])
                    || (i != str.length && pattern[j] == '.')) {
                //'*'符号上一个字符出现一次
                return matchCore(str, pattern, i + 1, j + 2)
                        //'*'符号上一个字符出现多次
                        || matchCore(str, pattern, i + 1, j)
                        //'*'符号上一个字符出现0次
                        || matchCore(str, pattern, i, j + 2);
            } else {
                //此时表示上一个字符不匹配，那么可以认为不匹配字符出现0次
                return matchCore(str, pattern, i, j + 2);
            }
        }
        // 如果第二个字符不是'*'
        if ((i != str.length && str[i] == pattern[j])
                || (i != str.length && pattern[j] == '.')) {
            return matchCore(str, pattern, i + 1, j + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Q19_RegularExpressionMatch obj = new Q19_RegularExpressionMatch();
        char[] str = new char[]{'a', 'a', 'a'};
        char[] pattern = new char[]{'a', '.', 'a'};
        char[] pattern2 = new char[]{'a', 'b', '*', 'a', 'c', '*', 'a'};
        char[] pattern3 = new char[]{'a', 'a', '.', 'a'};
        char[] pattern4 = new char[]{'a', 'b', '*', 'a'};

        System.out.println(obj.match(str, pattern));
        System.out.println(obj.match(str, pattern2));
        System.out.println(obj.match(str, pattern3));
        System.out.println(obj.match(str, pattern4));
    }
}
