/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No2_两数相加 {
    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        Solution21 solution = new Solution21();
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 遍历链表，处理进位
 */
class Solution21 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int signify = 0;
        ListNode header = new ListNode();
        ListNode tail = header;
        while (l1 != null && l2 != null) {
            int data = l1.val + l2.val + signify;
            signify = data / 10;
            data %= 10;
            tail.next = new ListNode(data);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        signify = handleRemind(tail, l1, signify);
        while (tail.next != null) {
            tail = tail.next;
        }
        signify = handleRemind(tail, l2, signify);
        while (tail.next != null) {
            tail = tail.next;
        }
        if (signify != 0) {
            tail.next = new ListNode(signify);
        }
        return header.next;
    }

    public int handleRemind(ListNode tail, ListNode list, int signify) {
        while (list != null) {
            int data = list.val + signify;
            signify = data / 10;
            data %= 10;
            tail.next = new ListNode(data);
            tail = tail.next;
            list = list.next;
        }
        return signify;
    }
}
