/**
 * @author vneli
 * @since 1.0
 */
public class No92_反转链表II {
    public static void main(String[] args) {
        Solution921 solution = new Solution921();
        ListNode listNode = solution.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution921 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode leftPrior = null, tailNode = head;
        for (int i = 1; i < left; i++) {
            leftPrior = tailNode;
            tailNode = tailNode.next;
        }
        ListNode leftNode = tailNode;
        ListNode next = tailNode.next;
        for (int i = left; i < right; i++) {
            ListNode nextNext = next.next;
            next.next = tailNode;
            tailNode = next;
            next = nextNext;
        }

        if (leftPrior != null) {
            leftPrior.next = tailNode;
        }
        leftNode.next = next;
        return leftPrior == null ? tailNode : head;
    }
}
