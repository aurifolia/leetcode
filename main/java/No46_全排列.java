import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No46_全排列 {
    public static void main(String[] args) {
        Solution461 solution = new Solution461();
        System.out.println(solution.permute(new int[]{1,2,3}));
        System.out.println(solution.permute(new int[]{0,1}));
        System.out.println(solution.permute(new int[]{1}));
    }
}

class Solution461 {
    public List<List<Integer>> permute(int[] nums) {
        int length = 1;
        for (int i = 2; i < nums.length; i++) {
            length *= i;
        }
        List<List<Integer>> result = new ArrayList<>(length);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited, result, new ArrayList<>());
        return result;
    }

    public void dfs(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(current);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            ArrayList<Integer> copy = new ArrayList<>(current);
            copy.add(nums[i]);
            dfs(nums, visited, result, copy);
            visited[i] = false;
        }
    }
}
