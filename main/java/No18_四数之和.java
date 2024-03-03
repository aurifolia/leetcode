import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No18_四数之和 {
    public static void main(String[] args) {
        int i = 1000000000 + 1000000000 + 1000000000 + 1000000000;
        Solution181 solution = new Solution181();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(solution.fourSum(new int[]{2,2,2,2,2}, 8));
    }
}

class Solution181 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                long remind = (long) target - nums[i] - nums[j];
                int left = j + 1, right = length - 1;
                while (left < right) {
                    long sum = (long) nums[left] + nums[right];
                    if (sum < remind) {
                        left++;
                    }
                    else if (sum > remind) {
                        right--;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
            }
        }
        return result;
    }
}
