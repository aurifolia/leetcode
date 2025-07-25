package round1;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No2_两数相加 {
}

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }
}
