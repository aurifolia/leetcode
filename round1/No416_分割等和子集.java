package round1;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No416_分割等和子集 {
    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.canPartition(new int[]{1, 5, 11, 5}));
    }
}

class Solution416 {
    public boolean canPartition(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        if ((sum & 1) == 1 || max > (sum >> 1)) {
            return false;
        }
        int target = sum >> 1;
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
            dp[i][nums[i]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][target];
    }
}
