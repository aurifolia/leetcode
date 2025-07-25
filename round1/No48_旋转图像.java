package round1;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No48_旋转图像 {
    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution48.rotate(matrix);
    }
}

class Solution48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for (int i = 0, j = m - 1; i < j; i++, j--) {
            for (int k = 0; k < m; k++) {
                int temp = matrix[i][k];
                matrix[i][k] = matrix[j][k];
                matrix[j][k] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
