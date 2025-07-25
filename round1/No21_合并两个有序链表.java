package round1;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No21_合并两个有序链表 {
    public static void main(String[] args) {

    }
}

class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode nodeA = list1;
        ListNode nodeB = list2;
        ListNode head = null;
        if (list1.val < list2.val) {
            head = nodeA;
            nodeA = nodeA.next;
        }
        else {
            head = nodeB;
            nodeB = nodeB.next;
        }
        ListNode tail = head;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val <= nodeB.val) {
                tail.next = nodeA;
                tail = tail.next;
                nodeA = nodeA.next;
            }
            else {
                tail.next = nodeB;
                tail = tail.next;
                nodeB = nodeB.next;
            }
        }
        if (nodeA != null) {
            tail.next = nodeA;
        }
        if (nodeB != null) {
            tail.next = nodeB;
        }
        return head;
    }
}
