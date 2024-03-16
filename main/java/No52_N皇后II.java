import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vneli
 * @since 1.0
 */
public class No52_N皇后II {
    public static void main(String[] args) {
        Solution521 solution = new Solution521();
        System.out.println(solution.totalNQueens(9));
    }
}

class Solution521 {
    public int totalNQueens(int n) {
        return solveNQueens(n).size();
    }

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
