/**
 * @author vneli
 * @since 1.0
 */
public class No64_最小路径和 {
    public static void main(String[] args) {
        Solution641 solution = new Solution641();
        System.out.println(solution.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
        System.out.println(solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
}

class Solution641 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
}
