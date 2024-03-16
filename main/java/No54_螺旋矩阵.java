import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No54_螺旋矩阵 {
    public static void main(String[] args) {
        Solution541 solution = new Solution541();
        System.out.println(solution.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}

class Solution541 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = -1, bottom = m, left = -1, right = n;
        List<Integer> result = new ArrayList<>(m * m);
        for (int i = 0; i < bottom; i++) {
            // 向右
            top++;
            for (int j = i; j < right; j++) {
                result.add(matrix[i][j]);
            }
            // 向下
            right--;
            if (left < right) {
                for (int j = i + 1; j < bottom; j++) {
                    result.add(matrix[j][right]);
                }
            }
            // 向左
            bottom--;
            if (top < bottom) {
                for (int j = right - 1; j > left; j--) {
                    result.add(matrix[bottom][j]);
                }
            }
            // 向上
            left++;
            if (left < right) {
                for (int j = bottom - 1; j > top; j--) {
                    result.add(matrix[j][left]);
                }
            }
        }
        return result;
    }
}
