/**
 * @author vneli
 * @since 1.0
 */
public class No45_跳跃游戏II {
    public static void main(String[] args) {
        Solution452 solution = new Solution452();
        System.out.println(solution.jump(new int[]{2,3,1,1,4}));
    }
}

class Solution451 {
    public int jump(int[] nums) {
        int length = nums.length;
        int step = 0, loc = 0;
        while (loc + 1 < length) {
            int maxLoc = loc + nums[loc], maxNext = loc + nums[loc];
            if (maxNext + 1 < length) {
                for (int i = 1; i <= nums[loc]; i++) {
                    int nextLoc = loc + i;
                    if (nextLoc >= length) {
                        break;
                    }
                    int candidate = nextLoc + nums[nextLoc];
                    if (candidate > maxLoc) {
                        maxLoc = candidate;
                        maxNext = nextLoc;
                    }
                }
            }
            step++;
            if (maxNext + 1 >= length) {
                break;
            }
            loc = maxNext;
        }
        return step;
    }
}

class Solution452 {
    public int jump(int[] nums) {
        int step = 0, max = 0, end = 0;
        int length = nums.length - 1;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == end) {
                step++;
                end = max;
            }
        }
        return step;
    }
}
