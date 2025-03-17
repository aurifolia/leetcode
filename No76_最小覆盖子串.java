import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No76_最小覆盖子串 {
    public static void main(String[] args) {
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(solution76.minWindow("A", "A"));
        System.out.println(solution76.minWindow("ab", "b"));
    }
}

class Solution76 {
    public String minWindow1(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLength = s.length();
        int tLength = t.length();
        Map<Character, Integer> targetCounter = new HashMap<>();
        for (char tChar : tChars) {
            targetCounter.put(tChar, targetCounter.getOrDefault(tChar, 0) + 1);
        }
        int left = 0;
        int right = Integer.MAX_VALUE;
        for (int i = 0; i <= sLength - tLength; i++) {
            Map<Character, Integer> sourceCounter = new HashMap<>();
            for (int j = i; j < sLength; j++) {
                sourceCounter.put(sChars[j], sourceCounter.getOrDefault(sChars[j], 0) + 1);
                boolean match = true;
                for (Map.Entry<Character, Integer> entry : targetCounter.entrySet()) {
                    if (sourceCounter.getOrDefault(entry.getKey(), 0).intValue() < entry.getValue().intValue()) {
                        match = false;
                        break;
                    }
                }
                if (match && (right - left) > (j - i)) {
                    left = i;
                    right = j;
                }
            }
        }
        return right == Integer.MAX_VALUE ? "" : s.substring(left, right + 1);
    }

    public String minWindow2(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int sLength = s.length();
        int tLength = t.length();
        Map<Character, Integer> targetCounter = new HashMap<>();
        Map<Character, Integer> sourceCounter = new HashMap<>();
        for (char tChar : tChars) {
            targetCounter.put(tChar, targetCounter.getOrDefault(tChar, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE - 1;
        while (right < sLength) {
            sourceCounter.put(sChars[right], sourceCounter.getOrDefault(sChars[right], 0) + 1);
            while (match(sourceCounter, targetCounter) && left <= right) {
                if (minRight - minLeft > right - left) {
                    minRight = right;
                    minLeft = left;
                }
                sourceCounter.put(sChars[left], sourceCounter.getOrDefault(sChars[left], 1) - 1);
                left++;
            }
            right++;
        }
        return minRight == Integer.MAX_VALUE - 1 ? "" : s.substring(minLeft, minRight + 1);
    }

    public String minWindow(String s, String t) {
        char[] sourceChars = s.toCharArray();
        char[] targetChars = t.toCharArray();
        int sourceLength = sourceChars.length;
        int targetLength = targetChars.length;
        if (sourceLength < targetLength) {
            return "";
        }
        Set<Character> set = new HashSet<>();
        // 0和正数表示涵盖
        int[] counter = new int[256];
        for (int i = 0; i < targetLength; i++) {
            set.add(targetChars[i]);
            counter[sourceChars[i]]++;
            counter[targetChars[i]]--;
        }
        int diff = 0;
        for (int i = 0; i < counter.length; i++) {
            if (set.contains((char) i) && counter[i] < 0) {
                diff++;
            }
        }
        int minLeft = 0;
        int minRight = diff == 0 ? targetLength : Integer.MAX_VALUE;
        int left = 0;
        int right = targetLength;
        while (right < sourceLength) {
            while (diff > 0 && right < sourceLength) {
                char candidate = sourceChars[right];
                if (set.contains(candidate)) {
                    counter[candidate]++;
                    if (counter[candidate] == 0) {
                        diff--;
                    }
                }
                right++;
            }
            while (diff == 0 && left < right) {
                if (minRight - minLeft > right - left) {
                    minLeft = left;
                    minRight = right;
                }
                char candidate = sourceChars[left];
                if (set.contains(candidate)) {
                    counter[candidate]--;
                    if (counter[candidate] == -1) {
                        diff++;
                    }
                }
                left++;
            }
        }
        return minRight == Integer.MAX_VALUE ? "" : s.substring(minLeft, minRight);
    }

    private boolean match(Map<Character, Integer> source, Map<Character, Integer> target) {
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            if (source.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}