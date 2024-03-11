/**
 * @author vneli
 * @since 1.0
 */
public class No44_通配符匹配 {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 0; i < p.length() + 1; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            char sc = s.charAt(i - 1);
            for (int j = 1; j <= p.length(); j++) {
                if (match(sc, p.charAt(j - 1))) {

                }
                else {

                }
            }
        }
    }

    public boolean match(char a, char b) {
        return b == '?' || b == '*' || a == b;
    }
}
