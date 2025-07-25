package round1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Peng Dan
 * @since 1.0
 */
public class No160_相交链表 {
    public static void main(String[] args) {
        Solution160 solution160 = new Solution160();
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

class Solution160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            nodeSet.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null) {
            if (nodeSet.contains(node)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            if (nodeA == null) {
                nodeA = headB;
            }
            else {
                nodeA = nodeA.next;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
            else {
                nodeB = nodeB.next;
            }
        }
        return nodeA;
    }
}