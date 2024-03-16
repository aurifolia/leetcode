/**
 * @author vneli
 * @since 1.0
 */
public class No59_螺旋矩阵II {
    /**
     * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
     * @param args
     */
    public static void main(String[] args) {
        Solution591 solution = new Solution591();
        int[][] ints = solution.generateMatrix(4);
        System.out.println();
    }
}

class Solution591 {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int left = -1, right = n, top = 0, bottom = n, num = 1;
        for (int i = 0; i < bottom; i++) {
            // 向右
            for (int j = left + 1; j < right; j++) {
                nums[i][j] = num++;
            }
            // 向下
            right--;
            if (left < right) {
                for (int j = i + 1; j < bottom; j++) {
                    nums[j][right] = num++;
                }
            }
            // 向左
            bottom--;
            if (top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    nums[bottom][j] = num++;
                }
            }
            // 向上
            left++;
            if (left < right) {
                for (int j = bottom - 1; j > top; j--) {
                    nums[j][left] = num++;
                }
            }
            top++;
        }
        return nums;
    }
}
