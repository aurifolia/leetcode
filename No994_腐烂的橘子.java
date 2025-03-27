import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 *
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * @author Peng Dan
 * @since 1.0
 */
public class No994_腐烂的橘子 {
    public static void main(String[] args) {
        Solution994 solution994 = new Solution994();
        int i = solution994.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 1}, {0, 1, 2}});
        System.out.println(i);
    }
}

class Solution994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] poll = queue.poll();
                // 上
                if (poll[0] - 1 >= 0 && grid[poll[0] - 1][poll[1]] == 1) {
                    grid[poll[0] - 1][poll[1]] = grid[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{poll[0] - 1, poll[1]});
                }
                // 下
                if (poll[0] + 1 < m && grid[poll[0] + 1][poll[1]] == 1) {
                    grid[poll[0] + 1][poll[1]] = grid[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{poll[0] + 1, poll[1]});
                }
                // 左
                if (poll[1] - 1 >= 0 && grid[poll[0]][poll[1] - 1] == 1) {
                    grid[poll[0]][poll[1] - 1] = grid[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{poll[0], poll[1] - 1});
                }
                // 右
                if (poll[1] + 1 < n && grid[poll[0]][poll[1] + 1] == 1) {
                    grid[poll[0]][poll[1] + 1] = grid[poll[0]][poll[1]] + 1;
                    queue.offer(new int[]{poll[0], poll[1] + 1});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        return max == 0 ? 0 : max - 2;
    }
}
