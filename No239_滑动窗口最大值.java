import java.util.*;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No239_滑动窗口最大值 {
    public static void main(String[] args) {
        Solution239 solution239 = new Solution239();
        int[] ints = solution239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ints));
    }
}


class Solution239 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        for (int i = 0; i <= length - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                if (max < nums[i + j]) {
                    max = nums[i + j];
                }
            }
            result[i] = max;
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>(k);
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}