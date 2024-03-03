import java.util.*;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No3_无重复字符的最长子串 {
    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
     * 子串
     *  的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     * @param args
     */
    public static void main(String[] args) {
        Solution32 solution = new Solution32();
        System.out.println(solution.lengthOfLongestSubstring("au"));
    }
}

/**
 * 暴力法
 * 两层循环
 */
class Solution31 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();
            set.add(charArray[i]);
            int j = i + 1;
            for (; j < length; j++) {
                if (set.contains(charArray[j])) {
                    break;
                }
                set.add(charArray[j]);
            }
            int candidate = j - i;
            if (maxLength < candidate) {
                maxLength = candidate;
            }
        }
        return maxLength;
    }
}

/**
 * 双指针发
 * 使用一个map，一个指针从左至右扫描字符，
 * 把扫描到的字符拿到map里去查询，如果有就说明重复了，左指针向右移动一个。
 */
class Solution32 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return 1;
        }
        int left = 0, right = 1;
        Map<Character, Integer> map = new LinkedHashMap<>(length);
        map.put(s.charAt(0), 0);
        int maxLength = -1;
        while (right < length) {
            char c = s.charAt(right);
            Integer i = map.get(c);
            if (i != null) {
                Iterator<Character> iterator = map.keySet().iterator();
                while (iterator.hasNext()) {
                    Character next = iterator.next();
                    iterator.remove();
                    if (next.equals(c)) {
                        break;
                    }
                }
                left = i + 1;
            }
            map.put(c, right);
            int candidateMaxLength = right - left;
            if (maxLength < candidateMaxLength) {
                maxLength = candidateMaxLength;
            }
            right++;
        }
        return maxLength + 1;
    }
}