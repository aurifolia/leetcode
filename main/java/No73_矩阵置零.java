import java.util.HashSet;
import java.util.Set;

/**
 * @author vneli
 * @since 1.0
 */
public class No73_矩阵置零 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution731 solution = new Solution731();
        int[][] matrix = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        solution.setZeroes(matrix);
        System.out.println();
    }
}

class Solution731 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < n; i++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
