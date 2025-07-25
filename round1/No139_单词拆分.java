package round1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No139_单词拆分 {
}

class Solution139 {
    public boolean wordBreak1(String s, List<String> wordDict) {
        TrieNode trieNode = new TrieNode();
        for (String word : wordDict) {
            trieNode.insert(word);
        }
        return wordBreakCore(s, trieNode, trieNode, 0);
    }

    private boolean wordBreakCore(String s, TrieNode trieNode, TrieNode rootNode, int start) {
        if (start == s.length()) {
            return trieNode.isWord;
        }
        trieNode = trieNode.search(s.charAt(start));
        if (trieNode == null) {
            return false;
        }
        if (trieNode.isWord && wordBreakCore(s, rootNode, rootNode, start + 1)) {
            return true;
        }
        return wordBreakCore(s, trieNode, rootNode, start + 1);
    }

    private class TrieNode {
        private boolean isWord;
        private TrieNode[] children;

        public TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }

        public void insert(String word) {
            insertCore(word, 0);
        }

        public void insertCore(String word, int index) {
            if (index == word.length()) {
                this.isWord = true;
                return;
            }
            TrieNode child = children[word.charAt(index) - 'a'];
            if (child == null) {
                child = new TrieNode();
                children[word.charAt(index) - 'a'] = child;
            }
            child.insertCore(word, index + 1);
        }

        public TrieNode search(char c) {
            return children[c - 'a'];
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordSet.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
