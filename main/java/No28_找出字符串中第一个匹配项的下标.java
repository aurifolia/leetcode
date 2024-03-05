/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No28_找出字符串中第一个匹配项的下标 {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     * 示例 2：
     *
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     * @param args
     */
    public static void main(String[] args) {
        Solution281 solution = new Solution281();
        System.out.println(solution.strStr("sadbutsad", "sad"));
        System.out.println(solution.strStr("leetcode", "leeto"));
    }
}

class Solution281 {
    public int strStr(String haystack, String needle) {
        int la = haystack.length();
        int lb = needle.length();
        if (la < lb) {
            return -1;
        }
        for (int i = 0; i < la; i++) {
            if (la - i < lb) {
                break;
            }
            int j = 0;
            while (j < lb) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == lb) {
                return i;
            }
        }
        return -1;
    }
}
