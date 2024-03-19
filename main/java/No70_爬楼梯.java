/**
 * @author vneli
 * @since 1.0
 */
public class No70_爬楼梯 {
    public static void main(String[] args) {
        Solution702 solution = new Solution702();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(45));
    }
}

class Solution701 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

class Solution702 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[ i - 2];
        }
        return dp[n - 1];
    }
}
