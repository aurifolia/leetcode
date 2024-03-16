import java.util.ArrayList;
import java.util.List;

/**
 * @author vneli
 * @since 1.0
 */
public class No57_插入区间 {
    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     *
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * @param args
     */
    public static void main(String[] args) {
        Solution571 solution = new Solution571();
        int[][] insert1 = solution.insert(new int[][]{}, new int[]{5, 7});
        int[][] insert = solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        System.out.println();
    }
}

class Solution571 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length, loc = 0;
        int[][] result = new int[n + 1][2];
        boolean notAdded = true;
        for (int i = 0; i < n; i++) {
            if (intervals[i][0] > newInterval[0] && notAdded) {
                result[loc++] = newInterval;
                notAdded = false;
            }
            result[loc++] = intervals[i];
        }
        if (notAdded) {
            result[loc] = newInterval;
        }
        List<int[]> list = new ArrayList<>();
        int left = result[0][0], right = result[0][1];
        for (int i = 1, length = n + 1; i < length; i++) {
            if (result[i][0] <= right) {
                if (result[i][1] > right) {
                    right = result[i][1];
                }
            }
            else {
                list.add(new int[]{left, right});
                left = result[i][0];
                right = result[i][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(int[][]::new);
    }
}
