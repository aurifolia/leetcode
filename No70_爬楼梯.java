/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No70_爬楼梯 {

}

class Solution70 {
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int pre1 = 1;
        int pre = 2;
        for (int i = 2; i < n; i++) {
            int temp = pre;
            pre = pre1 + pre;
            pre1 = temp;
        }
        return pre;
    }
}
