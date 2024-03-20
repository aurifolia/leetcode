/**
 * @author vneli
 * @since 1.0
 */
public class No75_颜色分类 {
    public static void main(String[] args) {
        Solution751 solution = new Solution751();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        System.out.println();
    }
}

class Solution751 {
    public void sortColors(int[] nums) {
        sort(nums);
    }

    public void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public void fastSort(int[] nums, int left, int right) {
        int base = nums[left];
        int leftBak = left, rightBak = right;
        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
