import java.util.Arrays;
import java.util.Map;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No238_除自身以外数组的乘积 {
    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        System.out.println(Arrays.toString(solution238.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] leftArr = new int[length];
        int[] rightArr = new int[length];
        leftArr[0] = 1;
        for (int i = 1; i < length; i++) {
            leftArr[i] = leftArr[i - 1] * nums[i - 1];
        }
        rightArr[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1];
        }
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = leftArr[i] * rightArr[i];
        }
        return result;
    }
}
