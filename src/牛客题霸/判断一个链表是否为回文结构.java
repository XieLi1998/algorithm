package 牛客题霸;

import java.util.Stack;

/**
 * Created by xieli on 2021/4/5.
 */
public class 判断一个链表是否为回文结构 {


    public class ListNode {
        int val;
        ListNode next = null;
    }

    public boolean isPail(ListNode head) {
        if (head == null) {
            return true;
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode index = head;
        while (index != null) {
            stack.add(index);
            index = index.next;
        }

        index = head;
        while (index != null) {
            if (index.val != stack.pop().val) {
                return false;
            }
            index = index.next;
        }

        return true;
    }

}
