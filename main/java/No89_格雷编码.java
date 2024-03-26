import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author vneli
 * @since 1.0
 */
public class No89_格雷编码 {
    /**
     * n 位格雷码序列 是一个由 2n 个整数组成的序列，其中：
     * 每个整数都在范围 [0, 2n - 1] 内（含 0 和 2n - 1）
     * 第一个整数是 0
     * 一个整数在序列中出现 不超过一次
     * 每对 相邻 整数的二进制表示 恰好一位不同 ，且
     * 第一个 和 最后一个 整数的二进制表示 恰好一位不同
     * 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。
     * @param args
     */
    public static void main(String[] args) {
        Solution892 solution = new Solution892();
        System.out.println(solution.grayCode(2));
    }
}

class Solution891 {
    public List<Integer> grayCode(int n) {
        int totalNum = (int) Math.pow(2, n);
        Set<Integer> set = new HashSet<>(totalNum);
        List<Integer> result = new ArrayList<>(totalNum);
        set.add(0);
        result.add(0);
        backtrace(set, result, new int[n], totalNum);
        return new ArrayList<>(result);
    }

    public void backtrace(Set<Integer> set, List<Integer> result, int[] visited, int totalNum) {
        if (result.size() == totalNum) {
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                int data = array2Int(visited);
                if (!set.contains(data)) {
                    boolean shouldContinue = true;
                    if (Integer.bitCount(result.get(result.size() - 1) ^ data) != 1) {
                        shouldContinue = false;
                    }
                    if (shouldContinue && result.size() == totalNum - 1 && Integer.bitCount(result.get(0) ^ data) != 1) {
                        shouldContinue = false;
                    }
                    if (shouldContinue) {
                        set.add(data);
                        result.add(data);
                        backtrace(set, result, visited, totalNum);
                        if (result.size() == totalNum) {
                            return;
                        }
                        result.remove(Integer.valueOf(data));
                        set.remove(data);
                    }
                }
                visited[i] = 0;
            }
            else {
                visited[i] = 0;
                int data = array2Int(visited);
                if (!set.contains(data)) {
                    boolean shouldContinue = true;
                    if (Integer.bitCount(result.get(result.size() - 1) ^ data) != 1) {
                        shouldContinue = false;
                    }
                    if (shouldContinue && result.size() == totalNum - 1 && Integer.bitCount(result.get(0) ^ data) != 1) {
                        shouldContinue = false;
                    }
                    if (shouldContinue) {
                        set.add(data);
                        result.add(data);
                        backtrace(set, result, visited, totalNum);
                        if (result.size() == totalNum) {
                            return;
                        }
                        result.remove(Integer.valueOf(data));
                        set.remove(data);
                    }
                }
                visited[i] = 1;
            }
        }
    }

    public int array2Int(int[] array) {
        int n = array.length;
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            num |= array[i] << (n - i - 1);
        }
        return num;
    }
}

class Solution892 {
    public List<Integer> grayCode(int n) {
        int total = 1 << n;
        List<Integer> result = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
}