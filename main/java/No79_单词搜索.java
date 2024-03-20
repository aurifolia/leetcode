/**
 * @author vneli
 * @since 1.0
 */
public class No79_单词搜索 {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     *
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * @param args
     */
    public static void main(String[] args) {
        Solution791 solution = new Solution791();
        System.out.println(solution.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}

class Solution791 {
    public boolean exist(char[][] board, String word) {
        char c = word.charAt(0);
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == c && backtrace(board, visited, m, n, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrace(char[][] board, boolean[][] visited, int m, int n, int row, int col, int loc, String word) {
        if (loc == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= m || col >= n || visited[row][col] || board[row][col] != word.charAt(loc)) {
            return false;
        }
        visited[row][col] = true;
        boolean top = backtrace(board, visited, m, n, row - 1, col, loc + 1, word);
        boolean bottom = backtrace(board, visited, m, n, row + 1, col, loc + 1, word);
        boolean left = backtrace(board, visited, m, n, row, col - 1, loc + 1, word);
        boolean right = backtrace(board, visited, m, n, row, col + 1, loc + 1, word);
        visited[row][col] = false;
        return top || bottom || left || right;
    }
}
