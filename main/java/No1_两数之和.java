import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No1_两数之和 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     *
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     *
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     *
     *
     * 提示：
     *
     * 2 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * 只会存在一个有效答案
     * @param args
     */
    public static void main(String[] args) {
        Solution12 solution = new Solution12();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}

/**
 * 解法一
 * 排序 + 双指针
 */
class Solution11 {
    public int[] twoSum(int[] nums, int target) {
        // 先排序
        Wrapper[] wrappers = new Wrapper[nums.length];
        for (int i = 0; i < nums.length; i++) {
            wrappers[i] = new Wrapper(nums[i], i);
        }
        Arrays.sort(wrappers, Comparator.comparingInt(a -> a.value));
        // 双指针
        int left = 0, right = wrappers.length - 1;
        while (left <= right) {
            int value = wrappers[left].value + wrappers[right].value;
            if (value == target) {
                return new int[]{wrappers[left].index, wrappers[right].index};
            } else if (value > target) {
                while (left <= right && wrappers[right - 1].value == wrappers[right].value) {
                    right--;
                }
                right--;
            } else {
                while (left <= right && wrappers[left].value == wrappers[left + 1].value) {
                    left++;
                }
                left++;
            }
        }
        return new int[]{wrappers[left].index, wrappers[right].index};
    }

    class Wrapper {
        int value;
        int index;

        public Wrapper(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}

/**
 * 解法2
 * 使用Map记录num[i]和i, {num[i]: i}
 * 然后遍历nums，对于num[i], 如果map里存在target - num[i]，那么就找到结果了
 */
class Solution12 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null && i != index) {
                return new int[]{i, index};
            }
        }
        return null;
    }
}
