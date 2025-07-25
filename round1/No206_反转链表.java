package round1;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No206_反转链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution206 solution206 = new Solution206();
        ListNode listNode1 = solution206.reverseList(listNode);
        System.out.println();
    }
}

class Solution206 {
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode headNode = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            headNode.next = preNode;
            preNode = headNode;
            headNode = nextNode;
            nextNode = nextNode.next;
        }
        headNode.next = preNode;
        return headNode;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode preNode = null;
        ListNode newHead = head;
        ListNode nextNode = null;
        while (newHead != null) {
            nextNode = newHead.next;
            newHead.next = preNode;
            preNode = newHead;
            newHead = nextNode;
        }
        return preNode;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode nextNode = head.next;
        head.next = null;
        while (nextNode != null) {
            ListNode curNode = nextNode;
            nextNode = nextNode.next;
            curNode.next = newHead;
            newHead = curNode;
        }
        return newHead;
    }
}
