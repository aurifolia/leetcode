package round1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No39_组合总和 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrace(candidates, 0, target, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    private void backtrace(int[] candidates, int current, int target, List<List<Integer>> result, List<Integer> currentPath, Set<String> visited) {
        for (int i = 0, length = candidates.length; i < length; i++) {
            currentPath.add(candidates[i]);
            List<Integer> paths = new ArrayList<>(currentPath);
            Collections.sort(paths);
            int nextCurrent = current + candidates[i];
            if (visited.add(paths.stream().map(String::valueOf).collect(Collectors.joining(","))) && nextCurrent <= target) {
                if (nextCurrent == target) {
                    result.add(new ArrayList<>(currentPath));
                }
                backtrace(candidates, nextCurrent, target, result, currentPath, visited);
            }
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, target, 0, result, new ArrayList<>());
        return result;
    }

    private void dfs(int[] candidates, int current, int target, int index, List<List<Integer>> result, List<Integer> currentPath) {
        if (current == target) {
            result.add(new ArrayList<>(currentPath));
            return;
        }
        if (current > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            currentPath.add(candidates[i]);
            dfs(candidates, current + candidates[i], target, i, result, currentPath);
            currentPath.remove(currentPath.size() - 1);
        }
    }
}
