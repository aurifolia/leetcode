import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No3_无重复字符的最长子串 {
    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution3.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution3.lengthOfLongestSubstring("pwwkew"));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int length = chars.length;
        while (right < length) {
            if (!map.containsKey(chars[right])) {
                map.put(chars[right], right);
                right++;
                continue;
            }
            int candidate = right - left;
            if (maxLength < candidate) {
                maxLength = candidate;
            }
            Integer newLeft = map.get(chars[right]);
            while (left <= newLeft) {
                map.remove(chars[left]);
                left++;
            }
        }
        return Math.max(maxLength, right - left);
    }
}