package 牛客题霸;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xieli on 2021/3/21.
 */
public class 设计getMin功能的栈 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public int[] getMinStack(int[][] op) {

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < op.length; i++) {
            if (op[i][0] == 1) {       // 为 1 就入栈
                push(op[i][1]);
            } else if (op[i][0] == 2) {     // 为 2 就出栈
                pop();
            } else {
                list.add(getMin());        // 为 3 就返回栈中最小元素
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || min.peek() >= x)
            min.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(min.peek()))
                min.pop();
            stack.pop();
        }

    }

    public int getMin() {
        return min.peek();
    }

}
