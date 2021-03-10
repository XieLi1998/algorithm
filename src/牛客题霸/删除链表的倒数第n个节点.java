package 牛客题霸;

/**
 * Created by xieli on 2021/3/10.
 */
public class 删除链表的倒数第n个节点 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode start = pre, end = pre;
        for (int i = 0; i < n; i++) {
            start = start.next;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;
        return pre.next;
    }

}
