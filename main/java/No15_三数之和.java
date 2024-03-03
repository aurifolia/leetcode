import java.util.*;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No15_三数之和 {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     *
     * 你返回所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     * @param args
     */
    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}

class Solution151 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int loc = 0;
        List<List<Integer>> result = new ArrayList<>();
        while (loc < nums.length) {
            if (loc > 0 && nums[loc] == nums[loc - 1]) {
                loc++;
                continue;
            }
            List<List<Integer>> lists = twoSum(nums, loc + 1, -nums[loc]);
            for (List<Integer> list : lists) {
                list.add(0, nums[loc]);
            }
            result.addAll(lists);
            loc++;
        }

        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int left, int target) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (left + 1 >= length) {
            return result;
        }
        int right = length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                left++;
            }
            else if (sum > target) {
                right--;
            }
            else {
                result.add(new ArrayList<>(Arrays.asList(nums[left], nums[right])));
                while (left + 1 < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (right - 1 > left && nums[right] == nums[right - 1]) {
                    right--;
                }
                left++;
                right--;
            }
        }
        return result;
    }
}
