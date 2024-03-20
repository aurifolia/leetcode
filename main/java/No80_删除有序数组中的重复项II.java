/**
 * @author vneli
 * @since 1.0
 */
public class No80_删除有序数组中的重复项II {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param args
     */
    public static void main(String[] args) {
        Solution801 solution = new Solution801();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(nums));
        System.out.println();
    }
}

class Solution801 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int left = 1, right = 2;
        while (right < n) {
            if (nums[left] == nums[left - 1]) {
                while (right < n && nums[right] == nums[left]) {
                    right++;
                }
                if (right >= n) {
                    return left + 1;
                }
            }
            left++;
            if (left != right) {
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}
