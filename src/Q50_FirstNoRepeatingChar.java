public class Q50_FirstNoRepeatingChar {

    // 题目一：字符串中第一个只出现一次的字符
    // 在字符串中找出第一个只出现一次的字符。如输入"abaccdeff",则输出'b'.

    public char firstNoRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return '0';
        }
        // char是长度为8的的数据类型，因此总共有256种可能
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            arr[str.charAt(i)]++;
        }
        // 重新遍历字符看它出现的次数
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {

                return str.charAt(i);
            }
        }
        return '0';
    }

    // 补充题目1：输入两个字符串，从第一个字符串中删除在第二个字符串中出过
    // 的所有字符。例如，从第一个字符串"We are students."中删除第二个
    // 字符串"aeiou"中出现过的字符, 得到结果是"W r Stdnts."
    public String deleteSecondStrFromFirstStr(String first, String second) {
        if (first == null || first.length() == 0) {
            return null;
        }
        if (second == null || second.length() == 0) {
            return first;
        }
        boolean[] checkAppear = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < second.length(); i++) {
            checkAppear[second.charAt(i)] = true;
        }
        for (int i = 0; i < first.length(); i++) {
            if (checkAppear[first.charAt(i)]) {
                continue;
            } else {
                sb.append(first.charAt(i));
            }
        }
        return sb.toString();
    }

    // 补充题目2：删除字符串中所有重复出现的字符。例如，输入"google"，
    // 删除重复的字符之后的结果是"gole"。
    public String deleteRepateChar(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 1) {
            return "";
        }
        boolean[] checkAppear = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            checkAppear[str.charAt(i)] = false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (checkAppear[str.charAt(i)]) {
                continue;
            } else {
                checkAppear[str.charAt(i)] = true;
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    // 补充题目3：如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，
    // 那么这两个单词互为变位词Anagram。例如silent和listen，evil与live。
    // 请写一个函数看两个字符串是不是变位词。
    public boolean areTheyAnagram(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) {
            return false;
        }
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] checkAppear = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            checkAppear[str1.charAt(i)] += 1;
        }
        for (int i = 0; i < str2.length(); i++) {
            checkAppear[str2.charAt(i)] -= 1;
        }
        boolean theyAreAnagram = true;
        for (int i = 0; i < checkAppear.length; i++) {
            if (checkAppear[i] != 0) {
                theyAreAnagram = false;
                break;
            }
        }
        return theyAreAnagram;
    }


    // 题目二：字符流中第一个只出现一次的字符
    // 请实现一个函数，用来找出字符流中第一个只出现一次的字符。
    // 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'；
    // 当从该字符串读出前6个字符"google"时，第一个只出现一次的字符是'l'。
    public static class AppearOnceInStream {
        private int[] count;//记录每个字符出现的位置，-1表示没有出现过，-2表示出现过多次
        private int index = 0;//字符在字符串中出现的位置

        public AppearOnceInStream() {
            count = new int[256];
            for (int i = 0; i < count.length; i++) {
                count[i] = -1;
            }
        }

        public void insert(char c) {
            if (count[c] == -1) { //如果之前这个字符没出现过，那么将它第一次出现的位置记录下来
                count[c] = index;
            } else if (count[c] >= 0) { //如果这个字符已经出现过一次，那么此时是第二次出现，直接设置为-2表示忽略
                count[c] = -2;
            }
            index++;
        }

        public char firstAppearOnceChar() {
            int minIndex = Integer.MAX_VALUE;
            char result = '0';//默认为‘0’表示没有一个数满足要求
            for (int i = 0; i < count.length; i++) {
                //找出出现过一次且位置最考前的字符
                if (count[i] >= 0 && count[i] < minIndex) {
                    minIndex = count[i];
                    result = (char) i;
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Q50_FirstNoRepeatingChar obj = new Q50_FirstNoRepeatingChar();
        System.out.println(obj.firstNoRepeatingChar("iabcdefg"));
        System.out.println(obj.firstNoRepeatingChar("aacdcebdefg"));
        System.out.println("=========================");
        System.out.println(obj.deleteSecondStrFromFirstStr("We are students.", "aeiou"));
        System.out.println("=========================");
        System.out.println(obj.deleteRepateChar("google"));
        System.out.println(obj.deleteRepateChar("apple"));
        System.out.println(obj.deleteRepateChar("a"));
        System.out.println("=========================");
        System.out.println(obj.areTheyAnagram("silent", "listen"));
        System.out.println(obj.areTheyAnagram("evil", "live"));
        System.out.println(obj.areTheyAnagram("event", "events"));
        System.out.println("=========================");
        AppearOnceInStream obj2 = new AppearOnceInStream();
        obj2.insert('g');
        obj2.insert('o');
        System.out.println(obj2.firstAppearOnceChar());
        obj2.insert('o');
        obj2.insert('g');
        System.out.println(obj2.firstAppearOnceChar());
        obj2.insert('l');
        obj2.insert('e');
        System.out.println(obj2.firstAppearOnceChar());
    }
}
