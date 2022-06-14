import java.util.HashSet;

public class Q38_StringPermutation {

    // 输入一个字符串，打印出该字符串中字符的所有排列。例如，输入字符串abc，
    // 则打印由字符a，b，b所能排列出来的所有字符串abc，acb，bac，bca，cab和cba。

    public void permutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        permutationProcess(arr, 0);

    }

    private void permutationProcess(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(String.valueOf(arr));
        } else {
            for (int i = index; i < arr.length; i++) {
                swap(arr, index, i);
                permutationProcess(arr, index + 1);
                swap(arr, index, i);
            }
        }

    }

    private void swap(char[] arr, int i, int index) {
        char temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

    // 补充题目：再上题基础上加一个条件，所有的排列不能出现重复的。
    // 例如，acc字符串，在上述方法会打印出两个acc，两个cca，还有两个cac字符串。
    // 现在需要确保无重复字符串出现，即只有一个acc，一个cca，还有一个cac字符串。

    public void permutationNoRepeat(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        permutationNoRepeatProcess(arr, 0);

    }

    private void permutationNoRepeatProcess(char[] arr, int index) {
        if (index == arr.length) {
            System.out.println(String.valueOf(arr));
        } else {
            boolean[] visited = new boolean[256];
            for (int i = index; i < arr.length; i++) {
                if (!visited[arr[i]]) {
                    visited[arr[i]] = true;
                    swap(arr, index, i);
                    permutationNoRepeatProcess(arr, index + 1);
                    swap(arr, index, i);
                }
            }
        }
    }

    // 扩展题目，求字符的所有组合，例如字符a，b，c，则它们的组合有a，b，c，ab，ac，bc，abc。
    // 注意：ab和ba是不同的排列，但是算是一个组合。
    // 此题也可看成是求abc字符串的所有的无重复子序列。

    public void subsequenceNoRepeat(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] arr = str.toCharArray();
        String path = "";
        HashSet<String> set = new HashSet<String>();
        subsequenceNoRepeatProcess(arr, set, 0, path);
        for (String s : set) {
            if (s.equals("")) {
                System.out.println("null");
            } else {
                System.out.println(s);
            }

        }
    }

    private void subsequenceNoRepeatProcess(char[] arr, HashSet<String> set, int index, String path) {
        if (index == arr.length) {
            set.add(path);
            return;
        }
        // 没有要index位置的字符
        subsequenceNoRepeatProcess(arr, set, index + 1, path);
        // 要了index位置的字符
        subsequenceNoRepeatProcess(arr, set, index + 1, path + String.valueOf(arr[index]));
    }


    public static void main(String[] args) {
        Q38_StringPermutation obj = new Q38_StringPermutation();
        String str = "abc";
        String str2 = "acc";
        System.out.println("First:");
        obj.permutation(str);
        System.out.println("============");
        obj.permutation(str2);
        System.out.println();

        System.out.println("Second:");
        obj.permutationNoRepeat(str);
        System.out.println("============");
        obj.permutationNoRepeat(str2);
        System.out.println();

        System.out.println("Third: (打印出来的包含空子序列)");
        obj.subsequenceNoRepeat(str);
        System.out.println("============");
        obj.subsequenceNoRepeat(str2);
        System.out.println("============");
    }
}
