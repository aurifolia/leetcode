/**
 * @author vneli
 * @since 1.0
 */
public class No55_跳跃游戏 {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * @param args
     */
    public static void main(String[] args) {
        Solution551 solution = new Solution551();
        System.out.println(solution.canJump(new int[]{2,0,0}));
        System.out.println(solution.canJump(new int[]{2,3,1,1,4}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
    }
}

class Solution551 {
    public boolean canJump(int[] nums) {
        int maxLoc = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            int candidate = i + nums[i];
            if (maxLoc < candidate) {
                maxLoc = candidate;
            }
            if (i == end) {
                end = maxLoc;
            }
        }
        return end + 1 >= nums.length;
    }
}
