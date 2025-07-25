package round1;

import java.util.Arrays;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No34_在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        System.out.println(Arrays.toString(solution34.searchRange(new int[]{1,2,3,3,3,3,4,5,9}, 3)));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int current = nums[mid];
            if (current == target) {
                // 查找左边界
                int leftEnd = mid;
                int leftStart = 0;
                while (leftStart <= leftEnd) {
                    int mid1 = leftStart + ((leftEnd - leftStart) >> 1);
                    if (nums[mid1] < target) {
                        leftStart = mid1 + 1;
                    }
                    else {
                        leftEnd = mid1 - 1;
                    }
                }
                leftEnd = Math.max(0, leftEnd);
                if (nums[leftEnd] != target) {
                    leftEnd++;
                }
                // 查找右边界
                int rightStart = mid;
                int rightEnd = nums.length - 1;
                while (rightStart <= rightEnd) {
                    int mid2 = rightStart + ((rightEnd - rightStart) >> 1);
                    if (nums[mid2] > target) {
                        rightEnd = mid2 - 1;
                    }
                    else {
                        rightStart = mid2 + 1;
                    }
                }
                rightStart = Math.min(rightStart, nums.length - 1);
                if (nums[rightStart] != target) {
                    rightStart--;
                }
                return new int[]{leftEnd, rightStart};
            }
            else if (current > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
