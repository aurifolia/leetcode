package round1;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组是数组中的一个连续部分。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No53_最大子数组和 {
    public static void main(String[] args) {
        Solution53 solution53 = new Solution53();
        System.out.println(solution53.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

class Solution53 {
    public int maxSubArray1(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            int curMax = 0;
            for (int j = i; j < length; j++) {
                curMax += nums[j];
                if (max < curMax) {
                    max = curMax;
                }
            }
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        return maxSubArrayCore(nums, 0, nums.length - 1);
    }

    public int maxSubArrayCore(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int mid = (left + right) / 2;
        int leftMax = maxSubArrayCore(nums, left, mid - 1);
        int rightMax = maxSubArrayCore(nums, mid + 1, right);
        int maxLeft = 0;
        for (int i = mid - 1, curLeft = 0; i >= left; i--) {
            curLeft += nums[i];
            if (maxLeft < curLeft) {
                maxLeft = curLeft;
            }
        }
        int maxRight = 0;
        for (int i = mid + 1, curRight = 0; i <= right; i++) {
            curRight += nums[i];
            if (maxRight < curRight) {
                maxRight = curRight;
            }
        }
        int maxMid = nums[mid] + maxLeft + maxRight;
        return Math.max(maxMid, Math.max(leftMax, rightMax));
    }

    public int maxSubArray3(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        int candidate = nums[0];
        for (int i = 1; i < length; i++) {
            if (candidate < 0) {
                candidate = nums[i];
            }
            else {
                candidate += nums[i];
            }
            max = Math.max(max, Math.max(candidate, nums[i]));
        }
        return max;
    }

    public int maxSubArray4(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            int cur = Math.max(nums[i], pre + nums[i]);
            if (max < cur) {
                max = cur;
            }
            pre = cur;
        }
        return max;
    }
}