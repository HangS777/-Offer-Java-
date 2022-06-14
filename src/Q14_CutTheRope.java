public class Q14_CutTheRope {

    //给你一根长度为n的绳子，把绳子剪成m段（m、n都是整数且m > 1, n > 1）,
    //m段绳子的长度依然是整数,记为k[0],k[1],..,k[m]，求m段绳子的长度乘积最大为多少,
    // k[0] * k[1] * ... * k[m]，每段至少剪一刀？
    //比如绳子长度为8，我们可以分成2段、3段、4段...8段，
    //但是只有分成3段且长度分别是2、3、3时能得到最大乘积18

    //动态规划
    public int maxProductAfterCutting(int length) {
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        //length + 1是因为需要达到products[length];
        int[] products = new int[length + 1];
        // 0 ~ 3 位置储存的就是绳子长度，不是f(n), 4 位置及以后的才是储存的f(n)
        for (int i = 0; i < 4; i++) {
            products[i] = i;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 4; i <= length; i++) {
            //i代表绳子的长度
            for (int j = 1; j <= i / 2; j++) {
                //j代表i长度的绳子分段之后的部分长度, i-j代表另一部分长度
                products[i] = products[j] * products[i - j];
                max = Math.max(products[i], max);
            }
        }
        return max;
    }

    //贪心算法
    public int maxProductAfterCutting2(int length) {
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int timesOf3 = length / 3;
        if (length - 3 * timesOf3 == 1) {
            timesOf3 -= 1;
        }
        int timesOf2 = (length - 3 * timesOf3) / 2;

        return (int) Math.pow(2, timesOf2) * (int) Math.pow(3, timesOf3);
    }

    public static void main(String[] args) {
        Q14_CutTheRope obj = new Q14_CutTheRope();
        System.out.println(obj.maxProductAfterCutting(0));
        System.out.println(obj.maxProductAfterCutting(1));
        System.out.println(obj.maxProductAfterCutting(2));
        System.out.println(obj.maxProductAfterCutting(3));
        System.out.println(obj.maxProductAfterCutting(4));
        System.out.println(obj.maxProductAfterCutting(5));
        System.out.println(obj.maxProductAfterCutting(6));
        System.out.println("============================");
        System.out.println(obj.maxProductAfterCutting2(0));
        System.out.println(obj.maxProductAfterCutting2(1));
        System.out.println(obj.maxProductAfterCutting2(2));
        System.out.println(obj.maxProductAfterCutting2(3));
        System.out.println(obj.maxProductAfterCutting2(4));
        System.out.println(obj.maxProductAfterCutting2(5));
        System.out.println(obj.maxProductAfterCutting2(6));
    }
}
