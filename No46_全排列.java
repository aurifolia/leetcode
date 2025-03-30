import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No46_全排列 {
    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        System.out.println(solution46.permute(new int[]{1, 2, 3}));
    }
}

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> path, List<Integer> nums) {
        if (nums.isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0, length = nums.size(); i < length; i++) {
            Integer elem = nums.get(i);
            path.add(elem);
            nums.remove(i);
            backtrack(res, path, nums);
            path.remove(path.size() - 1);
            nums.add(i, elem);
        }
    }
}
