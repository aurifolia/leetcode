import java.util.Stack;

/**
 * @author vneli
 * @since 1.0
 */
public class No84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        Solution842 solution = new Solution842();
        System.out.println(solution.largestRectangleArea(new int[]{1}));
        System.out.println(solution.largestRectangleArea(new int[]{2,4}));
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

class Solution841 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int candidate = findWithLoc(heights, i);
            if (candidate > max) {
                max = candidate;
            }
        }
        return max;
    }

    public int findWithLoc(int[] height, int loc) {
        int left = loc, right = loc;
        int base = height[loc];
        while (left >= 0) {
            if (height[left] < base) {
                break;
            }
            left--;
        }
        while (right < height.length) {
            if (height[right] < base) {
                break;
            }
            right++;
        }
        return base * (right - left - 1);
    }
}

class Solution842 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLoc = new int[n];
        int[] rightLoc = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                leftLoc[i] = -1;
            }
            else {
                int base = heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] >= base) {
                    stack.pop();
                }
                leftLoc[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                rightLoc[i] = n;
            }
            else {
                int base = heights[i];
                while (!stack.isEmpty() && heights[stack.peek()] >= base) {
                    stack.pop();
                }
                rightLoc[i] = stack.isEmpty() ? n : stack.peek();
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int candidate = (rightLoc[i] - leftLoc[i] - 1) * heights[i];
            if (max < candidate) {
                max = candidate;
            }
        }
        return max;
    }
}
