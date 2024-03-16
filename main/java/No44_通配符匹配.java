/**
 * @author vneli
 * @since 1.0
 */
public class No44_通配符匹配 {
    public static void main(String[] args) {
        Solution441 solution = new Solution441();
//        System.out.println(solution.isMatch("ab", "ab"));
        System.out.println(solution.isMatch("aa", "*"));
    }
}

class Solution441 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            }
            else {
                break;
            }
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
                else {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        return p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1);
    }
}
