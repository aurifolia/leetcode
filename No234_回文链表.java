import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No234_回文链表 {
    public static void main(String[] args) {

    }
}

class Solution234 {
    public boolean isPalindrome1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode low = head;
        ListNode fast = head;
        // 将low定位到中间位置
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            low = low.next;
        }
        // 将low后面的都翻转
        ListNode rightNode = low.next;
        low.next = null;
        ListNode nextNode = rightNode.next;
        rightNode.next = null;
        while (nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = rightNode;
            rightNode = nextNode;
            nextNode = temp;
        }
        // 比较
        while (head != null && rightNode != null) {
            if (head.val != rightNode.val) {
                return false;
            }
            head = head.next;
            rightNode = rightNode.next;
        }
        return true;
    }
}
