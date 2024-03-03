/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No6_Z字形变换 {
    /**
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     *
     *
     * 示例 1：
     *
     * 输入：s = "PAYPALISHIRING", numRows = 3
     * 输出："PAHNAPLSIIGYIR"
     * 示例 2：
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * 示例 3：
     *
     * 输入：s = "A", numRows = 1
     * 输出："A"
     * @param args
     */
    public static void main(String[] args) {
        Solution62 solution = new Solution62();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}

/**
 * 矩阵记录法
 */
class Solution61 {
    public String convert(String s, int numRows) {
        int length = s.length();
        char[][] matrix = new char[numRows][length];
        boolean down = true;
        int row = 0, col = 0;
        for (int i = 0; i < length; i++) {
            matrix[row][col] = s.charAt(i);
            if (down) {
                row++;
                if (row % numRows == 0) {
                    down = false;
                    row = Math.max(numRows - 2, 0);
                    col++;
                }
            }
            else {
                if (row % numRows == 0) {
                    down = true;
                    row = Math.min(1, numRows - 1);
                    if (numRows == 1) {
                        col++;
                    }
                }
                else {
                    col++;
                    row = Math.max(row - 1, 0);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != '\0') {
                    builder.append(matrix[i][j]);
                }
            }
        }
        return builder.toString();
    }
}

/**
 * 矩阵记录
 */
class Solution62 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length();
        char[][] matrix = new char[numRows][s.length()];
        int row = 0, col = 0;
        // 周期
        int t = numRows * 2 - 2;
        for (int i = 0; i < length; i++) {
            matrix[row][col] = s.charAt(i);
            if (i % t < numRows - 1) {
                row++;
            }
            else {
                row--;
                col++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != '\0') {
                    builder.append(matrix[i][j]);
                }
            }
        }
        return builder.toString();
    }
}