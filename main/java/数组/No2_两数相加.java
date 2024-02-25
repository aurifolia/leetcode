package 数组;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No2_两数相加 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int remind = 0;
            ListNode result = new ListNode();
            ListNode tail = result;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + remind;
                remind = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                int sum = l1.val + remind;
                remind = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l1 = l1.next;
            }

            while (l2 != null) {
                int sum = l2.val + remind;
                remind = sum / 10;
                sum = sum % 10;
                tail.next = new ListNode(sum);
                tail = tail.next;
                l2 = l2.next;
            }

            if (remind != 0) {
                tail.next = new ListNode(remind);
            }
            return result.next;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
