package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No54_螺旋矩阵 {
    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        System.out.println(solution54.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
        System.out.println(solution54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}

class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sm = 0;
        int sn = 0;
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();
        while (sm <= m && sn <= n) {
            // right
            for (int i = sn; i <= n; i++) {
                result.add(matrix[sm][i]);
            }
            sm++;
            if (sm > m) {
                break;
            }
            // down
            for (int i = sm; i <= m; i++) {
                result.add(matrix[i][n]);
            }
            n--;
            if (sn > n) {
                break;
            }
            // left
            for (int i = n; i >= sn; i--) {
                result.add(matrix[m][i]);
            }
            m--;
            if (sm > m) {
                break;
            }
            // up
            for (int i = m; i >= sm; i--) {
                result.add(matrix[i][sn]);
            }
            sn++;
        }
        return result;
    }
}
