/**
 * @author vneli
 * @since 1.0
 */
public class No42_接雨水 {
    public static void main(String[] args) {
        Solution422 solution = new Solution422();
        System.out.println(solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(solution.trap(new int[]{5,5,1,7,1,1,5,2,7,6}));
    }
}

class Solution421 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        while (left < right && height[left] == 0) {
            left++;
        }
        while (left < right && height[right] == 0) {
            right--;
        }
        int base = 0, sum = 0;
        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentSum = 0;
            for (int i = left + 1; i < right; i++) {
                int h = height[i];
                if (h < base) {
                    h = base;
                }
                if (h < currentHeight) {
                    currentSum += (currentHeight - h);
                }
            }
            sum += currentSum;
            base = currentHeight;
            if (height[left] < height[right]) {
                int current = height[left];
                while (left < right && height[left] <= current) {
                    left++;
                }
            }
            else if (height[left] > height[right]) {
                int current = height[right];
                while (left < right && height[right] <= current) {
                    right--;
                }
            }
            else {
                int current = height[left];
                while (left < right && height[left] <= current) {
                    left++;
                }
                current = height[right];
                while (left < right && height[right] <= current) {
                    right--;
                }
            }
        }
        return sum;
    }
}

class Solution422 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left < right) {
            if (leftMax < height[left]) {
                leftMax = height[left];
            }
            if (rightMax < height[right]) {
                rightMax = height[right];
            }
            if (height[left] < height[right]) {
                sum += leftMax - height[left];
                left++;
            }
            else {
                sum += rightMax - height[right];
                right--;
            }
        }
        return sum;
    }
}