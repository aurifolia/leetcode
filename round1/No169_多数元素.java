package round1;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No169_多数元素 {
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res == nums[i]) {
                sum++;
            }
            else {
                sum--;
            }
            if (sum == 0) {
                res = nums[i + 1];
                sum = 0;
            }
        }
        return res;
    }
}
