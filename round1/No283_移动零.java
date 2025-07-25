package round1;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No283_移动零 {
    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = {0, 1, 0, 3, 12};
        solution283.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283 {
    public void moveZeroes1(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;
        while (zeroIndex < length) {
            while (zeroIndex < length && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            int nonZeroIndex = zeroIndex + 1;
            while (nonZeroIndex < length && nums[nonZeroIndex] == 0) {
                nonZeroIndex++;
            }
            if (nonZeroIndex < length) {
                nums[zeroIndex] = nums[nonZeroIndex];
                nums[nonZeroIndex] = 0;
            }
            zeroIndex++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;
        while (zeroIndex < length) {
            while (zeroIndex < length && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            int nonZeroIndex = zeroIndex + 1;
            while (nonZeroIndex < length && nums[nonZeroIndex] == 0) {
                nonZeroIndex++;
            }
            if (nonZeroIndex >= length) {
                break;
            }
            nums[zeroIndex] = nums[nonZeroIndex];
            nums[nonZeroIndex] = 0;
            zeroIndex++;
        }
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = 0;
        while (right < length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}