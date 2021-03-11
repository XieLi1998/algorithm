package 牛客题霸;

/**
 * Created by xieli on 2021/3/12.
 */
public class 链表求和 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 反向存放
     * (7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     *
     * @param l1
     * @param l2
     * @return
     */
    // 非递归
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        return head.next;
    }

    // 递归
    public ListNode addTwoNumbers_02(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        helper(cur, l1, l2, 0);
        return head.next;
    }

    private void helper(ListNode cur, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0)
            return;
        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        carry = sum / 10;
        cur.next = new ListNode(sum % 10);
        cur = cur.next;
        l1 = l1 != null ? l1.next : null;
        l2 = l2 != null ? l2.next : null;
        helper(cur, l1, l2, carry);
    }

    /**
     * 正向存放
     *
     * 解法：反转链表后再相加
     *
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        int carry = 0;
        while (head1 != null || head2 != null || carry != 0) {
            int sum = (head1 != null ? head1.val : 0) + (head2 != null ? head2.val : 0) + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            head1 = head1 != null ? head1.next : null;
            head2 = head2 != null ? head2.next : null;
        }
        return reverse(head.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}
