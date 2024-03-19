/**
 * @author vneli
 * @since 1.0
 */
public class No62_不同路径 {
    public static void main(String[] args) {
        Solution621 solution = new Solution621();
        System.out.println(solution.uniquePaths(3, 7));
    }
}

class Solution621 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
