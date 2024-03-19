import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author vneli
 * @since 1.0
 */
public class No60_排列序列 {
    /**
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     *
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     *
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * @param args
     */
    public static void main(String[] args) {
        Solution602 solution = new Solution602();
        System.out.println(solution.getPermutation(3, 3));
    }
}

class Solution601 {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        return backstrace(nums, new boolean[n], new AtomicInteger(k), "", n);
    }

    public String backstrace(int[] nums, boolean[] visited, AtomicInteger k, String current, int remind) {
        if (remind == 0) {
            k.getAndDecrement();
            return current;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            String data = backstrace(nums, visited, k, current + nums[i], remind - 1);
            if (k.get() == 0) {
                return data;
            }
            visited[i] = false;
        }
        return null;
    }
}

class Solution602 {
    public String getPermutation(int n, int k) {
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) {

            factor[i] = factor[i - 1] * i;
        }
        k--;
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int index = k / factor[n - i] + 1;
            for (int j = 1, loc = 0; j <= n; j++) {
                if (!visited[j]) {
                    loc++;
                }
                if (loc == index) {
                    stringBuilder.append(j);
                    visited[j] = true;
                    break;
                }
            }
            k %= factor[n - i];
        }
        return stringBuilder.toString();
    }
}
