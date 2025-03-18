import java.util.Arrays;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No189_轮转数组 {
    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution189.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution189 {
    public void rotate(int[] nums, int k) {
        if (k >= nums.length) {
            k = k % nums.length;
        }
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
