/**
 * @author vneli
 * @since 1.0
 */
public class No82_删除排序链表中的重复元素II {
    public static void main(String[] args) {
        Solution821 solution = new Solution821();
//        ListNode listNode = solution.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5))))))));
//        ListNode listNode = solution.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3))))));
        ListNode listNode = solution.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2))));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution821 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = null, tail = null;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                if (tail != null) {
                    tail.next = head;
                }
                continue;
            }
            else {
                if (newHead == null) {
                    newHead = head;
                }
            }
            tail = head;
            head = head.next;
        }
        if (newHead == null && head != null) {
            newHead = head;
        }
        return newHead;
    }
}
