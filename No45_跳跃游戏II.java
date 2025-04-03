/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No45_跳跃游戏II {
    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{3,2,1}));
    }
}

class Solution45 {
    public int jump1(int[] nums) {
        int step = 0;
        for (int i = nums.length - 1; i > 0; ) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    i = j;
                    step++;
                    break;
                }
            }
        }
        return step;
    }

    public int jump(int[] nums) {
        int loc = 0;
        int step = 0;
        while (loc < nums.length - 1) {
            step++;
            if (loc + nums[loc] >= nums.length - 1) {
                break;
            }
            int nextLoc = loc + 1;
            int max = 0;
            for (int i = 1; i <= nums[loc]; i++) {
                int candidate = loc + i;
                if (max < nums[candidate] + i) {
                    max = nums[candidate] + i;
                    nextLoc = candidate;
                }
            }
            loc = nextLoc;
        }
        return step;
    }
}
