package round1;

import java.util.Arrays;

/**
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 *
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 *
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 * 给你一个整数数组 nums ，找出 nums 的下一个排列。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No31_下一个排列 {
    public static void main(String[] args) {
        Solution31 solution31 = new Solution31();
        int[] nums = {100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,
                80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,
                57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,
                34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,
                11,10,9,8,7,6,5,4,3,2,1};
        solution31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = nums.length - 2;
        while (left >= 0) {
            if (nums[left] < nums[left + 1]) {
                break;
            }
            left--;
        }
        if (left < 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int right = nums.length - 1;
        while (right >= 0) {
            if (nums[right] > nums[left]) {
                break;
            }
            right--;
        }
        swap(nums, left, right);
        reverse(nums, left + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
