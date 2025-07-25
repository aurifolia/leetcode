package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No56_合并区间 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(new int[][]{{1, 4}, {0, 5}});
        int[][] merge1 = solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println();
    }
}


class Solution56 {
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int length = intervals.length;
        List<int[]> data = new ArrayList<>();
        data.add(intervals[0]);
        for (int i = 1; i < length; i++) {
            boolean isNew = true;
            for (int j = 0; j < data.size(); j++) {
                if (isInclude(intervals[i], data.get(j))) {
                    data.get(j)[0] = Math.min(data.get(j)[0], intervals[i][0]);
                    data.get(j)[1] = Math.max(data.get(j)[1], intervals[i][1]);
                    isNew = false;
                    break;
                }
            }
            if (isNew) {
                data.add(intervals[i]);
            }
        }
        return data.toArray(new int[data.size()][]);
    }

    private boolean isInclude(int[] a, int[] b) {
        return !(a[1] < b[0] || a[0] > b[1]);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int length = intervals.length;
        List<int[]> result = new ArrayList<>(length);
        result.add(intervals[0]);
        for (int i = 1; i < length; i++) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
            }
            else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}