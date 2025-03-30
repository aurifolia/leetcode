/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No79_单词搜索 {
    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
    }
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordChars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, wordChars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] wordChars, int index) {
        if (index == wordChars.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != wordChars[index] || board[i][j] == '\0') {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '\0';
        boolean result = dfs(board, i - 1, j, wordChars, index + 1)
                || dfs(board, i + 1, j, wordChars, index + 1)
                || dfs(board, i, j - 1, wordChars, index + 1)
                || dfs(board, i, j + 1, wordChars, index + 1);
        board[i][j] = temp;
        return result;
    }
}
