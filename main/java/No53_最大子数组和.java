/**
 * @author vneli
 * @since 1.0
 */
public class No53_最大子数组和 {
    public static void main(String[] args) {
        Solution533 solution = new Solution533();
        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

class Solution531 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (max < sum) {
                    max = sum;
                }
            }
        }
        return max;
    }
}

class Solution532 {
    public int maxSubArray(int[] nums) {
        return handle(nums, 0, nums.length - 1);
    }

    public int handle(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = (left + right) >>> 1;
        int leftMax = handle(nums, left, mid);
        int rightMax = handle(nums, mid + 1, right);
        int currentMax = nums[mid], currentSum = nums[mid];
        for (int i = mid - 1; i >= left; i--) {
            currentSum += nums[i];
            if (currentMax < currentSum) {
                currentMax = currentSum;
            }
        }
        currentSum = currentMax;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            if (currentMax < currentSum) {
                currentMax = currentSum;
            }
        }
        return Math.max(Math.max(leftMax, rightMax), currentMax);
    }
}

class Solution533 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] < 0 ? nums[i] : dp[i - 1] + nums[i];
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }
}
