import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vneli
 * @since 1.0
 */
public class No47_全排列II {
    public static void main(String[] args) {
        Solution471 solution = new Solution471();
        System.out.println(solution.permuteUnique(new int[]{1,1,2}));
    }
}

class Solution471 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, result, new ArrayList<>(), new HashSet<>());
        return result;
    }

    public void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> current, Set<String> set) {
        String key = current.size() + "#" + current.stream().map(String::valueOf).collect(Collectors.joining(","));
        if (set.contains(key)) {
            return;
        }
        set.add(key);
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            List<Integer> copy = new ArrayList<>(current);
            copy.add(nums[i]);
            dfs(nums, visited, result, copy, set);
            visited[i] = false;
        }
    }
}
