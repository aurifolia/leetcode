package round1;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No55_跳跃游戏 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        System.out.println(solution55.canJump(new int[]{2, 3, 1, 1, 4}));
    }
}

class Solution55 {
    public boolean canJump1(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        queue.push(0);
        int max = 0;
        while (!queue.isEmpty()) {
            Set<Integer> set = new LinkedHashSet<>();
            for (int i = 0, size = queue.size(); i < size; i++) {
                Integer pop = queue.pop();
                set.remove(pop);
                max = Math.max(max, pop + nums[pop]);
                if (max >= nums.length - 1) {
                    return true;
                }
                for (int j = 1; j <= nums[pop]; j++) {
                    set.add(pop + j);
                }
            }
            queue.addAll(set);
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}
