/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No5_最长回文子串 {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     * @param args
     */
    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        System.out.println(solution.longestPalindrome("cbbd"));
    }
}

/**
 * 暴力法
 */
class Solution51 {
    public String longestPalindrome(String s) {
        int length = s.length();
        int left = 0, right = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (judge(s, i, j)) {
                    if (j - i > right - left) {
                        left = i;
                        right = j;
                    }
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public boolean judge(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

/**
 * 中心拓展
 */
class Solution52 {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        int length = s.length();
        for (int i = 0; i < length - 1; i++) {
            int[] max = getMax(s, i - 1, i + 1);
            if (max[1] - max[0] > right - left) {
                left = max[0];
                right = max[1];
            }
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                max = getMax(s, i, i + 1);
                if (max[1] - max[0] > right - left) {
                    left = max[0];
                    right = max[1];
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public int[] getMax(String s, int l1, int l2) {
        int length = s.length();
        int left = 0, right = 0;
        while (l1 >= 0 && l2 < length) {
            if (s.charAt(l1) != s.charAt(l2)) {
                break;
            }
            if (l2 - l1 > right - left) {
                left = l1;
                right = l2;
            }
            l1--;
            l2++;
        }
        return new int[]{left, right};
    }
}