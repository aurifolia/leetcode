package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No15_三数之和 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            List<int[]> candidate = findCandidate(nums, i + 1, length - 1, -nums[i]);
            for (int[] ints : candidate) {
                result.add(Arrays.asList(nums[i], ints[0], ints[1]));
            }
            int num = nums[i];
            while (i + 1 < length && nums[i + 1] == num) {
                i++;
            }
        }
        return result;
    }

    private List<int[]> findCandidate(int[] nums, int left, int right, int target) {
        List<int[]> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            }
            else if (sum < target) {
                left++;
            }
            else {
                result.add(new int[]{nums[left], nums[right]});
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                right--;
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return result;
    }
}
