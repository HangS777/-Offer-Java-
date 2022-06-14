public class Q48_LongestSubstringWithoutDuplication {

    // 请从字符串种找出一个最长的不包含重复字符的子字符串，计算该
    // 最长子字符串的长度。假设字符串中只包含‘a’~'z'的字符。
    // 例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4.

    public int longestSubstringWithoutDuplication(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int currLength = 0;
        int maxLength = 0;

        int[] lastIndex = new int[26];
        for (int i = 0; i < 25; i++) {
            lastIndex[i] = -1;
        }

        for (int i = 0; i < str.length(); i++) {
            int prevIndex = lastIndex[str.charAt(i) - 'a'];

            if (prevIndex < 0 || i - prevIndex > currLength) { // 当前字符没有出现过或者出现在最长字符串之前
                currLength++;

            } else { // 当前字符出现过且出现在最长字符串中间
                // 字符重复出现，记录当前最长字符串
                if (currLength > maxLength) {
                    maxLength = currLength;
                }
                // 更新为两个重复字符串中间的长度
                currLength = i - prevIndex;
            }
            // 更新字符最后出现的位置
            lastIndex[str.charAt(i) - 'a'] = i;
        }
        // 当最后一个字符没有出现或者出现在最长字符串之前,此时当前长度加+1，但是还需要更新最大长度
        if (currLength > maxLength) {
            maxLength = currLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q48_LongestSubstringWithoutDuplication obj = new Q48_LongestSubstringWithoutDuplication();
        String s = "arabcacfr";
        String s2 = "a";
        String s3 = "aaaaaaaaaa";
        String s4 = "abcdefg";
        System.out.println(obj.longestSubstringWithoutDuplication(s));
        System.out.println(obj.longestSubstringWithoutDuplication(s2));
        System.out.println(obj.longestSubstringWithoutDuplication(s3));
        System.out.println(obj.longestSubstringWithoutDuplication(s4));

    }
}
