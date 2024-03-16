import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vneli
 * @since 1.0
 */
public class No51_N皇后 {
    public static void main(String[] args) {
        Solution512 solution = new Solution512();
        System.out.println(solution.solveNQueens(4));
        System.out.println(solution.solveNQueens(9));
    }
}

class Solution511 {
    public List<List<String>> solveNQueens(int n) {
        int[][] mat = new int[n][n + 1];
        List<List<String>> result = new ArrayList<>();
        dfs(mat, n, result, new HashSet<>());
        return result;
    }

    public void dfs(int[][] mat, int remind, List<List<String>> result, Set<String> set) {
        String key = getKey(mat, remind);
        if (set.contains(key)) {
            return;
        }
        set.add(key);
        int n = mat.length;
        if (remind == 0) {
            List<String> current = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    stringBuilder.append(mat[i][j] <= 0 ? '.' : 'Q');
                }
                current.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
            result.add(current);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (mat[i][n] > 0) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    mark(mat, i, j, 1);
                    mat[i][j] = 1;
                    mat[i][n]++;
                    dfs(mat, remind - 1, result, set);
                    mark(mat, i, j, -1);
                    mat[i][j] = 0;
                    mat[i][n]--;
                }
            }
        }
    }

    public String getKey(int[][] mat, int remind) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(remind).append("#");
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            int value = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    value += 1;
                }
                value <<= 1;
            }
            stringBuilder.append(value).append(",");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void mark(int[][] mat, int i, int j, int increment) {
        int n = mat.length;
        for (int k = 0; k < n; k++) {
            if (mat[i][k] <= 0) {
                mat[i][k] -= increment;
            }
            if (mat[k][j] <= 0) {
                mat[k][j] -= increment;
            }
            if (i - k >= 0 && j - k >= 0 && mat[i - k][j - k] <= 0) {
                mat[i - k][j - k] -= increment;
            }
            if (i - k >= 0 && j + k < n && mat[i - k][j + k] <= 0) {
                mat[i - k][j + k] -= increment;
            }
            if (i + k < n && j - k >= 0 && mat[i + k][j - k] <= 0) {
                mat[i + k][j - k] -= increment;
            }
            if (i + k < n && j + k < n && mat[i + k][j + k] <= 0) {
                mat[i + k][j + k] -= increment;
            }
        }
    }

    public boolean judge(int[][] mat, int i, int j) {
        int n = mat.length;
        for (int k = 0; k < n; k++) {
            if (mat[i][k] != 0 || mat[k][j] != 0
                    || i - k >= 0 && j - k >= 0 && mat[i - k][j - k] != 0
                    || i - k >= 0 && j + k < n && mat[i - k][j + k] != 0
                    || i + k < n && j - k >= 0 && mat[i + k][j - k] != 0
                    || i + k < n && j + k < n && mat[i + k][j + k] != 0) {
                return false;
            }
        }
        return true;
    }
}

class Solution512 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), n, n, new boolean[n << 1], new boolean[n << 1], new boolean[n << 1]);
        return result;
    }

    public void backtrace(List<List<String>> result, List<char[]> current, int n, int remind, boolean[] visitedCol, boolean[] visitedBias1, boolean[] visitedBias2) {
        if (remind == 0) {
            result.add(current.stream().map(String::new).collect(Collectors.toList()));
        }
        char[] row = new char[n];
        for (int i = 0; i < n; i++) {
            row[i] = '.';
        }
        for (int i = 0; i < n; i++) {
            if (visitedCol[i]) {
                continue;
            }
            int bias1 = i - remind + n;
            if (visitedBias1[bias1]) {
                continue;
            }
            int bias2 = i + remind;
            if (visitedBias2[bias2]) {
                continue;
            }

            visitedCol[i] = true;
            visitedBias1[bias1] = true;
            visitedBias2[bias2] = true;
            row[i] = 'Q';
            current.add(row);
            backtrace(result, current, n, remind - 1, visitedCol, visitedBias1, visitedBias2);
            current.remove(current.size() - 1);
            row[i] = '.';
            visitedCol[i] = false;
            visitedBias1[bias1] = false;
            visitedBias2[bias2] = false;
        }
    }
}
