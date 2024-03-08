/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No35_搜索插入位置 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * @param args
     */
    public static void main(String[] args) {
        Solution351 solution = new Solution351();
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(solution.searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(solution.searchInsert(new int[]{1,3}, 2));
    }
}

class Solution351 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int closer = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
                closer = left;
            }
            else if (nums[mid] > target) {
                right = mid - 1;
                closer = right;
            }
            else {
                return mid;
            }
        }
        if (closer < 0) {
            closer = 0;
        }
        if (closer >= nums.length) {
            return closer;
        }
        else {
            return nums[closer] < target ? closer + 1 : closer;
        }
    }
}
