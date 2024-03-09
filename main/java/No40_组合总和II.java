import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author VNElinpe
 * @since 1.0
 **/
public class No40_组合总和II {
    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     *
     * 注意：解集不能包含重复的组合。
     * @param args
     */
    public static void main(String[] args) {
        Solution401 solution = new Solution401();
//        System.out.println(solution.combinationSum2(new int[]{1}, 2));
//        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
//        System.out.println(solution.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 27));
//        System.out.println(solution.combinationSum2(new int[]{23,32,22,19,29,15,11,26,28,20,34,5,34,7,28,33,30,30,16,33,8,15,28,26,17,10,25,12,6,17,30,16,6,10,23,22,20,29,14,5,6,5,5,6,29,20,34,24,16,7,22,11,17,7,33,21,13,15,29,6,19,16,10,21,21,28,8,6}, 27));
//        System.out.println(solution.combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30));
        System.out.println(solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}

class Solution401 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];

        int minSize = 1, sum = 0;
        for (int i = candidates.length - 1; i >= 0; i--) {
            sum += candidates[i];
            if (sum >= target) {
                break;
            }
            minSize++;
        }

        HashSet<String> set1 = new HashSet<>();
        for (int i = minSize; i <= target / candidates[0]; i++) {
            find(candidates, visited, set, set1, result, new ArrayList<>(), i, target, 0);
        }
        return result;
    }

    public void find(int[] candidates, boolean[] visited, Set<String> set, Set<String> set1, List<List<Integer>> result, List<Integer> current, int times, int remind, int start) {
        if (times == 0 || remind < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (visited[i]) {
                continue;
            }
            current.add(candidates[i]);
            int[] array = current.stream().mapToInt(Integer::intValue).toArray();
            current.remove(current.size() - 1);
            Arrays.sort(array);
            String collect = Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(","));
            String pattern = String.format("%s-%s", times, collect);
            if (set.contains(pattern) || set1.contains(collect)) {
                continue;
            }
            set.add(pattern);

            int newRemind = remind - candidates[i];
            if (newRemind > 0) {
                visited[i] = true;
                current.add(candidates[i]);
                find(candidates, visited, set, set1, result, current, times - 1, newRemind, i + 1);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
            else if (newRemind < 0) {
                return;
            }
            else {
                set1.add(collect);
                result.add(Arrays.stream(array).boxed().collect(Collectors.toList()));
            }
        }
    }
}
