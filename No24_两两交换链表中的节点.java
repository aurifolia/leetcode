/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No24_两两交换链表中的节点 {
}

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = head;
        ListNode pre = head;
        ListNode cur = null;
        ListNode lastPre = pre;
        if (pre != null && pre.next != null) {
            cur = pre.next;
            newHead = cur;
            ListNode temp = cur.next;
            cur.next = pre;
            pre.next = temp;
            lastPre = pre;
            pre = pre.next;
        }
        while (pre != null && pre.next != null) {
            cur = pre.next;
            lastPre.next = cur;
            ListNode temp = cur.next;
            cur.next = pre;
            pre.next = temp;
            lastPre = pre;
            pre = pre.next;
        }
        return newHead;
    }
}
