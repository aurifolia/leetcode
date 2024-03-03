/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No19_删除链表的倒数第N个结点 {
    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @param args
     */
    public static void main(String[] args) {
        Solution191 solution = new Solution191();
        ListNode listNode = solution.removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution191 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        int loc = 0;
        ListNode fast = head, low = head, prior = head;
        while (fast != null && fast.next != null) {
            if (++loc % n == 0) {
                prior = low;
                low = low.next;
            }
            fast = fast.next;
        }
        int count = 0;
        fast = low;
        while (fast != null) {
            count++;
            fast = fast.next;
        }
        for (int i = count - n; i > 0; i--) {
            prior = low;
            low = low.next;
        }
        if (prior == low) {
            return head.next;
        }
        prior.next = low.next;
        return head;
    }
}
