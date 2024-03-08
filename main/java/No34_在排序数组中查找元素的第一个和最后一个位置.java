import java.util.Arrays;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No34_在排序数组中查找元素的第一个和最后一个位置 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution341 solution = new Solution341();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 6)));
    }
}

class Solution341 {
    public int[] searchRange(int[] nums, int target) {
        int index = find(nums, 0, nums.length - 1, target);
        if (index == -1) {
            return new int[]{-1, -1};
        }
        int first = index, last = index;
        while (true) {
            int newFirst = find(nums, 0, first - 1, target);
            if (newFirst == -1) {
                break;
            }
            first = newFirst;
        }
        while (true) {
            int newLast = find(nums, last + 1, nums.length - 1, target);
            if (newLast == -1) {
                break;
            }
            last = newLast;
        }
        return new int[]{first, last};
    }

    public int find(int[] nums, int left, int right, int target) {
        if (left == right) {
            return nums[left] == target ? left : -1;
        } else if (left > right) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
