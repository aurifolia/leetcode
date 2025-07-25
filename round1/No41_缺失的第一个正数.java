package round1;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No41_缺失的第一个正数 {
    public static void main(String[] args) {
        Solution41 solution41 = new Solution41();
        System.out.println(solution41.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(solution41.firstMissingPositive(new int[]{1, 2, 0}));
    }
}

class Solution41 {
    public int firstMissingPositive1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return length + 1;
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
