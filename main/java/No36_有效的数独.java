/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No36_有效的数独 {
    public static void main(String[] args) {
        Solution361 solution = new Solution361();
        char[][] board = new char[][]{{'.','.','.','.','.','.','5','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'9','3','.','.','2','.','4','.','.'},{'.','.','7','.','.','.','3','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','3','4','.','.','.','.'},{'.','.','.','.','.','3','.','.','.'},{'.','.','.','.','.','5','2','.','.'}};
        System.out.println(solution.isValidSudoku(board));
    }
}

class Solution361 {
    public boolean isValidSudoku(char[][] board) {
        int length = 9;
        for (int i = 0; i < length; i++) {
            int[] rowSet = new int[length + 1];
            int[] colSet = new int[length + 1];
            for (int j = 0; j < length; j++) {
                char colChar = board[i][j];
                if (colChar != '.') {
                    colSet[colChar - '0']++;
                }
                char rowChar = board[j][i];
                if (rowChar != '.') {
                    rowSet[rowChar - '0']++;
                }
            }
            if (!judgeSet(rowSet) || !judgeSet(colSet)) {
                return false;
            }
        }
        for (int i = 0; i < length; i += 3) {
            for (int j = 0; j < length; j += 3) {
                int[] set = new int[length + 1];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char item = board[k][l];
                        if (item != '.') {
                            set[item - '0']++;
                        }
                    }
                }
                if (!judgeSet(set)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean judgeSet(int[] set) {
        for (int i = set.length - 1; i >= 0; i--) {
            if (set[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
