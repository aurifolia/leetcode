import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No39_组合总和 {
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     *
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * @param args
     */
    public static void main(String[] args) {
        Solution391 solution = new Solution391();
        System.out.println(solution.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(solution.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(solution.combinationSum(new int[]{2}, 1));
        System.out.println(solution.combinationSum(new int[]{36,21,2,3,23,24,38,22,11,14,15,25,32,19,35,26,31,13,34,29,12,37,17,20,39,30,40,28,27,33}, 35));
    }
}

class Solution391 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Arrays.sort(candidates);
        for (int i = 1; i <= target / candidates[0]; i++) {
            find(candidates, new ArrayList<>(), result, visited, i, target);
        }
        return result;
    }

    public void find(int[] candidates, List<Integer> current, List<List<Integer>> result, Set<String> visited, int times, int remind) {
        if (times == 0 || remind < 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int newRemind = remind - candidates[i];
            if (newRemind > 0) {
                current.add(candidates[i]);
                find(candidates, current, result, visited, times - 1, newRemind);
                current.remove(current.size() - 1);
            }
            else if (newRemind < 0) {
                return;
            }
            else {
                current.add(candidates[i]);
                int[] array = current.stream().mapToInt(Integer::intValue).toArray();
                current.remove(current.size() - 1);
                Arrays.sort(array);
                List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
                String join = collect.stream().map(String::valueOf).collect(Collectors.joining(","));
                if (!visited.contains(join)) {
                    visited.add(join);
                    result.add(collect);
                }
            }
        }
    }
}
