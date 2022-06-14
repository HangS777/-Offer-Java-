import java.util.Stack;

public class Q31_StackPushPopOrder {

    // 输入两个整数序列，第一个序列表示栈的压入顺序，请判断
    // 第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
    // 例如， 序列{1，2，3，4，5}是某栈的压栈顺序
    // 序列{4，5，3，2，1}是该栈的压栈序列对应的一个弹出序列
    // 但{4，3，5，1，2}就不可能是该栈压栈序列的弹出序列

    public boolean isPopOrder(int[] push, int[] pop, int len) {
        boolean possible = false;

        if (push != null && pop != null && len > 0) {
            int pushIndex = 0;
            int popIndex = 0;
            Stack<Integer> stack = new Stack<Integer>();

            //栈中都能对应弹出才是对应序列，所以用pooIndex
            while (popIndex < len) {
                while (stack.isEmpty() || stack.peek() != pop[popIndex]) {
                    if (pushIndex == len) {
                        break;
                    }
                    stack.push(push[pushIndex++]);
                }
                //如果push元素加完都没对应的pop值，则不是对应序列
                if (stack.peek() != pop[popIndex]) {
                    break;
                }
                //栈中最顶元素是弹出元素
                int popV = stack.pop();
                popIndex++;
            }
            //全部弹出且一一对应则是弹出序列
            if (stack.isEmpty() && popIndex == len) {
                possible = true;
            }
        }
        return possible;
    }

    public static void main(String[] args) {
        Q31_StackPushPopOrder obj = new Q31_StackPushPopOrder();

        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};

        System.out.println(obj.isPopOrder(push, pop, 5));

        int[] pop2 = new int[]{4, 3, 5, 1, 2};

        System.out.println(obj.isPopOrder(push, pop2, 5));
    }
}
