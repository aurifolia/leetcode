import java.util.HashMap;
import java.util.Map;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
 *
 * 请你实现 Trie 类：
 *
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No208_实现Trie_前缀树 {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}

class Trie {
    private Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }

    public void insert(String word) {
        insertCore(word.toCharArray(), 0);
    }

    private void insertCore(char[] chars, int start) {
        if (start == chars.length) {
            children.put('\0', null);
        }
        if (start < chars.length) {
            children.computeIfAbsent(chars[start], k -> new Trie()).insertCore(chars, start + 1);
        }
    }

    public boolean search(String word) {
        return searchCore(word.toCharArray(), 0);
    }

    private boolean searchCore(char[] chars, int start) {
        if (start == chars.length) {
            return children.containsKey('\0');
        }
        if (!children.containsKey(chars[start])) {
            return false;
        }
        return children.get(chars[start]).searchCore(chars, start + 1);
    }

    public boolean startsWith(String prefix) {
        return startWith(prefix.toCharArray(), 0);
    }

    private boolean startWith(char[] chars, int start) {
        if (start == chars.length) {
            return true;
        }
        if (!children.containsKey(chars[start])) {
            return false;
        }
        return children.get(chars[start]).startWith(chars, start + 1);
    }
}
