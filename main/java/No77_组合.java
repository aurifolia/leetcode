import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No77_组合 {
    public static void main(String[] args) {
        Solution771 solution = new Solution771();
        System.out.println(solution.combine(4, 2));
    }
}

class Solution771 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(n, result, new ArrayList<>(k), k, 1);
        return result;
    }

    public void backtrace(int n, List<List<Integer>> result, List<Integer> current, int remind, int start) {
        if (remind == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrace(n, result, current, remind - 1, i + 1);
            current.remove(current.size() - 1);
        }
    }
}
