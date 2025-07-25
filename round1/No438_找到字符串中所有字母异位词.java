package round1;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No438_找到字符串中所有字母异位词 {
    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution438.findAnagrams("abab", "ab"));
        System.out.println(solution438.findAnagrams("cbaebabccacd", "abccc"));
        System.out.println(solution438.findAnagrams("ivxqakfyaqahufxfizupjrkkifjlbfqfeprqrfjvxnubntdtlvz", "vxapufjqtnaviffihkpyrbrzfjenqtxlxfqkfjvazubkrdqluf"));
    }
}

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return Collections.emptyList();
        }
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] sourceCounter = new int[26];
        int[] targetCounter = new int[26];
        for (char pChar : pChars) {
            targetCounter[pChar - 'a']++;
        }
        for (int i = 0; i < pLength; i++) {
            sourceCounter[sChars[i] - 'a']++;
        }
        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sourceCounter, targetCounter)) {
            result.add(0);
        }
        int left = 0;
        int right = left + pLength;
        while (right < sLength) {
            sourceCounter[sChars[left] - 'a']--;
            sourceCounter[sChars[right] - 'a']++;
            left++;
            right++;
            if (Arrays.equals(sourceCounter, targetCounter)) {
                result.add(left);
            }
        }
        return result;
    }
}