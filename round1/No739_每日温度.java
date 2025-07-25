package round1;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No739_每日温度 {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        System.out.println(Arrays.toString(solution739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

class Solution739 {
    public int[] dailyTemperatures1(int[] temperatures) {
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        int[] data = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!numStack.isEmpty() && numStack.peek() < temperatures[i]) {
                numStack.pop();
                int index = indexStack.pop();
                data[index] = i - index;
            }
            numStack.push(temperatures[i]);
            indexStack.push(i);
        }
        return data;
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> indexStack = new LinkedList<>();
        int[] data = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.isEmpty() && temperatures[indexStack.peek()] < temperatures[i]) {
                int index = indexStack.pop();
                data[index] = i - index;
            }
            indexStack.push(i);
        }
        return data;
    }
}
