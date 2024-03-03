import java.util.Arrays;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No16_最接近的三数之和 {
    public static void main(String[] args) {
        Solution161 solution = new Solution161();
        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

class Solution161 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int candidate = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - candidate) < Math.abs(target - sum)) {
                    sum = candidate;
                }
                if (candidate < target) {
                    left++;
                }
                else if (candidate > target){
                    right--;
                }
                else {
                    return sum;
                }
            }
        }
        return sum;
    }

}
