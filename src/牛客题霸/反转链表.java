package 牛客题霸;

/**
 * Created by xieli on 2021/2/21.
 */
public class 反转链表 {

    // 双指针迭代, 空间复杂度O(1)
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;

        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 递归
    public ListNode ReverseList_02(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = ReverseList(head.next);
        head.next.next=head;
        head.next=null;
        return cur;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
