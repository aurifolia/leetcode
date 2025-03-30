/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No35_搜索插入位置 {
    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        System.out.println(solution35.searchInsert(new int[]{1, 3, 5, 6}, 4));
    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int current = nums[mid];
            if (current == target) {
                return mid;
            }
            if (current > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}
