package round1;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No198_打家劫舍 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob(new int[]{1, 2, 3, 1}));
    }
}

class Solution198 {
    public int rob1(int[] nums) {
        return robCore(nums, 0, 0, new boolean[nums.length]);
    }

    public int robCore(int[] nums, int loc, int current, boolean[] visited) {
        if (loc == nums.length) {
            return current;
        }
        int max = 0;
        if (loc == 0 || loc > 0 && !visited[loc - 1]) {
            visited[loc] = true;
            max = robCore(nums, loc + 1, current + nums[loc], visited);
            visited[loc] = false;
        }
        return Math.max(max, robCore(nums, loc + 1, current, visited));
    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }
}
