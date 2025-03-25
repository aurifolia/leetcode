import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No146_LRU缓存 {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.get(2);
        lRUCache.put(2, 6); // 缓存是 {1=1}
        lRUCache.get(1); // 缓存是 {1=1, 2=2}
        lRUCache.put(1, 5); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(1, 2); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(2);    // 返回 3
    }
}

class LRUCache1 extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return super.size() > this.capacity;
    }
}


class LRUCache {
    private int capacity;
    private Map<Integer, Node> nodeMap = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        // 删除原节点
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        // 调整尾节点
        if (tail == node) {
            tail = node.pre;
        }
        // 添加到头部
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            get(key);
            nodeMap.get(key).value = value;
            return;
        }
        if (nodeMap.size() >= capacity) {
            // 删除尾节点
            tail.pre.next = null;
            nodeMap.remove(tail.key);
            tail = tail.pre;
        }
        Node node = new Node(key, value);
        addNode(node);
        nodeMap.put(key, node);
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next = node;
        if (node.next != null) {
            node.next.pre = node;
        }
        if (tail == head) {
            tail = node;
        }
    }

    class Node {
        private int key;
        private int value;
        private Node pre;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}