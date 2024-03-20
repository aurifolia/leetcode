/**
 * @author vneli
 * @since 1.0
 */
public class No72_编辑距离 {
    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     *
     * 你可以对一个单词进行如下三种操作：
     *
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * @param args
     */
    public static void main(String[] args) {
        Solution721 solution = new Solution721();
        System.out.println(solution.minDistance("horse", "ros"));
        System.out.println(solution.minDistance("ros", "horse"));
        System.out.println(solution.minDistance("intention", "execution"));
    }
}

class Solution721 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n1; i++) {
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n2; j++) {
                if (c1 == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1]));
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[n1][n2];
    }
}
