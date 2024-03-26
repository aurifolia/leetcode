/**
 * @author vneli
 * @since 1.0
 */
public class No86_分隔链表 {
    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     *
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * @param args
     */
    public static void main(String[] args) {
        Solution861 solution = new Solution861();
        ListNode partition = solution.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3);
        while (partition != null) {
            System.out.println(partition.val);
            partition = partition.next;
        }
    }
}

class Solution861 {
    public ListNode partition(ListNode head, int x) {
        ListNode prior1 = head, tail1 = head, prior2 = head, tail2 = head;
        ListNode newHead = null;
        while (tail1 != null) {
            if (tail1.val >= x) {
                prior2 = tail1;
                tail2 = tail1.next;
                while (tail2 != null) {
                    if (tail2.val < x) {
                        if (prior1 == tail1) {
                            prior2.next = tail2.next;
                            tail2.next = head;
                            newHead = tail2;
                        }
                        else {
                            prior2.next = tail2.next;
                            ListNode temp = prior1.next;
                            prior1.next = tail2;
                            tail2.next = temp;
                        }
                        tail1 = tail2;
                        break;
                    }
                    prior2 = tail2;
                    tail2 = tail2.next;
                }
            }
            prior1 = tail1;
            tail1 = tail1.next;
        }
        return newHead == null ? head : newHead;
    }
}
