import java.util.HashMap;
import java.util.Map;

/**
 * @author vneli
 * @since 1.0
 */
public class No96_不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution962 solution = new Solution962();
        System.out.println(solution.numTrees(18));
    }
}

class Solution961 {
    public int numTrees(int n) {
        return generate(1, n, new HashMap<>());
    }

    public int generate(int start, int end, Map<Integer, Integer> mem) {
        int key = (start << 16) | end;
        Integer record = mem.get(key);
        if (record != null) {
            return record;
        }
        if (start > end) {
            mem.put(record, 1);
            return 1;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            int left = generate(start, i - 1, mem);
            int right = generate(i + 1, end, mem);
            num += left * right;
        }
        mem.put(record, num);
        return num;
    }
}

class Solution962 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}