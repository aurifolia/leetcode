import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author vneli
 * @since 1.0
 */
public class No90_子集II {
    public static void main(String[] args) {
        Solution901 solution = new Solution901();
        System.out.println(solution.subsetsWithDup(new int[]{1,2,2}));
    }
}

class Solution901 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), nums, new boolean[nums.length], new HashSet<>());
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] visited, Set<String> set) {
        String key = current.stream().sorted().map(String::valueOf).collect(Collectors.joining(","));
        if (set.contains(key)) {
            return;
        }
        set.add(key);
        result.add(new ArrayList<>(current));
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            backtrace(result, current, nums, visited, set);
            current.remove(Integer.valueOf(nums[i]));
            visited[i] = false;
        }
    }
}
