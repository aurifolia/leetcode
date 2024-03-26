import com.sun.security.jgss.GSSUtil;

/**
 * @author vneli
 * @since 1.0
 */
public class No83_删除排序链表中的重复元素 {
    public static void main(String[] args) {
        Solution831 solution = new Solution831();
        ListNode listNode = solution.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3))))));
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution831 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prior = head, tail = head.next;
        while (tail != null) {
            if (prior.val == tail.val) {
                prior.next = tail.next;
            }
            else {
                prior = tail;
            }
            tail = tail.next;
        }
        return head;
    }
}
