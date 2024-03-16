/**
 * @author vneli
 * @since 1.0
 */
public class No48_旋转图像 {
    public static void main(String[] args) {
        Solution481 solution = new Solution481();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(matrix);
        System.out.println();
    }
}

class Solution481 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < (m + 1) / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][i];
                matrix[m - j - 1][i] = matrix[m - i - 1][m - j - 1];
                matrix[m - i - 1][m - j - 1] = matrix[j][m - i - 1];
                matrix[j][m - i - 1] = temp;
            }
        }
    }
}
