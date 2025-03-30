/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No74_搜索二维矩阵 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }
}

class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length - 1;
        int curM = 0;
        while (curM < m && n >= 0) {
            if (matrix[curM][n] == target) {
                return true;
            }
            else if (matrix[curM][n] > target) {
                n--;
            }
            else {
                curM++;
            }
        }
        return false;
    }
}
