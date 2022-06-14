public class Q05_ReplaceSpace {

    //请实现一个函数，将一个字符串中的空格替换成“%20”。
    //例如，当字符串为We Are Happy.
    //则经过替换之后的字符串为We%20Are%20Happy。


    public String replaceSpace1(StringBuilder sb) {
        return sb.toString().replaceAll("\\s", "%20");
    }

    // no alter original String
    public String replaceSpace2(StringBuilder sb) {
        if (sb == null || sb.isEmpty()) {
            return null;
        }
        int length = sb.toString().length();
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (sb.toString().charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int newLength = length + spaceCount * 2;
        char[] arr = sb.toString().toCharArray();
        char[] newArr = new char[newLength];

        int p1 = length - 1;
        int p2 = newLength - 1;
        while (p1 >= 0) {
            if (arr[p1] != ' ') {
                newArr[p2--] = arr[p1--];
            } else {
                p1--;
                newArr[p2--] = '0';
                newArr[p2--] = '2';
                newArr[p2--] = '%';
            }
        }
        return  String.valueOf(newArr);
    }

    // no extra space
    public String replaceSpace3(StringBuilder sb){
        if (sb == null || sb.isEmpty()) {
            return null;
        }
        int spaceCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        int p1 = sb.length() - 1;
        sb.setLength(sb.length() + spaceCount * 2);
        int p2 = sb.length() - 1;
        while (p1 >= 0 && p2 > p1) {
            if (sb.charAt(p1) == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
            } else {
                sb.setCharAt(p2--, sb.charAt(p1));
            }
            p1--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q05_ReplaceSpace obj = new Q05_ReplaceSpace();
        StringBuilder sb = new StringBuilder("We are happy.");
        System.out.println(sb.toString());
        System.out.println(obj.replaceSpace1(sb));

        System.out.println(sb.toString());
        System.out.println(obj.replaceSpace2(sb));

        System.out.println(sb.toString());
        System.out.println(obj.replaceSpace3(sb));
    }
}
