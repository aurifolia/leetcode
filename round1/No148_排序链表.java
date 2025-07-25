package round1;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No148_排序链表 {
    public static void main(String[] args) {
        Solution148 solution148 = new Solution148();
        // -1,5,3,4,0
        ListNode listNode = solution148.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0))))));
    }
}

class Solution148 {
    public ListNode sortList1(ListNode head) {
        for (ListNode cur = head; cur != null; cur = cur.next) {
            for (ListNode next = cur.next; next != null; next = next.next) {
                if (cur.val > next.val) {
                    int temp = cur.val;
                    cur.val = next.val;
                    next.val = temp;
                }
            }
        }
        return head;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        return sortListCore(head, last);
    }

    public ListNode sortListCore(ListNode left, ListNode right) {
        if (left == right) {
            left.next = null;
            return left;
        }
        ListNode mid = getMid(left, right);
        ListNode next = mid.next;
        ListNode l1 = sortListCore(left, mid);
        ListNode l2 = sortListCore(next, right);
        return merge(l1, l2);
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right && fast.next.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return newHead.next;
    }

    public ListNode sortList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        for (int gap = 1; gap < length; gap<<=1) {
            ListNode pre = newHead;
            cur = newHead.next;
            while (cur != null) {
                ListNode leftHead = cur;
                ListNode leftTail = cur;
                for (int i = 1; leftTail.next != null && i < gap; i++) {
                    leftTail = leftTail.next;
                }
                ListNode rightHead = leftTail.next;
                ListNode rightTail = rightHead;
                if (rightHead != null) {
                    for (int i = 1; rightTail.next != null && i < gap; i++) {
                        rightTail = rightTail.next;
                    }
                }
                ListNode next = rightTail == null ? null : rightTail.next;
                leftTail.next = null;
                if (rightTail != null) {
                    rightTail.next = null;
                }
                pre.next = merge(leftHead, rightHead);
                while (pre.next != null) {
                    pre = pre.next;
                }
                pre.next = next;
                cur = next;
            }
        }
        return newHead.next;
    }
}
