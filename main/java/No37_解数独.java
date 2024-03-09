/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No37_解数独 {
    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     *
     * 数独的解法需 遵循如下规则：
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * @param args
     */
    public static void main(String[] args) {
        Solution371 solution = new Solution371();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solution.solveSudoku(board);
        System.out.println();
    }
}

class Solution371 {
    public void solveSudoku(char[][] board) {
        int dim = board.length;
        int remind = 0;
        boolean[][][] part = new boolean[dim / 3][ dim / 3][10];
        for (int i = 0; i < dim; i += 3) {
            for (int j = 0; j < dim; j += 3) {
                int row = i / 3;
                int col = j / 3;
                for (int k = 0; k < (dim / 3); k++) {
                    for (int l = 0; l < (dim / 3); l++) {
                        char item = board[i + k][j + l];
                        if (item != '.') {
                            part[row][col][item - '0'] = true;
                        }
                        else {
                            remind++;
                        }
                    }
                }
            }
        }
        find(board, part, 0, 0, remind);
    }

    public boolean find(char[][] board, boolean[][][] part, int row, int col, int remind) {
        if (remind == 0) {
            return true;
        }
        if (col == board.length) {
            col = 0;
            row++;
        }
        if (row == board.length) {
            return true;
        }
        while (row < board.length && board[row][col] != '.') {
            while (col < board.length && board[row][col] != '.') {
                col++;
            }
            if (col == board.length) {
                col = 0;
            }
            if (board[row][col] == '.') {
                break;
            }
            row++;
        }
        if (row == board.length) {
            return true;
        }
        boolean[] set = new boolean[10];
        for (int i = 0; i < board.length; i++) {
            char item = board[row][i];
            if (item != '.') {
                set[item - '0'] = true;
            }
            item = board[i][col];
            if (item != '.') {
                set[item - '0'] = true;
            }
        }
        boolean[] partSet = part[row / 3][col / 3];
        for (int i = 1; i <= board.length; i++) {
            if (set[i] || partSet[i]) {
                continue;
            }
            partSet[i] = true;
            board[row][col] = (char) ('0' + i);
            if (find(board, part, row, col + 1, remind - 1)) {
                return true;
            }
            board[row][col] = '.';
            partSet[i] = false;
        }
        return false;
    }
}
