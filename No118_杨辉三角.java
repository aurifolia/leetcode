import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No118_杨辉三角 {
}

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows >= 1) {
            result.add(Collections.singletonList(1));
        }
        if (numRows >= 2) {
            result.add(Arrays.asList(1, 1));
        }
        for (int i = 3; i <= numRows; i++) {
            List<Integer> current = new ArrayList<>();
            current.add(1);
            List<Integer> integers = result.get(result.size() - 1);
            for (int j = 0; j < integers.size() - 1; j++) {
                current.add(integers.get(j) + integers.get(j + 1));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
