package round1;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * <p>
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No128_最长连续序列 {
    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int i = solution128.longestConsecutive(new int[]{1,0,1,2});
        System.out.println(i);
    }
}

class Solution128 {
    public int longestConsecutive1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>(length);
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            int curLength = 1;
            // 向前
            int curNum = num - 1;
            while (set.contains(curNum)) {
                set.remove(curNum);
                curNum--;
                curLength++;
            }
            // 向后
            curNum = num + 1;
            while (set.contains(curNum)) {
                set.remove(curNum);
                curNum++;
                curLength++;
            }
            if (curLength > maxLength) {
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public int longestConsecutive(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>(length);
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curLength = 0;
                while (set.contains(num)) {
                    curLength++;
                    num++;
                }
                if (maxLength < curLength) {
                    maxLength = curLength;
                }
            }
        }
        return maxLength;
    }
}
