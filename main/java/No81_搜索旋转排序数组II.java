/**
 * @author vneli
 * @since 1.0
 */
public class No81_搜索旋转排序数组II {
    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     *
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     *
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     *
     * 你必须尽可能减少整个操作步骤。
     * @param args
     */
    public static void main(String[] args) {
        Solution811 solution = new Solution811();
        System.out.println(solution.search(new int[]{3,3,0,1,3}, 1));
        System.out.println(solution.search(new int[]{1,2,3,0,1,1}, 3));
        System.out.println(solution.search(new int[]{0,0,1,1,2,0}, 2));
        System.out.println(solution.search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1}, 2));
        System.out.println(solution.search(new int[]{1,0,1,1,1}, 0));
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(solution.search(new int[]{2,5,6,0,0,1,2}, 3));
    }
}

class Solution811 {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                if (nums[mid] < target && nums[nums.length - 1] >= target) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
