/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No11_盛最多水的容器 {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     *
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * 返回容器可以储存的最大水量。
     *
     * 说明：你不能倾斜容器。
     * @param args
     */
    public static void main(String[] args) {
        Solution111 solution = new Solution111();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

/**
 * 双指针
 */
class Solution111 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int candidate = Math.min(height[left], height[right]) * (right - left);
            if (max < candidate) {
                max = candidate;
            }
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
