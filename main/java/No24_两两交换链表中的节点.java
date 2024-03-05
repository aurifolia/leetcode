/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No24_两两交换链表中的节点 {
    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * @param args
     */
    public static void main(String[] args) {
        Solution241 solution = new Solution241();
        ListNode listNode = solution.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3))));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution241 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, low = head, newHead = fast;
        low.next = fast.next;
        fast.next = low;
        ListNode temp = low;
        low = fast;
        fast = temp;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode prior = low.next;
            low = low.next.next;
            low.next = fast.next;
            fast.next = low;
            prior.next = fast;
            temp = low;
            low = fast;
            fast = temp;
        }
        return newHead;
    }
}
