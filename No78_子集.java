import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No78_子集 {
    public static void main(String[] args) {

    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backtrace(result, new ArrayList<>(), new HashSet<>(), nums, new int[nums.length]);
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> current, Set<String> parsedSet, int[] nums, int[] visited) {
        for (int i = 0, length = nums.length; i < length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            current.add(nums[i]);
            Integer[] array = current.toArray(Integer[]::new);
            Arrays.sort(array);
            String parsed = Arrays.stream(array).map(String::valueOf).collect(Collectors.joining(","));
            if (!parsedSet.contains(parsed)) {
                parsedSet.add(parsed);
                result.add(new ArrayList<>(current));
                visited[i] = 1;
                backtrace(result, current, parsedSet, nums, visited);
                visited[i] = 0;
            }
            current.remove(current.size() - 1);
        }
    }
}
