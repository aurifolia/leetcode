package round1;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No141_环形链表 {
    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
