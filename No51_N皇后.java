import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No51_N皇后 {
    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        System.out.println(solution51.solveNQueens(4));
    }
}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(board, 0, result);
        return result;
    }

    private void dfs(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(Arrays.stream(board).map(String::new).collect(Collectors.toList()));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (judge(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, row + 1, result);
                board[row][i] = '.';
            }
        }
    }

    private boolean judge(char[][] board, int row, int col) {
        if (board[row][col] == 'Q') {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q') {
                return false;
            }
        }
        // 对角线
        for (int i = 1; i < board.length; i++) {
            if (row - i >= 0 && col - i >= 0 && board[row - i][col - i] == 'Q') {
                return false;
            }
            if (row - i >= 0 && col + i < board.length && board[row - i][col + i] == 'Q') {
                return false;
            }
            if (row + i < board.length && col - i >= 0 && board[row + i][col - i] == 'Q') {
                return false;
            }
            if (row + i < board.length && col + i < board.length && board[row + i][col + i] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
