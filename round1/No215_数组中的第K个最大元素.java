package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No215_数组中的第K个最大元素 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(solution215.findKthLargest(nums, 1));
        System.out.println(solution215.findKthLargest(nums, 2));
        System.out.println(solution215.findKthLargest(nums, 3));
        System.out.println(solution215.findKthLargest(nums, 4));
        System.out.println(solution215.findKthLargest(nums, 5));
        System.out.println(solution215.findKthLargest(nums, 6));
    }
}

class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargestCore(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    public int findKthLargestCore(int[] nums, int left, int right, int k) {
        int leftCopy = left;
        int rightCopy = right;
        int target = nums[left];
        int hole = left;
        while (left < right) {
            while (left < right && nums[right] >= target) {
                right--;
            }
            nums[hole] = nums[right];
            hole = right;
            while (left < right && nums[left] <= target) {
                left++;
            }
            nums[hole] = nums[left];
            hole = left;
        }
        nums[hole] = target;
        if (hole == k - 1) {
            return nums[hole];
        }
        else if (hole < k - 1) {
            return findKthLargestCore(nums, hole + 1, rightCopy, k);
        }
        else {
            return findKthLargestCore(nums, leftCopy, hole - 1, k);
        }
    }

    public void quickSort1(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int leftCopy = left;
        int rightCopy = right;
        int base = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        int temp = nums[leftCopy];
        nums[leftCopy] = nums[right];
        nums[right] = temp;
        quickSort1(nums, leftCopy, right - 1);
        quickSort1(nums, right + 1, rightCopy);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int leftCopy = left;
        int rightCopy = right;
        int hole = left;
        int target = nums[hole];
        while (left < right) {
            while (left < right && nums[right] >= target) {
                right--;
            }
            swap(nums, hole, right);
            hole = right;
            while (left < right && nums[left] <= target) {
                left++;
            }
            swap(nums, hole, left);
            hole = left;
        }
        nums[hole] = target;
        quickSort(nums, leftCopy, hole - 1);
        quickSort(nums, hole + 1, rightCopy);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int findKthLargest1(int[] nums, int k) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return findKthLargest(list, k);
    }

    public int findKthLargest(List<Integer> nums, int k) {
        List<Integer> leftList = new ArrayList<>();
        List<Integer> middleList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int target = nums.get(k - 1);
        for (Integer num : nums) {
            if (num < target) {
                leftList.add(num);
            }
            else if (num > target) {
                rightList.add(num);
            }
            else {
                middleList.add(num);
            }
        }
        if (k <= rightList.size()) {
            return findKthLargest(rightList, k);
        }
        else if (k <= rightList.size() + middleList.size()) {
            return target;
        }
        else {
            return findKthLargest(leftList, k - rightList.size() - middleList.size());
        }
    }
}
