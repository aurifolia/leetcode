import java.util.*;

/**
 * @author vneli
 * @since 1.0
 */
public class No56_合并区间 {
    public static void main(String[] args) {
        Solution561 solution = new Solution561();
        int[][] merge = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }
}

class Solution561 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int loc = 1, left = intervals[0][0], right = intervals[0][1];
        List<int[]> result = new ArrayList<>();
        while (loc < intervals.length) {
            if (intervals[loc][0] <= right) {
                if (intervals[loc][1] > right) {
                    right = intervals[loc][1];
                }
            }
            else {
                result.add(new int[]{left, right});
                left = intervals[loc][0];
                right = intervals[loc][1];
            }
            loc++;
        }
        result.add(new int[]{left, right});
        return result.toArray(int[][]::new);
    }
}
