package round1;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No25_K个一组翻转链表 {
    public static void main(String[] args) {

    }
}

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode left = head;
        ListNode right = nextK(head, k);
        ListNode lastRight = null;
        if (right != null) {
            head = right;
        }
        while (right != null) {
            ListNode nextLeft = right.next;
            // 反转
            ListNode pre = left;
            ListNode cur = left.next;
            pre.next = null;
            while (pre != right) {
                ListNode temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            // 调整块级指针
            if (lastRight != null) {
                lastRight.next = right;
            }
            lastRight = left;
            left = nextLeft;
            right = nextK(nextLeft, k);
        }
        if (left != null) {
            lastRight.next = left;
        }
        return head;
    }

    private ListNode nextK(ListNode cur, int k) {
        while (cur != null && k > 1) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
