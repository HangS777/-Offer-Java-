public class Q43_NumberOf1 {

    // 输入一个整数n，求1~n这n个整数的十进制表示中1出现的次数。
    // 例如，输入12，1~12这些整数种包含1的数字有1，10，11，12，
    // 1一共出现了5次。

    // 解法一：无脑拼接数数
    public int numberOf1Between1AndN_1(int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(i);
        }
        int count = 0;
        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }

    // 解法二：利用数字规律，神仙解法

    /*
     * 注意：这个只是个人的理解，不一定对，只是帮助我个人去理解整个计算过程！
     *
     * 首先将一个数分为高位和低位两个部分，例如 n = 21345，
     * 当 m = 1，a = 21345， b = 0， curr = 5
     *          当前个位数上的是5，是大于1的数，所以高位2134决定了个位有2134个1会出现，
     *          再加上个位本身1次，也就是count_1 = 2135次
     * 当 m = 10，a = 2134， b = 5， curr = 4
     *           当前个位数上的是4，是大于1的数，所以高位213决定了低位有2130个1会出现，
     *           再加上十位本身10次，也就是count_2 = 2140次
     * 当 m = 100，a = 213， b = 45， curr = 3
     *            当前个位数上的是3，是大于1的数，所以高位21决定了低位有2100个1会出现，
     *            再加上百位本身100次，也就是count_3 = 2200次
     * 当 m = 1000，a = 21， b = 345， curr = 1
     *             当前个位数上的是1，是等于1的数，所以高位2决定了低位有2000个1会出现，
     *             再加上因为千位本身是1，我们还需要加上1000~1345出现的346次1，
     *             也就是count_4 = 2346次
     * 当 m = 10000，a = 2， b = 1345， curr = 2
     *              当前个位数上的是2，是大于1的数，所以高位0决定了低位有0个1会出现，
     *              再加上万位本身10000次，也就是count_5 = 10000次
     * 所以总的count = count_1 + count_2 + count_3 + count_4 + count_5
     *              = 2135 + 2140 + 2200 + 2346 + 10000
     *              = 18821次
     */
    public int numberOf1Between1AndN_2(int n){
        int count = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            // curr表示当前位数上的值
            int curr = a % 10;

            if (curr == 0) {
                // 当前数位为0
                count += a / 10 * m;
            } else if (curr == 1) {
                // 当前数位为1
                count += a / 10 * m + b + 1;
            } else {
                // 当前数位大于1
                count += (a / 10 + 1) * m;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q43_NumberOf1 obj = new Q43_NumberOf1();
        long startTime = System.nanoTime();
        System.out.println(obj.numberOf1Between1AndN_1(21345));
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime+ " nano seconds");

        long startTime2 = System.nanoTime();
        System.out.println(obj.numberOf1Between1AndN_2(21345));
        System.currentTimeMillis();
        long endTime2   = System.nanoTime();
        long totalTime2 = endTime2 - startTime2;
        System.out.println(totalTime2 + " nano seconds");
    }
}
