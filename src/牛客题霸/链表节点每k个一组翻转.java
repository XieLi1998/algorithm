package 牛客题霸;

/**
 * Created by xieli on 2021/3/8.
 */
public class 链表节点每k个一组翻转 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        ListNode pre = tmp;
        ListNode end = tmp;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) {
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return tmp.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
