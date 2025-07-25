package round1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No121_买卖股票的最佳时机 {
    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        System.out.println(solution121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

class Solution121 {
    public int maxProfit1(int[] prices) {
        Deque<Integer> stack = new LinkedList<>();
        int[] rightMax = new int[prices.length];
        for (int i = prices.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek() < prices[i]) {
                stack.push(prices[i]);
            }
            rightMax[i] = stack.peek();
        }
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, rightMax[i + 1] - prices[i]);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
