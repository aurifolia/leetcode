import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 *
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No138_随机链表的复制 {
    public static void main(String[] args) {

    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution138 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Map<Node, Node> newMap = new HashMap<>();
        Node newHead = new Node(0);
        Node tail = newHead;
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, cur.random);
            tail.next = new Node(cur.val);
            tail = tail.next;
            newMap.put(cur, tail);
        }
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newNode = newMap.get(cur);
            Node random = map.get(cur);
            if (random != null) {
                newNode.random = newMap.get(random);
            }
        }
        return newHead.next;
    }
}
