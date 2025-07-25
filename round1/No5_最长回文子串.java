package round1;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No5_最长回文子串 {
    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        System.out.println(solution5.longestPalindrome("aacabdkacaa"));
    }
}

class Solution5 {
    public String longestPalindrome1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = 2;
                    }
                    else {
                        if (dp[i + 1][j - 1] > 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        }
                    }
                    dp[j][i] = dp[i][j];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j == 1) {
                        dp[i][j] = 2;
                    }
                    else {
                        if (dp[j + 1][i - 1] > 0) {
                            dp[i][j] = dp[j + 1][i - 1] + 2;
                        }
                    }
                    dp[j][i] = dp[i][j];
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        start = j;
                        end = i;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
