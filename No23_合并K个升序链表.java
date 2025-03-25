import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No23_合并K个升序链表 {
    public static void main(String[] args) {

    }
}

class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new ArrayDeque<>();
        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (queue.size() > 1) {
            queue.offer(merge(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newTail.next = l1;
                l1 = l1.next;
            }
            else {
                newTail.next = l2;
                l2 = l2.next;
            }
            newTail = newTail.next;
        }
        if (l1 != null) {
            newTail.next = l1;
        }
        if (l2 != null) {
            newTail.next = l2;
        }
        return newHead.next;
    }
}
