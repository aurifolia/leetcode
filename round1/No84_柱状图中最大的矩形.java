package round1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No84_柱状图中最大的矩形 {
    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        System.out.println(solution84.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] leftIndexes = new int[heights.length];
        int[] rightIndexes = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            leftIndexes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            rightIndexes[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int current = (rightIndexes[i] - leftIndexes[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, current);
        }
        return maxArea;
    }
}
