/**
 * @author Peng Dan
 * @since 1.0
 */
public class No19_删除链表的倒数第N个结点 {
    public static void main(String[] args) {

    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = slow;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if (pre == slow) {
            head = pre.next;
        }
        else {
            pre.next = slow.next;
        }
        return head;
    }
}
