/**
 * @author vneli
 * @since 1.0
 */
public class No74_搜索二维矩阵 {
    /**
     * 给你一个满足下述两条属性的 m x n 整数矩阵：
     *
     * 每行中的整数从左到右按非严格递增顺序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
     * @param args
     */
    public static void main(String[] args) {
        Solution741 solution = new Solution741();
        System.out.println(solution.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
    }
}

class Solution741 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1;
        while (top <= bottom) {
            int mid = (top + bottom) >> 1;
            if (matrix[mid][0] <= target && matrix[mid][n - 1] >= target) {
                top = mid;
                break;
            }
            else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            }
            else {
                top = mid + 1;
            }
        }
        if (top > bottom || matrix[top][0] > target || matrix[top][n - 1] < target) {
            return false;
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (matrix[top][mid] < target) {
                left = mid + 1;
            }
            else if (matrix[top][mid] > target) {
                right = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
