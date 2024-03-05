/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No25_K个一组翻转链表 {
    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * @param args
     */
    public static void main(String[] args) {
        Solution251 solution = new Solution251();
        ListNode listNode = solution.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class Solution251 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        ListNode newHeader = null, left = head, right = head;
        ListNode priorBak = null;
        while (true) {
            int loc = 0;
            while (loc < k && right != null) {
                right = right.next;
                loc++;
            }
            // 需要反转
            if (loc == k) {
                ListNode prior = left, leftBak = left;
                left = left.next;
                while (left != right) {
                    ListNode temp = left.next;
                    left.next = prior;
                    prior = left;
                    left = temp;
                }
                leftBak.next = left;
                if (priorBak != null) {
                    priorBak.next = prior;
                }
                if (newHeader == null) {
                    newHeader = prior;
                }
                priorBak = leftBak;
            }
            if (right == null) {
                break;
            }
        }
        return newHeader != null ? newHeader : head;
    }
}
