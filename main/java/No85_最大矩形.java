import java.util.Stack;

/**
 * @author vneli
 * @since 1.0
 */
public class No85_最大矩形 {
    public static void main(String[] args) {
        Solution852 solution = new Solution852();
        System.out.println(solution.maximalRectangle(new char[][]{{'1'}}));
        System.out.println(solution.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}

class Solution851 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                int base = left[i][j];
                for (int k = i; k >= 0; k--) {
                    if (left[k][j] == 0) {
                        break;
                    }
                    base = Math.min(base, left[k][j]);
                    int candidate = base * (i - k + 1);
                    if (max < candidate) {
                        max = candidate;
                    }
                }
            }
        }
        return max;
    }
}

class Solution852 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            int[] top = new int[m];
            for (int j = 0; j < m; j++) {
                while (!stack.isEmpty() && left[stack.peek()][i] >= left[j][i]) {
                    stack.pop();
                }
                top[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack = new Stack<>();
            int[] bottom = new int[m];
            for (int j = m - 1; j >= 0; j--) {
                while (!stack.isEmpty() && left[stack.peek()][i] >= left[j][i]) {
                    stack.pop();
                }
                bottom[j] = stack.isEmpty() ? m : stack.peek();
                stack.push(j);
            }
            for (int j = 0; j < m; j++) {
                if (left[j][i] != 0) {
                    int candidate = left[j][i] * (bottom[j] - top[j] - 1);
                    if (max < candidate) {
                        max = candidate;
                    }
                }
            }
        }
        return max;
    }
}