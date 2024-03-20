import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No78_子集 {
    public static void main(String[] args) {
        Solution781 solution = new Solution781();
        System.out.println(solution.subsets(new int[]{1,2,3}));
        System.out.println(solution.subsets(new int[]{0}));
    }
}

class Solution781 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(nums, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrace(int[] nums, List<List<Integer>> result, List<Integer> current,int start) {
        int n = nums.length;
        if (start == n) {
            result.add(new ArrayList<>(current));
            return;
        }
        backtrace(nums, result, current, start + 1);
        current.add(nums[start]);
        backtrace(nums, result, current, start + 1);
        current.remove(current.size() - 1);
    }
}
