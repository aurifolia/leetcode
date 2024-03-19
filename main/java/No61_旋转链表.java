/**
 * @author vneli
 * @since 1.0
 */
public class No61_旋转链表 {
    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param args
     */
    public static void main(String[] args) {
        Solution611 solution = new Solution611();
        ListNode listNode = solution.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 15);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution611 {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode originTail = head;
        for (ListNode tail = head; tail != null ; tail = tail.next) {
            length++;
            originTail = tail;
        }
        if (length == 0) {
            return head;
        }
        if (k >= length) {
            k %= length;
        }
        if (k == 0) {
            return head;
        }
        int step = length - k;
        ListNode tail = head, pre = head;
        while (step > 0) {
            pre = tail;
            tail = tail.next;
            step--;
        }
        originTail.next = head;
        pre.next = null;
        return tail;
    }
}
