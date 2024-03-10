/**
 * @author vneli
 * @since 1.0
 */
public class No41_缺失的第一个正数 {
    public static void main(String[] args) {
        Solution411 solution = new Solution411();
//        System.out.println(solution.firstMissingPositive(new int[]{1}));
//        System.out.println(solution.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(solution.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(solution.firstMissingPositive(new int[]{7,8,9,11,12}));
        System.out.println(solution.firstMissingPositive(new int[]{1,2,0}));
    }
}

class Solution411 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
