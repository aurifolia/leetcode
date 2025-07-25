package round1;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No42_接雨水 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        System.out.println(solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

class Solution42 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            if (leftHeight <= rightHeight) {
                left++;
                while (left < right && height[left] <= leftHeight) {
                    sum += leftHeight - height[left];
                    left++;
                }
            }
            else {
                right--;
                while (left < right && height[right] <= rightHeight) {
                    sum += rightHeight - height[right];
                    right--;
                }
            }
        }
        return sum;
    }
}
